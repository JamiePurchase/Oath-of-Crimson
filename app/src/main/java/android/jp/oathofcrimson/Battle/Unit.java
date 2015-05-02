package android.jp.oathofcrimson.Battle;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.jp.oathofcrimson.Game.GameDisplay;

public abstract class Unit
{
    public abstract void render(Canvas canvas);
    public abstract void tick();

    // Drawing
    private Bitmap[] drawAnimAttackA = new Bitmap[10];
    private Bitmap[] drawAnimIdle = new Bitmap[10];
    private int drawPosX;
    private int drawPosY;

    // Stats
    private int statHealthNow;
    private int statHealthMax;
    private int statMysticNow;
    private int statMysticMax;
    private int statOverdrive;

    public Unit(String template)
    {
        // Default Properties
        this.drawPosX = 0;
        this.drawPosY = 0;

        // Temp
        this.drawAnimIdle[0] = GameDisplay.assetTempUnit;
    }

    public Bitmap getDrawAnim(String stance, int frame)
    {
        if(stance == "AttackA") {return this.drawAnimAttackA[frame];}
        if(stance == "Idle") {return this.drawAnimIdle[frame];}
        return this.drawAnimIdle[0];
    }

    public int getDrawPosX()
    {
        return this.drawPosX;
    }

    public int getDrawPosY()
    {
        return this.drawPosY;
    }

    public void setDrawPosX(int posX)
    {
        this.drawPosX = posX;
    }

    public void setDrawPosY(int posY)
    {
        this.drawPosY = posY;
    }

    public void setStatHealthNow(int amount)
    {
        this.statHealthNow = amount;
    }

    public void setStatHealthMax(int amount)
    {
        this.statHealthMax = amount;
    }

    public void setStatMysticNow(int amount)
    {
        this.statMysticNow = amount;
    }

    public void setStatMysticMax(int amount)
    {
        this.statMysticMax = amount;
    }
}