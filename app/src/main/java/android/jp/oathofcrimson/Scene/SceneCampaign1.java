package android.jp.oathofcrimson.Scene;

import android.graphics.Canvas;
import android.jp.oathofcrimson.Game.GameDisplay;
import android.jp.oathofcrimson.Graphics.Drawing;
import android.jp.oathofcrimson.State.StateBattle;
import android.view.MotionEvent;

public class SceneCampaign1 extends Scene
{
    private int tickCount;

    public SceneCampaign1()
    {
        this.tickCount = 0;
    }

    public void render(Canvas canvas)
    {
        Drawing.screenFill(canvas, 0, 0, 0);
        Drawing.textWrite(canvas, "Broken Sword", "White", 50, 500, 32);
        Drawing.textWrite(canvas, "Arudane Hillasken  -  17th June", "White", 50, 650, 24);
    }

    public void tick()
    {
        this.tickCount += 1;
    }

    public void touch(MotionEvent event)
    {
        GameDisplay.setState(new StateBattle());
    }
}