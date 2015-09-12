package android.jp.oathofcrimson.Board;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.jp.oathofcrimson.Game.GameDisplay;
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
    private boolean interfaceMinimap;
    private boolean interfaceMission;

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
        this.tileHigh = 6;
        this.tileWide = 6;

        // Temp Tiles
        this.tileGrid = new BoardTile[this.tileHigh][this.tileWide];
        setTileAll(GameDisplay.assetImageTileGrass, false);
    }

    public void render(Canvas canvas)
    {
        // Render Tiles
        renderTiles(canvas);

        // Render Entities
        renderEntityNpc(canvas);

        // Render Interface
        renderInterfaceMinimap(canvas);
    }

    public void renderEntityNpc(Canvas canvas)
    {
        for(int entity = 0; entity < entityNpc.length; entity++)
        {
            entityNpc[entity].render(canvas);
        }
    }

    public void renderInterfaceMinimap(Canvas canvas)
    {
        if(this.interfaceMinimap == true)
        {

        }
    }

    public void renderInterfaceMission(Canvas canvas)
    {
        if(this.interfaceMission == true)
        {

        }
    }

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

    public void setTileAll(Bitmap image, boolean solid)
    {
        for(int col = 0; col < tileWide; col++)
        {
            for(int row = 0; row < tileHigh; row++)
            {
                this.tileGrid[col][row] = new BoardTile(GameDisplay.assetImageTileGrass, false);
            }
        }
    }

    public void tick()
    {

    }

    public void touch(MotionEvent event)
    {
        GameDisplay.setState(new StateBattle());
    }

}