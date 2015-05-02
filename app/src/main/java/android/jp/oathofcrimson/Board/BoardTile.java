package android.jp.oathofcrimson.Board;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class BoardTile
{
    private Bitmap tileImage;
    private boolean tileLayerActive;
    private Bitmap tileLayerImage;
    private int tileRaise;
    private boolean tileSolid;

    public BoardTile(Bitmap image, boolean solid)
    {
        this.tileImage = image;
        this.tileSolid = solid;

        // Default Properties
        this.tileLayerActive = false;
        this.tileRaise = 0;
    }

    public void render(Canvas canvas, int posX, int posY)
    {
        canvas.drawBitmap(this.tileImage, posX, posY, null);
    }

    public void setLayer(Bitmap image)
    {
        this.tileLayerActive = true;
        this.tileLayerImage = image;
    }

    public void setRaise(int amount)
    {
        this.tileRaise = amount;
    }

}