package android.jp.oathofcrimson.Scene;

import android.graphics.Canvas;
import android.view.MotionEvent;

public abstract class Scene
{
    public abstract void render(Canvas canvas);
    public abstract void tick();
    public abstract void touch(MotionEvent event);

    public Scene()
    {

    }
}