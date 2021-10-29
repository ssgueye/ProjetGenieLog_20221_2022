package com.gildedrose;

class GildedRose {

    Item[] items;
    private final int TenDaysBeforeExpired = 10;
    private final int FiveDaysBeforeExpired = 5;
    private final int QualityMaxValue = 49;

    public GildedRose(Item[] items)
    {
        this.items = items;
    }

    private void qualityIncreased(Item item)
    {
        if (item.quality <= QualityMaxValue)
        {
            item.quality++;
        }
    }

    private void qualityDecreased(Item item)
    {
        if (item.quality > 0)
        {
              item.quality--;
        }
    }

    private void sellInDecreased(Item item)
    {
         item.sellIn--;
    }

    private void qualityNull(Item item)
    {
        item.quality = 0;
    }

    private void nearToExpired(Item item)
    {
        if(item.sellIn <= TenDaysBeforeExpired)
        {
            qualityIncreased(item);
        }

        if(item.sellIn <= FiveDaysBeforeExpired)
        {
            qualityIncreased(item);
        }
    }

    private void updateItem(Item item)
    {
        switch(item.name)
        {
            case "Aged Brie":
                qualityIncreased(item);
                sellInDecreased(item);

                if(item.sellIn < 0)
                {
                    qualityIncreased(item);
                }
                break;

            case "Backstage passes to a TAFKAL80ETC concert":
                qualityIncreased(item);
                nearToExpired(item);
                sellInDecreased(item);

                if(item.sellIn < 0)
                {
                    qualityNull(item);
                }
                break;

            case "Sulfuras, Hand of Ragnaros":
                //Nothing to Do
                break;

            default:
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
        for (Item item : items)
        {
            updateItem(item);
        }
    }
}