package android.jp.oathofcrimson.State;

import android.graphics.Canvas;
import android.jp.oathofcrimson.Battle.Battle;
import android.view.MotionEvent;

public class StateBattle extends State
{
    private Battle battle;

    public StateBattle()
    {
        // NOTE: Consider passing the battle into this constructor
        battle = new Battle("test");
    }

    public void render(Canvas canvas)
    {
        battle.render(canvas);
    }

    public void tick()
    {
        battle.tick();
    }

    public void touch(MotionEvent event)
    {
        battle.touch(event);
    }
}