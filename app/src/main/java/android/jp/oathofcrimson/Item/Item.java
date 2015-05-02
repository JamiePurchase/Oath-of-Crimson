package android.jp.oathofcrimson.Item;

import android.graphics.Bitmap;

public abstract class Item
{
    private Bitmap drawIcon;
    private String itemName;

    public Item(String name, Bitmap icon)
    {
        this.itemName = name;
        this.drawIcon = icon;
    }

    public Bitmap getDrawIcon()
    {
        return this.drawIcon;
    }

    public String getItemName()
    {
        return this.itemName;
    }
}