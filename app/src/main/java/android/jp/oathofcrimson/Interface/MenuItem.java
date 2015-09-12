package android.jp.oathofcrimson.Interface;

import android.graphics.Canvas;
import android.jp.oathofcrimson.Graphics.Drawing;

public class MenuItem
{
    // Details
    private String itemTitle;

    // Animation
    private int animDrawX;
    private int animDrawY;
    private int animSizeX;
    private int animSizeY;

    public MenuItem(String title, int drawX, int drawY, int sizeX, int sizeY)
    {
        this.itemTitle = title;
        this.animDrawX = drawX;
        this.animDrawY = drawY;
        this.animSizeX = sizeX;
        this.animSizeY = sizeY;
    }

    public void render(Canvas canvas)
    {
        Drawing.rectDraw(canvas, "BLACK", this.animDrawX, this.animDrawY, this.animSizeX, this.animSizeY);
        Drawing.textWrite(canvas, this.itemTitle, "BLACK", this.animDrawX + 5, this.animDrawY + 5, 22);
    }
}