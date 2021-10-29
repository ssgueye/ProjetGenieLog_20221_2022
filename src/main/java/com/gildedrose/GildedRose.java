package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {

        this.items = items;
    }

    private void qualityIncreased(Item item)
    {
        if (item.quality < 50)
        {
            item.quality = item.quality + 1;
        }
    }

    private void qualityDecreased(Item item)
    {
        if (item.quality > 0) {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.quality = item.quality - 1;
            }
        }
    }

    private void sellInDecreased(Item item)
    {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void qualityNull(Item item)
    {
        item.quality = 0;
    }

    private void updateItem(Item item)
    {
        /*if (!item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            qualityDecreased(item);
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn < 11) {
                        qualityIncreased(item);
                    }

                    if (item.sellIn < 6) {
                        qualityIncreased(item);
                    }
                }
            }
        }

        sellInDecreased(item);

        if (item.sellIn < 0) {
            if (!item.name.equals("Aged Brie")) {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    qualityDecreased(item);
                } else {
                    qualityNull(item);
                }
            } else {
                qualityIncreased(item);
            }
        }*/


    }


    public void updateQuality()
    {
        for (Item item : items) {
            updateItem(item);
        }
    }
}