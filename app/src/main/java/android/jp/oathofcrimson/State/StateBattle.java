package android.jp.oathofcrimson.State;

import android.graphics.Canvas;
import android.jp.oathofcrimson.Game.GameDisplay;
import android.view.MotionEvent;

public class StateBattle extends State
{
    public StateBattle()
    {

    }

    public void render(Canvas canvas)
    {
        drawBackground(canvas);
    }

    public void drawBackground(Canvas canvas)
    {
        canvas.drawBitmap(GameDisplay.assetBkgBattle, 0, 0, null);
    }

    public void tick()
    {

    }

    public void touch(MotionEvent event)
    {
        GameDisplay.setState(new StateBattle());
    }
}