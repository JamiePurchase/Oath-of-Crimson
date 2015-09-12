package android.jp.oathofcrimson.State;

import android.graphics.Canvas;
import android.jp.oathofcrimson.Board.Board;
import android.jp.oathofcrimson.Graphics.Drawing;
import android.view.MotionEvent;

public class StateBoard extends State
{
    // Board
    private Board stateBoard;
    private boolean stateRunning;

    // Menu
    private boolean stateMenu;

    public StateBoard()
    {
        // Board
        this.stateBoard = new Board("test");
        this.stateRunning = true;

        // Menu
        this.stateMenu = false;
    }

    public void render(Canvas canvas)
    {
        if(this.stateMenu) {this.renderMenu(canvas);}
        else {stateBoard.render(canvas);}
    }

    private void renderMenu(Canvas canvas)
    {
        Drawing.screenFill(canvas, "BLACK");
        Drawing.textWrite(canvas, "PAUSE", "WHITE", 200, 150, 64);
    }

    public void tick()
    {
        if(this.stateRunning) {stateBoard.tick();}
    }

    public void touchAction(MotionEvent event)
    {
        if(this.stateRunning) {stateBoard.touch(event);}
    }

    public void touchEdge(MotionEvent event)
    {
        // TEST
        /*if(!this.stateMenu)
        {
            this.stateRunning = false;
            this.stateMenu = true;
        }*/
    }

}