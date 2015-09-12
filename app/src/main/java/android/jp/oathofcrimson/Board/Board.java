package android.jp.oathofcrimson.Board;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.jp.oathofcrimson.Board.Interface.Control;
import android.jp.oathofcrimson.Game.GameDisplay;
import android.jp.oathofcrimson.Graphics.Drawing;
import android.jp.oathofcrimson.State.StateBattle;
import android.view.MotionEvent;

public class Board
{
    // Audio
    private boolean audioAmbientSfxActive;
    private boolean audioBackgroundActive;

    // Encounters
    private boolean encounterActive;

    // Entities
    private BoardEntityNpc[] entityNpc = new BoardEntityNpc[10];

    // Interface
    //private Control interfaceControl;
    //private boolean interfaceMinimap;
    //private boolean interfaceMission;

    // Tiles
    private BoardTile[][] tileGrid;
    private int tileHigh;
    private int tileWide;

    public Board(String template)
    {
        // Temp
        this.audioAmbientSfxActive = false;
        this.audioBackgroundActive = false;
        this.encounterActive = false;
        this.tileHigh = 4;
        this.tileWide = 4;

        // Interface
        //this.interfaceControl = new Control(this);

        // Temp Tiles
        this.tileGrid = new BoardTile[this.tileHigh][this.tileWide];
        setTileAll(GameDisplay.assetImageTileGrass, false);
    }

    public void render(Canvas canvas)
    {
        // Background (TEMP)
        Drawing.screenFill(canvas, "BLACK");

        // Render Tiles
        this.renderTiles(canvas);

        // Render Entities
        //renderEntityNpc(canvas);

        // Render Interface
        //this.interfaceControl.render(canvas);
        //this.renderInterfaceMinimap(canvas);

        // TEMP
        Drawing.imageDraw(canvas, GameDisplay.assetSheetBoardUnit1.getImage(0, 0), 0, 0);

        // TEMP
        Drawing.imageDraw(canvas, GameDisplay.assetSheetBuildHouse.getImage(0, 0), 64, 32);
        Drawing.imageDraw(canvas, GameDisplay.assetSheetBuildHouse.getImage(1, 0), 96, 32);
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

    }

    public void touch(MotionEvent event)
    {
        //GameDisplay.setState(new StateBattle());
    }

}