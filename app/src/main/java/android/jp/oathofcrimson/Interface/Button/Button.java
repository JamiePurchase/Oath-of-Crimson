package android.jp.oathofcrimson.Interface.Button;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.jp.oathofcrimson.Graphics.Drawing;
import android.view.MotionEvent;

public class Button
{
    private String buttonRef;
    private Rect buttonArea;
    private String buttonCaption;
    private boolean buttonSelect;

    public Button(String ref, int posX, int posY, String caption)
    {
        this.buttonRef = ref;
        this.buttonArea = new Rect(posX, posY, posX + 200, posY + 50);
        this.buttonCaption = caption;
        this.buttonSelect = false;
    }

    public Button(String ref, Rect area, String caption)
    {
        this.buttonRef = ref;
        this.buttonArea = area;
        this.buttonCaption = caption;
        this.buttonSelect = false;
    }

    public Rect getArea()
    {
        return this.buttonArea;
    }

    public boolean getTouch(MotionEvent event)
    {
        if(this.getArea().contains((int) event.getX(), (int) event.getY())) {return true;}
        return false;
    }

    public String getRef()
    {
        return this.buttonRef;
    }

    public boolean isSelected()
    {
        return this.buttonSelect;
    }

    public void render(Canvas canvas)
    {
        // Shadow
        Drawing.rectShadow(canvas, "MenuShadow", this.getArea());

        // Background
        if(this.buttonSelect) {Drawing.rectDraw(canvas, "MenuGreen2", this.getArea());}
        else {Drawing.rectDraw(canvas, "MenuGreen", this.getArea());}

        // Caption
        Drawing.textWrite(canvas, this.buttonCaption, "BLACK", this.getArea().left + 15, this.getArea().top + 30, 32);

        // Border
        Drawing.rectDraw(canvas, "BLACK", this.getArea());
    }

    public void select()
    {
        this.buttonSelect = true;
    }

    public void select(boolean value)
    {
        this.buttonSelect = value;
    }

}