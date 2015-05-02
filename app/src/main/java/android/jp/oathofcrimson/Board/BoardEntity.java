package android.jp.oathofcrimson.Board;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;

public abstract class BoardEntity
{
    public abstract void render(Canvas canvas);
    public abstract void tick();

    // Animation
    private Bitmap[] animImage;

    // Tile Position
    private int tilePosX;
    private int tilePosY;

    public BoardEntity(Bitmap[] image)
    {
        this.animImage = image;
    }
}