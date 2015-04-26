package android.jp.oathofcrimson.State;

import android.graphics.Canvas;
import android.jp.oathofcrimson.Game.GameDisplay;
import android.jp.oathofcrimson.Graphics.Drawing;
import android.view.MotionEvent;

public class StateScene extends State
{
    private int sceneTick;

    public StateScene()
    {
        // Consider passing a scene object to this constructor and having the render and tick
        // (and maybe touch) methods call scene.render(canvas), scene.tick() and suchlike
        // A scene object could know its duration, frames, audio, etc...
        sceneTick = 0;
    }

    public void render(Canvas canvas)
    {
        Drawing.screenFill(canvas, 0, 0, 0);
        Drawing.textWrite(canvas, "Broken Sword", "White", 50, 500, 32);
        Drawing.textWrite(canvas, "Arudane Hillasken  -  17th June", "White", 50, 650, 24);
    }

    public void tick()
    {
        sceneTick = sceneTick + 1;
        if(sceneTick > 200)
        {
            GameDisplay.setState(new StateBattle());
        }
    }

    public void touch(MotionEvent event)
    {

    }
}