package android.jp.oathofcrimson.Interface.Button;

import android.graphics.Canvas;
import android.view.MotionEvent;

import java.util.ArrayList;

public class ButtonGroup
{
    private ArrayList<Button> buttonArray;
    private boolean buttonSelectActive;
    private int buttonSelectObject;

    public ButtonGroup()
    {
        this.buttonArray = new ArrayList();
        this.buttonSelectActive = false;
        this.buttonSelectObject = 0;
    }

    public void addButton(String ref, int posX, int posY, String caption)
    {
        this.buttonArray.add(new Button(ref, posX, posY, caption));
    }

    public void render(Canvas canvas)
    {
        for(int x = 0; x < this.buttonArray.size(); x++)
        {
            this.buttonArray.get(x).render(canvas);
        }
    }

    private void select(int button)
    {
        this.buttonSelectActive = true;
        this.buttonSelectObject = button;
        for(int x = 0; x < this.buttonArray.size(); x++)
        {
            if(x == button) {this.buttonArray.get(x).select(true);}
            else {this.buttonArray.get(x).select(false);}
        }
    }

    public String touch(MotionEvent event)
    {
        for(int x = 0; x < this.buttonArray.size(); x++)
        {
            if(this.buttonArray.get(x).getTouch(event))
            {
                if(this.buttonArray.get(x).isSelected()) {return this.buttonArray.get(x).getRef();}
                else {this.select(x);}
            }
        }
        return null;
    }

}