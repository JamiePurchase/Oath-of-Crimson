package android.jp.oathofcrimson.State;

import android.graphics.Canvas;
import android.jp.oathofcrimson.Graphics.Drawing;
import android.jp.oathofcrimson.Interface.MenuItem;
import android.view.MotionEvent;

public class StateMenu extends State
{
    private MenuItem[] menuMain = new MenuItem[4];

    public StateMenu()
    {
        // Temp
        menuMain[0] = new MenuItem("MISSION", 50, 50, 150, 50);
        menuMain[1] = new MenuItem("INVENTORY", 50, 100, 150, 50);
        menuMain[2] = new MenuItem("EQUIPMENT", 50, 150, 150, 50);
    }

    public void render(Canvas canvas)
    {
        renderBackground(canvas);
        renderMenuMain(canvas);
    }

    public void renderBackground(Canvas canvas)
    {
        Drawing.screenFill(canvas, 255, 255, 255);
    }

    public void renderMenuMain(Canvas canvas)
    {
        for(int item = 0; item < menuMain.length; item++)
        {
            menuMain[item].render(canvas);
        }
    }

    public void tick()
    {

    }

    public void touchAction(MotionEvent event)
    {
        System.exit(1);
    }

    public void touchEdge(MotionEvent event)
    {
        //
    }
}