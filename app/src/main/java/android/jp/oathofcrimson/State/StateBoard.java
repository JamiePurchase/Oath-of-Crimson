package android.jp.oathofcrimson.State;

import android.graphics.Canvas;
import android.jp.oathofcrimson.Board.Board;
import android.view.MotionEvent;

public class StateBoard extends State
{
    private Board board;

    public StateBoard()
    {
        // NOTE: Consider passing the battle into this constructor
        this.board = new Board("test");
    }

    public void render(Canvas canvas)
    {
        board.render(canvas);
    }

    public void tick()
    {
        board.tick();
    }

    public void touch(MotionEvent event)
    {
        board.touch(event);
    }
}