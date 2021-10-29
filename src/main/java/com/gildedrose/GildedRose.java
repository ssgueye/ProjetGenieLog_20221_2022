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

        if(item.name.equals("Aged Brie"))
        {
            qualityIncreased(item);
            sellInDecreased(item);

            if(item.sellIn < 0)
            {
                qualityIncreased(item);
            }
        }

        else if(item.name.equals("Backstage passes to a TAFKAL80ETC concert"))
        {
            qualityIncreased(item);
            if(item.sellIn <= 10)
            {
                qualityIncreased(item);
            }

            if(item.sellIn <= 5)
            {
                qualityIncreased(item);
            }

            sellInDecreased(item);
            if(item.sellIn < 0)
            {
                qualityNull(item);
            }

        }

        else if(item.name.equals("Sulfuras, Hand of Ragnaros"))
        {
            //Nothing to do
        }

        else
        {
            qualityDecreased(item);
            sellInDecreased(item);
            if(item.sellIn < 0)
            {
                qualityDecreased(item);
            }
        }
    }


    public void updateQuality()
    {
        for (Item item : items) {
            updateItem(item);
        }
    }
}