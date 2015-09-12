package android.jp.oathofcrimson.State;

import android.graphics.Canvas;
import android.jp.oathofcrimson.Game.GameDisplay;
import android.jp.oathofcrimson.Graphics.Drawing;
import android.jp.oathofcrimson.Interface.Button.ButtonGroup;
import android.view.MotionEvent;

public class StateDev extends State
{
    // Touch Coordinates
    private int devTouchX, devTouchY;

    // Buttons
    private ButtonGroup devButton;

    public StateDev()
    {
        // Touch Coordinates
        this.devTouchX = 0;
        this.devTouchY = 0;

        // Buttons
        this.devButton = new ButtonGroup();
        this.devButton.addButton("BATTLE", 100, 100, "BATTLE");
        this.devButton.addButton("BOARD", 400, 100, "BOARD");
    }

    public void render(Canvas canvas)
    {
        // Background
        Drawing.screenFill(canvas, "WHITE");

        // Touch
        Drawing.textWrite(canvas, "TOUCH: " + this.devTouchX + "," + this.devTouchY, "BLACK", 25, 700, 32);

        // Buttons
        this.devButton.render(canvas);
    }

    public void tick()
    {

    }

    public void touch(MotionEvent event)
    {
        // Update Touch Coordinates
        this.devTouchX = (int) event.getX();
        this.devTouchY = (int) event.getY();

        // Buttons
        String button = this.devButton.touch(event);
        if(button == "BATTLE") {GameDisplay.setState(new StateBattle());}
        if(button == "BOARD") {GameDisplay.setState(new StateBoard());}
    }

}