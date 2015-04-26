package android.jp.oathofcrimson.Graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.jp.oathofcrimson.Game.GameDisplay;

public class Drawing
{

    public static int[] getColour(String name)
    {
        // Named Colours
        if(name=="Black") {return new int[]{0, 0, 0};}
        if(name=="White") {return new int[]{255, 255, 255};}

        // Theme Colours
        if(name=="BattleGrass1") {return new int[]{224, 187, 112};}
        return new int[]{0, 0, 0};
    }

    public static Paint getPaint(String colour)
    {
        return getPaint(colour, 0);
    }

    public static Paint getPaint(String colour, int border)
    {
        Paint paint = new Paint();
        if(border > 0)
        {
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(border);
        }
        else {paint.setStyle(Paint.Style.FILL);}
        int[] rgb = getColour(colour);
        paint.setColor(Color.rgb(rgb[0], rgb[1], rgb[2]));
        return paint;
    }

    public static void imageDrawTile(Canvas canvas, Bitmap image, int sizeX, int sizeY)
    {
        int drawX = 0;
        int drawY = 0;
        while(drawX < GameDisplay.WIDTH)
        {
            while(drawY < GameDisplay.HEIGHT)
            {
                canvas.drawBitmap(image, drawX, drawY, null);
                drawY = drawY + sizeY;
            }
            drawX = drawX + sizeX;
            drawY = 0;
        }
    }

    public static void rectDraw(Canvas canvas, Paint paint, int drawX, int drawY, int sizeX, int sizeY)
    {
        Rect rect = new Rect(drawX, drawY, drawX+sizeX, drawY+sizeY);
        canvas.drawRect(rect, paint);
    }

    public static void screenFill(Canvas canvas, int r, int g, int b)
    {
        Rect rect = new Rect(0, 0, GameDisplay.WIDTH, GameDisplay.HEIGHT);
        Paint paint = new Paint();
        paint.setColor(Color.rgb(r, g, b));
        canvas.drawRect(rect, paint);
    }

    public static void textWrite(Canvas canvas, String text, String colour, int drawX, int drawY, int size)
    {
        Paint paint = new Paint();
        canvas.drawPaint(paint);
        int[] rgb = getColour(colour);
        paint.setColor(Color.rgb(rgb[0], rgb[1], rgb[2]));
        paint.setTextSize(size);
        canvas.drawText(text, drawX, drawY, paint);
    }
}