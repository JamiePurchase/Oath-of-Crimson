package android.jp.oathofcrimson.State;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;

public abstract class State
{

    public abstract void render(Canvas canvas);
    public abstract void tick();

    public void touch(MotionEvent event)
    {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {this.touchAction(event);}
        //if(event.getAction() == MotionEvent.EDGE_TOP) {this.touchEdge(event);}
        if(event.getAction() == MotionEvent.ACTION_DOWN && event.getEdgeFlags() == MotionEvent.EDGE_BOTTOM) {this.touchEdge(event);}
    }

    public abstract void touchAction(MotionEvent event);
    public abstract void touchEdge(MotionEvent event);

}