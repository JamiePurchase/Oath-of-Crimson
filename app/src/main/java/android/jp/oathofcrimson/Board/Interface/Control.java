package android.jp.oathofcrimson.Board.Interface;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.jp.oathofcrimson.Board.Board;
import android.jp.oathofcrimson.Graphics.Drawing;

public class Control
{
    private Board controlBoard;

    public Control(Board board)
    {
        this.controlBoard = board;
    }

    public void render(Canvas canvas)
    {
        // TEMP
        Drawing.rectFill(canvas, "MenuGreen", new Rect(50, 500, 100, 550));
    }

}