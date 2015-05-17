package android.jp.oathofcrimson.Scene;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.jp.oathofcrimson.Game.GameDisplay;
import android.jp.oathofcrimson.Graphics.Drawing;
import android.jp.oathofcrimson.State.StateBattle;
import android.jp.oathofcrimson.State.StateMenu;
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
        Drawing.textWrite(canvas, "Broken Sword", "WHITE", 50, 500, 32);
        Drawing.textWrite(canvas, "Arudane Hillasken  -  17th June", "WHITE", 50, 650, 24);
    }

    public void tick()
    {
        this.tickCount += 1;
        if(tickCount == 60) {GameDisplay.setState(new StateBattle());}
    }

    public void touch(MotionEvent event)
    {
        GameDisplay.setState(new StateBattle());
        //GameDisplay.setState(new StateMenu());
    }
}