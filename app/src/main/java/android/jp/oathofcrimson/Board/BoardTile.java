package android.jp.oathofcrimson.Board;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.jp.oathofcrimson.Board.Entity.Action;
import android.jp.oathofcrimson.Board.Entity.Direction;

public class BoardTile
{
    private Board tileBoard;
    private Bitmap tileImage;
    private boolean tileSolid;
    private int tilePosX, tilePosY;
    private int tileRaise;

    public BoardTile(Board board, Bitmap image, boolean solid, int posX, int posY)
    {
        this.tileBoard = board;
        this.tileImage = image;
        this.tileSolid = solid;
        this.tilePosX = posX;
        this.tilePosY = posY;
        this.tileRaise = 0;
    }

    public int getRaise()
    {
        return this.tileRaise;
    }

    private int getRenderPosX()
    {
        return (this.tilePosX - this.tileBoard.getOffsetX()) * 32;
    }

    private int getRenderPosY()
    {
        return (this.tilePosY - this.tileBoard.getOffsetY()) * 32;
    }

    public boolean isFree()
    {
        if(this.isSolid()) {return false;}
        if(this.tileBoard.getEntityAt(this.tilePosX, this.tilePosY) != null) {return false;}
        // NOTE: should also ask the board if there are any collision zones ??
        return true;
    }

    public boolean isSolid()
    {
        return this.tileSolid;
    }

    public void render(Canvas canvas)
    {
        canvas.drawBitmap(this.tileImage, this.getRenderPosX(), this.getRenderPosY(), null);
    }

    public void setRaise(int amount)
    {
        this.tileRaise = amount;
    }

}