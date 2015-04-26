package android.jp.oathofcrimson;

import android.graphics.Canvas;
import android.view.MotionEvent;

public class StateTitle extends State
{
    public StateTitle()
    {

    }

    public void render(Canvas canvas)
    {
        drawBackground(canvas);
    }

    public void drawBackground(Canvas canvas)
    {
        canvas.drawBitmap(GameDisplay.assetBkgTitle, 0, 0, null);
    }

    public void tick()
    {

    }

    public void touch(MotionEvent event)
    {
        GameDisplay.setState(new StateBattle());
    }
}