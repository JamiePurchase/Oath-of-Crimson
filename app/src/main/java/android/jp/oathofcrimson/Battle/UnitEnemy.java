package android.jp.oathofcrimson.Battle;

import android.graphics.Canvas;

public class UnitEnemy extends Unit
{
    public UnitEnemy(String template)
    {
        super(template);
    }

    public void render(Canvas canvas)
    {
        canvas.drawBitmap(this.getDrawAnim(UnitStance.IDLE, 0), this.getDrawPosX(), this.getDrawPosY(), null);
    }

    public void tick()
    {

    }

}