package android.jp.oathofcrimson.State;

import android.graphics.Canvas;
import android.jp.oathofcrimson.Game.GameDisplay;
import android.jp.oathofcrimson.Scene.Scene;
import android.jp.oathofcrimson.Scene.SceneCampaign1;
import android.view.MotionEvent;

public class StateScene extends State
{
    private Scene scene;

    public StateScene()
    {
        // Consider passing a scene object to this constructor and having the render and tick
        // (and maybe touch) methods call scene.render(canvas), scene.tick() and suchlike
        // A scene object could know its duration, frames, audio, etc...
        scene = new SceneCampaign1();
    }

    public void render(Canvas canvas)
    {
        this.scene.render(canvas);
    }

    public void tick()
    {
        this.scene.tick();
    }

    public void touchAction(MotionEvent event)
    {
        this.scene.touch(event);
    }

    public void touchEdge(MotionEvent event)
    {
        //
    }
}