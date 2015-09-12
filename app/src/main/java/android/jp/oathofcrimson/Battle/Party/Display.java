package android.jp.oathofcrimson.Battle.Party;

import android.graphics.Canvas;
import android.jp.oathofcrimson.Battle.Battle;
import android.jp.oathofcrimson.Battle.UnitAlly;
import android.jp.oathofcrimson.Graphics.Drawing;

public class Display
{
    private Battle displayBattle;

    public Display(Battle battle)
    {
        this.displayBattle = battle;
    }

    public void render(Canvas canvas)
    {
        for(int x = 0; x < this.displayBattle.getUnitAlly().length; x++)
        {
            this.renderUnit(canvas, x, this.displayBattle.getUnitAlly()[x]);
        }
    }

    private void renderUnit(Canvas canvas, int position, UnitAlly unit)
    {
        Drawing.textWrite(canvas, "Jamie", "BLACK", 850, 560 + (position * 50), 32);
    }

    public void tick()
    {

    }

}