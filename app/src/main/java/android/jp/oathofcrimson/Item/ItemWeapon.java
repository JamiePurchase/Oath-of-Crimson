package android.jp.oathofcrimson.Item;

import android.graphics.Bitmap;

public class ItemWeapon extends Item
{
    private int statDamage;

    public ItemWeapon(String name, Bitmap icon, int damage)
    {
        super(name, icon);
        this.statDamage = damage;
    }

    public int getStatDamage()
    {
        return this.statDamage;
    }
}