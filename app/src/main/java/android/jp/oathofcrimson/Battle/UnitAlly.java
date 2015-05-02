package android.jp.oathofcrimson.Battle;

import android.graphics.Canvas;

public class UnitAlly extends Unit
{
    private int statOverdrive;

    public UnitAlly(String template, int pos, String row)
    {
        super(template);

        // Set Position
        if(row == "Front") {this.setDrawPosX(1000);}
        else {this.setDrawPosX(1050);}
        this.setDrawPosY(pos*200);

        // Load Template
        new TemplateAlly(this, template);
    }

    public int getStatOverdrive()
    {
        return this.statOverdrive;
    }

    public void render(Canvas canvas)
    {
        canvas.drawBitmap(this.getDrawAnim("Idle", 0), this.getDrawPosX(), this.getDrawPosY(), null);
    }

    public void setStatOverdrive(int amount)
    {
        this.statOverdrive = amount;
    }

    public void tick()
    {

    }
}