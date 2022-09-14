package com.gildedrose;

import org.approvaltests.Approvals;
import org.approvaltests.reporters.DiffReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

@UseReporter(DiffReporter.class)
public class GildedRoseApprovalPOCTest{

    @Test
    public void sulfuraTest(){

        Item[] items = new Item[] {new Item("Sulfuras, Hand of Ragnaros", 5, 20),
            new Item("Sulfuras, Hand of Ragnaros", 2, 10),
            new Item("Sulfuras, Hand of Ragnaros", 6, 30),
            new Item("Sulfuras, Hand of Ragnaros", 0, 1),
            new Item("Sulfuras, Hand of Ragnaros", 11, 10),
            new Item("Sulfuras, Hand of Ragnaros", 10, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();


        Approvals.verifyAll("Items", items);
    }

    @Test
    public void backStageTest(){

        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 1, 2),
            new Item("Backstage passes to a TAFKAL80ETC concert", -1, 10),
            new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();


        Approvals.verifyAll("Items", items);
    }

    @Test
    public void agedBrieTest(){

        Item[] items = new Item[] {
            new Item("Aged Brie", -1, 2),
            new Item("Aged Brie", -1, 50),
            new Item("Aged Brie", 10, 10),
            new Item("Aged Brie", -1, 0),
            new Item("Aged Brie", 11, 10),
            new Item("Aged Brie", 10, 80),
            new Item("Aged Brie", 0, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();


        Approvals.verifyAll("Items", items);
    }

    @Test
    public void anyProductTest(){

        Item[] items = new Item[] {
            new Item("Any name", 1, 0),
            new Item("Any name", -1, 0),
            new Item("Any name", -1, 2),
            new Item("Any name", 1, 1),
            new Item("Any name", 11, 10),
            new Item("Any name", 10, 80),
            new Item("Any name", 0, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();


        Approvals.verifyAll("Items", items);
    }

}
