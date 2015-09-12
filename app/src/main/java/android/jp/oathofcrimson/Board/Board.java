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
    // Board
    private int boardSizeX, boardSizeY, boardOffsetX, boardOffsetY;
    private boolean boardPause;

    // Terrain
    private BoardTile[][] terrain;

    // Entities
    private EntityPlayer entityPlayer;
    //private ArrayList<BoardEntityNpc> entityNpc;

    // Audio
    //private boolean audioAmbientSfxActive;
    //private boolean audioBackgroundActive;

    // Encounters
    //private boolean encounterActive;

    // Interface
    //private Control interfaceControl;
    //private boolean interfaceMinimap;
    //private boolean interfaceMission;

    // TEMP (need to get interfaceControl working)
    private final Rect interfaceControlArrowE = new Rect(150, 500, 200, 550);
    private final Rect interfaceControlArrowN = new Rect(95, 445, 145, 495);
    private final Rect interfaceControlArrowS = new Rect(95, 555, 145, 605);
    private final Rect interfaceControlArrowW = new Rect(40, 500, 90, 550);
    private final Rect interfaceControlPause = new Rect(1000, 40, 1100, 90);

    public Board(String template)
    {
        // Board
        this.boardSizeX = 12;
        this.boardSizeY = 6;
        this.boardOffsetX = 0;
        this.boardOffsetY = 0;
        this.boardPause = false;

        // Terrain
        this.terrain = new BoardTile[this.boardSizeX][this.boardSizeY];
        setTileAll(GameDisplay.assetImageTileGrass, false);

        // TEMP
        setTile(4, 4, GameDisplay.assetSheetBuildHouse.getImage(0, 0), true);
        setTile(5, 4, GameDisplay.assetSheetBuildHouse.getImage(1, 0), true);
        setTile(6, 4, GameDisplay.assetSheetBuildHouse.getImage(2, 0), true);
        setTile(7, 4, GameDisplay.assetSheetBuildHouse.getImage(3, 0), true);
        setTile(4, 5, GameDisplay.assetSheetBuildHouse.getImage(0, 1), true);
        setTile(5, 5, GameDisplay.assetSheetBuildHouse.getImage(1, 1), true);
        setTile(6, 5, GameDisplay.assetSheetBuildHouse.getImage(2, 1), true);
        setTile(7, 5, GameDisplay.assetSheetBuildHouse.getImage(3, 1), true);

        // Entities
        this.entityPlayer = new EntityPlayer(this, GameDisplay.assetSheetBoardUnit1, 3, 2, Direction.SOUTH);
        //this.entityNpc = new ArrayList();

        // Audio
        //this.audioAmbientSfxActive = false;
        //this.audioBackgroundActive = false;

        // Encounters
        //this.encounterActive = false;

        // Interface
        //this.interfaceControl = new Control(this);
    }

    public int getOffsetX()
    {
        return this.boardOffsetX;
    }

    public int getOffsetY()
    {
        return this.boardOffsetY;
    }

    public BoardEntity getEntityAt(int tileX, int tileY)
    {
        /*for(int entity = 0; entity < entityNpc.length; entity++)
        {
            // if entity exists here then return it
        }*/
        return null;
    }

    public BoardTile getTile(int tileX, int tileY)
    {
        return this.terrain[tileX][tileY];
    }

    public void render(Canvas canvas)
    {
        // NOTE: we need to create a huge Bitmap of terrain when the board is built
        // render the relevant subimage onto the screen rather than drawing individual tiles

        // Background (TEMP)
        Drawing.screenFill(canvas, "BLACK");

        // Render Tiles
        this.renderTiles(canvas);
        // TEMP
        /*canvas.drawBitmap(GameDisplay.assetSheetBuildHouse.getImage(0, 0), 64, 32, null);
        canvas.drawBitmap(GameDisplay.assetSheetBuildHouse.getImage(1, 0), 96, 32, null);*/

        // Render Entities
        this.renderEntity(canvas);

        // Render Interface
        if(!this.boardPause)
        {
            //this.interfaceControl.render(canvas);
            //this.renderInterfaceMinimap(canvas);
            // TEMP (need to get interfaceControl working)
            this.renderInterfaceUi(canvas);
        }
    }

    private void renderEntity(Canvas canvas)
    {
        this.entityPlayer.render(canvas);
        //this.renderEntityNpc(canvas);
    }

    /*private void renderEntityNpc(Canvas canvas)
    {
        for(int entity = 0; entity < entityNpc.length; entity++)
        {
            entityNpc[entity].render(canvas);
        }
    }*/

    /*private void renderInterfaceMinimap(Canvas canvas)
    {
        if(this.interfaceMinimap == true)
        {

        }
    }*/

    /*private void renderInterfaceMission(Canvas canvas)
    {
        if(this.interfaceMission == true)
        {

        }
    }*/

    // TEMP (need to get the interfaceControl working)
    private void renderInterfaceUi(Canvas canvas)
    {
        // Pause Button
        canvas.drawBitmap(GameDisplay.assetUiButtonBlank2, this.interfaceControlPause.left, this.interfaceControlPause.top, null);
        Drawing.textWrite(canvas, "PAUSE", "BLACK", this.interfaceControlPause.left, this.interfaceControlPause.top, 28);

        // Directional Arrows
        canvas.drawBitmap(GameDisplay.assetUiButtonArrowE, this.interfaceControlArrowE.left, this.interfaceControlArrowE.top, null);
        canvas.drawBitmap(GameDisplay.assetUiButtonArrowN, this.interfaceControlArrowN.left, this.interfaceControlArrowN.top, null);
        canvas.drawBitmap(GameDisplay.assetUiButtonArrowS, this.interfaceControlArrowS.left, this.interfaceControlArrowS.top, null);
        canvas.drawBitmap(GameDisplay.assetUiButtonArrowW, this.interfaceControlArrowW.left, this.interfaceControlArrowW.top, null);
    }

    private void renderTiles(Canvas canvas)
    {
        // NOTE: this currently renders tiles in the right place but iterates through all tiles (not limited to screen size)
        // eventually, this will only be needed when the board is first created (to generate the huge terrain bitmap)
        for(int col = 0; col < this.boardSizeX; col++)
        {
            for(int row = 0; row < this.boardSizeY; row++)
            {
                this.terrain[col - this.boardOffsetX][row - this.boardOffsetY].render(canvas);
            }
        }
    }

    private void setTile(int tileX, int tileY, Bitmap image, boolean solid)
    {
        this.terrain[tileX][tileY] = new BoardTile(this, image, solid, tileX, tileY);
    }

    private void setTileAll(Bitmap image, boolean solid)
    {
        for(int col = 0; col < boardSizeX; col++)
        {
            for(int row = 0; row < boardSizeY; row++)
            {
                this.setTile(col, row, image, solid);
            }
        }
    }

    public void tick()
    {
        if(!this.boardPause) {this.tickEntity();}
        // NOTE: may be more things that require a tick method
    }

    private void tickEntity()
    {
        this.entityPlayer.tick();
        //this.tickEntityNpc();
    }

    /*private void tickEntityNpc()
    {
        for(int entity = 0; entity < entityNpc.length; entity++)
        {
            entityNpc[entity].tick();
        }
    }*/

    public void touch(MotionEvent event)
    {
        if(this.boardPause)
        {
            // NOTE: pause menu?
            this.boardPause = false;
        }
        else {this.touchUi(event);}
        // NOTE: consider touch event when message box is displayed
        // NOTE: consider touch event when interaction is possible (eg: talking, harvesting, unlocking)
    }

    private void touchUi(MotionEvent event)
    {
        // Pause Button
        if(this.interfaceControlPause.contains((int) event.getX(), (int) event.getY())) {this.boardPause = true;}

        // Directional Arrows
        if(this.interfaceControlArrowE.contains((int) event.getX(), (int) event.getY())) {this.entityPlayer.walk(Direction.EAST);}
        if(this.interfaceControlArrowN.contains((int) event.getX(), (int) event.getY())) {this.entityPlayer.walk(Direction.NORTH);}
        if(this.interfaceControlArrowS.contains((int) event.getX(), (int) event.getY())) {this.entityPlayer.walk(Direction.SOUTH);}
        if(this.interfaceControlArrowW.contains((int) event.getX(), (int) event.getY())) {this.entityPlayer.walk(Direction.WEST);}
    }

}