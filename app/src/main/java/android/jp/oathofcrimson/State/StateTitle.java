package android.jp.oathofcrimson.State;

import android.graphics.Canvas;
import android.jp.oathofcrimson.Game.GameDisplay;
import android.view.MotionEvent;

public class StateTitle extends State
{

    public StateTitle()
    {
    }

    public void render(Canvas canvas)
    {
        this.renderBackground(canvas);
    }

    private void renderBackground(Canvas canvas)
    {
        canvas.drawBitmap(GameDisplay.assetImageTitleBkg, 0, 0, null);
    }

    public void tick()
    {

    }

    public void touch(MotionEvent event)
    {
        //GameDisplay.setState(new StateScene());
        GameDisplay.setState(new StateDev());
    }

}