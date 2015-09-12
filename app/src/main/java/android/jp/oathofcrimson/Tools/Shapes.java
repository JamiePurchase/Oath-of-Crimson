package android.jp.oathofcrimson.Tools;

import android.graphics.Rect;

public class Shapes
{

    public static Rect rectOffset(Rect original, int offsetX, int offsetY)
    {
        return new Rect(original.left + offsetX, original.top + offsetY, original.right + offsetX, original.bottom + offsetY);
    }

}