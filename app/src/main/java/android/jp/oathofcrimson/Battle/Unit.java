package android.jp.oathofcrimson.Battle;

import android.graphics.Canvas;

public abstract class Unit
{
    public abstract void render(Canvas canvas);
    public abstract void tick();

    public Unit()
    {

    }
}