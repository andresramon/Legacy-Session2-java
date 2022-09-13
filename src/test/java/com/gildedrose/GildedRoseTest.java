package com.gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {


    @Test
    public void checkWhenQualityIsZeroNeverChangesToNegative(){

        Item item = new Item("any name", 1, 0);
        GildedRose gildedRose = new GildedRose(new Item[] {item});
        gildedRose.updateQuality();

        Assertions.assertTrue(item.quality == 0, "Quality cannot be negative");

    }

    @Test
    public void qualityOfAnItemDropsWithTime(){

        Item item = new Item("any name", 1, 1);
        GildedRose gildedRose = new GildedRose(new Item[] {item});
        gildedRose.updateQuality();

        Assertions.assertTrue(item.quality == 0, "Quality cannot be negative");

    }

    @Test
    public void itemQualityDropsAfterDueDate() {
        Item item = new Item("any name", -1, 2);
        GildedRose gildedRose = new GildedRose(new Item[] {item});
        gildedRose.updateQuality();

        Assertions.assertTrue(item.quality == 0, "Quality cannot be negative");
    }

    @Test
    public void itemQualityDoesntDropAfterDueDateIfItIsAlreadyZero() {
        Item item = new Item("any name", -1, 0);
        GildedRose gildedRose = new GildedRose(new Item[] {item});
        gildedRose.updateQuality();

        Assertions.assertTrue(item.quality == 0, "Quality cannot be negative");
    }

    @Test
    public void agedBrieQualityIncreasesWithTime() {
        Item item = new Item("Aged Brie", 1, 2);
        GildedRose gildedRose = new GildedRose(new Item[] {item});
        gildedRose.updateQuality();

        Assertions.assertTrue(item.quality > 2, "Quality has to be greater thar initial");
    }

    @Test
    public void backStagePassesQualityIncreasesWithTime() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 2);
        GildedRose gildedRose = new GildedRose(new Item[] {item});
        gildedRose.updateQuality();

        Assertions.assertTrue(item.quality > 2, "Quality has to be greater thar initial");
    }

    @Test
    public void backstagePassesQualityDropsToZeroAfterDueDate() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 10);
        GildedRose gildedRose = new GildedRose(new Item[] {item});
        gildedRose.updateQuality();

        Assertions.assertTrue(item.quality == 0, "Quality has to be 0 after due date");
    }

    @Test
    public void agedBrieQualityIncreasesAfterDueDate() {
        Item item = new Item("Aged Brie", -1, 2);
        GildedRose gildedRose = new GildedRose(new Item[] {item});
        gildedRose.updateQuality();

        Assertions.assertTrue(item.quality > 2, "Quality has to be greater thar initial");
    }

    @Test
    public void agedBrieQualityDontIncreasesAfterDueDateIfIts50() {
        Item item = new Item("Aged Brie", -1, 50);
        GildedRose gildedRose = new GildedRose(new Item[] {item});
        gildedRose.updateQuality();

        Assertions.assertTrue(item.quality == 50, "Quality cannot be greater than 50");
    }

    @Test
    public void sulfurasQualityNeverChanges() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 80);
        GildedRose gildedRose = new GildedRose(new Item[] {item});
        gildedRose.updateQuality();

        Assertions.assertTrue(item.quality == 80, "Quality of Sulfuras never changes");
    }

    @Test
    public void sulfurasDueDateNeverChanges() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 80);
        GildedRose gildedRose = new GildedRose(new Item[] {item});
        gildedRose.updateQuality();

        Assertions.assertTrue(item.sellIn == 10, "Due date of Sulfuras never changes");
    }

}
