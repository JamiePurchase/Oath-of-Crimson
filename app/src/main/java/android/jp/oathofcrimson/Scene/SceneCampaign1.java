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
        Drawing.textWrite(canvas, "Broken Sword", "White", 50, 500, 32);
        Drawing.textWrite(canvas, "Arudane Hillasken  -  17th June", "White", 50, 650, 24);

        // Test
        /*Rect rect = new Rect(0, 0, GameDisplay.WIDTH, GameDisplay.HEIGHT);
        Paint paint = new Paint();
        paint.setColor(Color.rgb(0, 0, 0));
        canvas.drawRect(rect, paint);
        paint.setColor(Color.rgb(255, 255, 255));
        paint.setTextSize(32);
        canvas.drawText("Broken Sword", 50, 500, paint);
        paint.setTextSize(24);
        canvas.drawText("Arudane Hillasken  -  17th June", 50, 650, paint);*/
    }

    public void tick()
    {
        this.tickCount += 1;
    }

    public void touch(MotionEvent event)
    {
        GameDisplay.setState(new StateBattle());
        //GameDisplay.setState(new StateMenu());
    }
}