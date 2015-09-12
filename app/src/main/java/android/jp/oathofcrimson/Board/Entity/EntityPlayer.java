package android.jp.oathofcrimson.Board.Entity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.jp.oathofcrimson.Board.Board;
import android.jp.oathofcrimson.Board.BoardTile;
import android.jp.oathofcrimson.Graphics.Spritesheet;

public class EntityPlayer
{
    // Player
    private Board playerBoard;

    // Animation
    private Spritesheet playerSprite;
    private int playerAnimTick, playerAnimFrame;

    // Position
    private int playerPosX;
    private int playerPosY;
    private Direction playerFace;

    // Action
    private Action playerAction;

    public EntityPlayer(Board board, Spritesheet sprite, int posX, int posY, Direction posF)
    {
        // Player
        this.playerBoard = board;

        // Animation
        this.playerSprite = sprite;
        this.playerAnimTick = 0;
        this.playerAnimFrame = 0;

        // Position
        this.playerPosX = posX;
        this.playerPosY = posY;
        this.playerFace = posF;

        // Action
        this.playerAction = Action.IDLE;
    }

    private boolean getMovePossible()
    {
        BoardTile destination = getTileFace();
        if(destination == null) {return false;}
        return destination.isFree();
    }

    private Bitmap getRenderImage()
    {
        int posX = 1;
        if(this.playerAction == Action.WALK)
        {
            if(this.playerAnimFrame == 0) {posX = 0;}
            if(this.playerAnimFrame == 2) {posX = 2;}
        }
        int posY = 0;
        if(this.playerFace == Direction.WEST) {posY = 1;}
        if(this.playerFace == Direction.EAST) {posY = 2;}
        if(this.playerFace == Direction.NORTH) {posY = 3;}
        return this.playerSprite.getImage(posX, posY);
    }

    private int getRenderPosX()
    {
        int offsetX = 0;
        if(this.playerAction == Action.WALK)
        {
            if(this.playerFace == Direction.EAST) {offsetX = 8 * (this.playerAnimFrame + 1);}
            if(this.playerFace == Direction.WEST) {offsetX = 0 - (8 * (this.playerAnimFrame + 1));}
        }
        return (this.playerPosX - this.playerBoard.getOffsetX()) * 32 + offsetX;
    }

    private int getRenderPosY()
    {
        int offsetY = 0;
        if(this.playerAction == Action.WALK)
        {
            if(this.playerFace == Direction.NORTH) {offsetY = 0 - (8 * (this.playerAnimFrame + 1));}
            if(this.playerFace == Direction.SOUTH) {offsetY = 8 * (this.playerAnimFrame + 1);}
        }
        return (this.playerPosY - this.playerBoard.getOffsetY()) * 32 + offsetY;
    }

    private BoardTile getTileFace()
    {
        int tileX = this.playerPosX;
        int tileY = this.playerPosY;
        if(this.playerFace == Direction.EAST) {tileX += 1;}
        if(this.playerFace == Direction.NORTH) {tileY -= 1;}
        if(this.playerFace == Direction.SOUTH) {tileY += 1;}
        if(this.playerFace == Direction.WEST) {tileX -= 1;}
        return this.playerBoard.getTile(tileX, tileY);
    }

    public void render(Canvas canvas)
    {
        canvas.drawBitmap(this.getRenderImage(), this.getRenderPosX(), this.getRenderPosY(), null);
    }

    public void tick()
    {
        this.tickAnim();
    }

    private void tickAnim()
    {
        if(this.playerAction == Action.WALK)
        {
            this.playerAnimTick += 1;
            if(this.playerAnimTick >= 12)
            {
                this.playerAnimTick = 0;
                this.playerAnimFrame += 1;
                if(this.playerAnimFrame > 3)
                {
                    this.playerAnimFrame = 0;
                    this.playerAction = Action.IDLE;
                    if(this.playerFace == Direction.EAST) {this.playerPosX += 1;}
                    if(this.playerFace == Direction.NORTH) {this.playerPosY -= 1;}
                    if(this.playerFace == Direction.SOUTH) {this.playerPosY += 1;}
                    if(this.playerFace == Direction.WEST) {this.playerPosX -= 1;}
                }
            }
        }
    }

    public void walk(Direction direction)
    {
        if(this.playerAction == Action.IDLE)
        {
            this.playerFace = direction;
            if(this.getMovePossible())
            {
                this.playerAction = Action.WALK;
                this.playerAnimTick = 0;
                this.playerAnimFrame = 0;
            }
        }
    }

}