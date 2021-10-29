package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GildedRoseTest {

  @Test
  @DisplayName("test The decrementation of the name when it is different to Aged Brie, Sulfuras or " +
          "Backstage")
  void testQualityDecremented()
  {
    Item[] items = new Item[] { new Item("Elixir of the Mongoose", 0, 1) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.items[0].quality, is(0));
  }

  @DisplayName("test That the quality is equal to zero")
  @Test
  void testQualityEqualZero()
  {
    Item[] items = new Item[] { new Item("Elixir of the Mongoose", 0, 0) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.items[0].quality, is(0));
  }

  @Test
  @DisplayName("test for verifying Backsatge with quality lower than 50")
  void testQualityForBackstage()
  {
    Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert",12,42)};
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.items[0].quality, is(43));
  }

  @Test
  @DisplayName("test the quality for Aged Brie with quality lower than 50")
  void testQualityForAgedBrie()
  {

    Item[] items = new Item[] {new Item("Aged Brie", 1, 0) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.items[0].quality, is(1));
    assertThat(app.items[0].sellIn, is(0));
  }

  @Test
  @DisplayName("Test the quality is  unchanged for Sulfuras and it's 80")
  void testQualityForSulfuras()
  {
    Item[] items = new Item[] {new Item("Sulfuras, Hand of Ragnaros", -1, 80)};
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.items[0].quality, is(80));
  }

  @Test
  @DisplayName("Test the quality greater than 50 for Age Brie with a negative SellIn")
  void testQualityGreaterThan50WithSellInNegative()
  {

    Item[] items = new Item[] {new Item("Aged Brie", -2, 60) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.items[0].quality, is(60));
  }

  @Test
  @DisplayName("Test if the quality exceed 50 for Backstage")
  void testIfQualityExceeds50ForBackstage()
  {
    Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)};
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.items[0].quality, is(50));
  }

  @Test
  @DisplayName("Test that the quality for BackStage increased twice when the sellIn is lower than 11")
  void testBackstageQualityWithSellInLefterThan11()
  {
    Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert",10,42)};
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.items[0].quality, is(44));
    assertThat(app.items[0].sellIn, is(9));
  }

  @Test
  @DisplayName("Test that the quality for BackStage increased three times when the sellIn is lower than 6")
  void testBackstageQualityWithSellInLefterThan6()
  {
    Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert",5,43)};
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.items[0].quality, is(46));
    assertThat(app.items[0].sellIn, is(4));
  }

  @Test
  @DisplayName("Test that the quality for backstage is 0 when the sellIn is negative")
  void testBackstageQualityWithSellInNegative()
  {
    Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert",-1,3)};
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.items[0].quality,is(0));
  }

  @Test
  @DisplayName("test for other product with SellIn negative")
    // The quality decreased twice because first
    // It will verify the name and when it is another product the quality will decreased one time
    // And after it will verify the sellIn and again the name and if it is different, it will decreased the quality again"
  void testOtherProductWithSellInNegative()
  {
    Item[] items = new Item[] {new Item("Elixir of the Mongoose",-1,6)};
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.items[0].quality,is(4));
  }

  @Test
  @DisplayName("Test other product with their sellIn positive")
  void testOtherProductWithSellInPositive()
  {
    Item[] items = new Item[] {new Item("Elixir of the Mongoose",1,6)};
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.items[0].quality,is(5));
  }

  @Test
  @DisplayName("Test the Aged Brie With a negative SellIn")
  void testAgedBrieWithSellInNegative()
  {
    Item[] items = new Item[]{new Item("Aged Brie",-1,3)};
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertThat(app.items[0].quality,is(5));

  }

  @Test
  @DisplayName("Test the method toString()")
  void TestToString() {
    Item[] items = new Item[] { new Item("foo", -1, 10) };
    assertThat(items[0].toString(), is("foo, -1, 10"));
  }

}
