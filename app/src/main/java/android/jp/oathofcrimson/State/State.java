package android.jp.oathofcrimson.State;

import android.graphics.Canvas;
import android.view.MotionEvent;

public abstract class State
{

    public abstract void render(Canvas canvas);
    public abstract void tick();
    public abstract void touch(MotionEvent event);

}