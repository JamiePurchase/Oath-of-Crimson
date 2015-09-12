package android.jp.oathofcrimson.Board;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.jp.oathofcrimson.Board.Entity.Direction;
import android.jp.oathofcrimson.Board.Entity.EntityPlayer;
import android.jp.oathofcrimson.Board.Interface.Control;
import android.jp.oathofcrimson.Game.GameDisplay;
import android.jp.oathofcrimson.Graphics.Drawing;
import android.jp.oathofcrimson.State.StateBattle;
import android.view.MotionEvent;

public class Board
{
    // Audio
    //private boolean audioAmbientSfxActive;
    //private boolean audioBackgroundActive;

    // Encounters
    //private boolean encounterActive;

    // Entities
    private EntityPlayer entityPlayer;
    //private BoardEntityNpc[] entityNpc = new BoardEntityNpc[10];

    // Interface
    //private Control interfaceControl;
    //private boolean interfaceMinimap;
    //private boolean interfaceMission;

    // TEMP (need to get interfaceControl working)
    /*private final Rect interfaceControlArrowE = new Rect(150, 500, 200, 550);
    private final Rect interfaceControlArrowN = new Rect(95, 445, 145, 495);
    private final Rect interfaceControlArrowS = new Rect(95, 555, 145, 605);
    private final Rect interfaceControlArrowW = new Rect(40, 500, 90, 550);*/

    // Tiles
    private BoardTile[][] tileGrid;
    private int tileHigh;
    private int tileWide;

    // TEMP
    private int offsetX, offsetY;

    public Board(String template)
    {
        // Temp
        //this.audioAmbientSfxActive = false;
        //this.audioBackgroundActive = false;
        //this.encounterActive = false;
        this.tileHigh = 4;
        this.tileWide = 4;
        this.offsetX = 0;
        this.offsetY = 0;

        // Entities
        this.entityPlayer = new EntityPlayer(this, GameDisplay.assetSheetBoardUnit1, 3, 2, Direction.SOUTH);

        // Interface
        //this.interfaceControl = new Control(this);

        // Temp Tiles
        this.tileGrid = new BoardTile[this.tileHigh][this.tileWide];
        setTileAll(GameDisplay.assetImageTileGrass, false);
    }

    public int getOffsetX()
    {
        return this.offsetX;
    }

    public int getOffsetY()
    {
        return this.offsetY;
    }

    public void render(Canvas canvas)
    {
        // Background (TEMP)
        Drawing.screenFill(canvas, "BLACK");

        // Render Tiles
        this.renderTiles(canvas);

        // Render Entities
        this.entityPlayer.render(canvas);
        //renderEntityNpc(canvas);

        // Render Interface
        //this.interfaceControl.render(canvas);

        // TEMP (need to get interfaceControl working)
        /*canvas.drawBitmap(GameDisplay.assetUiButtonArrowE, this.interfaceControlArrowE.left, this.interfaceControlArrowE.top, null);
        canvas.drawBitmap(GameDisplay.assetUiButtonArrowN, this.interfaceControlArrowN.left, this.interfaceControlArrowN.top, null);
        canvas.drawBitmap(GameDisplay.assetUiButtonArrowS, this.interfaceControlArrowS.left, this.interfaceControlArrowS.top, null);
        canvas.drawBitmap(GameDisplay.assetUiButtonArrowW, this.interfaceControlArrowW.left, this.interfaceControlArrowW.top, null);*/

        //this.renderInterfaceMinimap(canvas);

        // TEMP
        //Drawing.imageDraw(canvas, GameDisplay.assetSheetBuildHouse.getImage(0, 0), 64, 32);
        //Drawing.imageDraw(canvas, GameDisplay.assetSheetBuildHouse.getImage(1, 0), 96, 32);
    }

    /*public void renderEntityNpc(Canvas canvas)
    {
        for(int entity = 0; entity < entityNpc.length; entity++)
        {
            entityNpc[entity].render(canvas);
        }
    }*/

    /*public void renderInterfaceMinimap(Canvas canvas)
    {
        if(this.interfaceMinimap == true)
        {

        }
    }*/

    /*public void renderInterfaceMission(Canvas canvas)
    {
        if(this.interfaceMission == true)
        {

        }
    }*/

    public void renderTiles(Canvas canvas)
    {
        for(int col = 0; col < tileWide; col++)
        {
            for(int row = 0; row < tileHigh; row++)
            {
                this.tileGrid[col][row].render(canvas, 32 * col, 32 * row);
            }
        }
    }

    public void setTile(int tileX, int tileY, Bitmap image, boolean solid)
    {
        this.tileGrid[tileX][tileY] = new BoardTile(image, solid);
    }

    public void setTileAll(Bitmap image, boolean solid)
    {
        for(int col = 0; col < tileWide; col++)
        {
            for(int row = 0; row < tileHigh; row++)
            {
                setTile(col, row, image, solid);
            }
        }
    }

    public void tick()
    {
        // Entities
        //this.entityPlayer.tick();
    }

    public void touch(MotionEvent event)
    {
        //GameDisplay.setState(new StateBattle());

        // TEST
        /*if(this.interfaceControlArrowE.contains((int) event.getX(), (int) event.getY())) {this.entityPlayer.walk(Direction.EAST);}
        if(this.interfaceControlArrowN.contains((int) event.getX(), (int) event.getY())) {this.entityPlayer.walk(Direction.NORTH);}
        if(this.interfaceControlArrowS.contains((int) event.getX(), (int) event.getY())) {this.entityPlayer.walk(Direction.SOUTH);}
        if(this.interfaceControlArrowW.contains((int) event.getX(), (int) event.getY())) {this.entityPlayer.walk(Direction.WEST);}*/
    }

}