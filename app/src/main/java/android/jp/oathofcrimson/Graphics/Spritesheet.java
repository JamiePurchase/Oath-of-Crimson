package android.jp.oathofcrimson.Graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Spritesheet
{
    private Bitmap sheet;
    private int imgWide;
    private int imgHigh;

    public Spritesheet(Bitmap sheet, int wide, int high)
    {
        this.sheet = sheet;
        this.imgWide = wide;
        this.imgHigh = high;
    }

    public Bitmap getImage(int imageX, int imageY)
    {
        return Bitmap.createBitmap(this.sheet, imageX * imgWide, imageY * imgHigh, imgWide, imgHigh);
    }

    public void drawSprite(Canvas canvas, int drawX, int drawY, int sheetX, int sheetY)
    {
        int spriteX = (sheetX * imgWide) - imgWide;
        int spriteY = (sheetY * imgHigh) - imgHigh;
        Rect rectSprite = new Rect(spriteX, spriteY, imgWide, imgHigh);
        Rect rectTarget = new Rect(drawX, drawY, imgWide, imgHigh);
        canvas.drawBitmap(sheet, rectSprite, rectTarget, null);
    }
}