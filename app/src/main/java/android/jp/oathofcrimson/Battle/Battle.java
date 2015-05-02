package android.jp.oathofcrimson.Battle;

import android.graphics.Canvas;
import android.jp.oathofcrimson.Game.GameDisplay;
import android.jp.oathofcrimson.Graphics.Drawing;
import android.jp.oathofcrimson.State.StateBattle;
import android.view.MotionEvent;

public class Battle
{
    // NOTE: Consider having a BattleLocation object (can be intelligent with different angles, moving scenery,
    // ability for units to move around, interactive features (eg: artillery), etc...)
    private String location;

    private UnitAlly[] unitAllies = new UnitAlly[4];
    private UnitEnemy[] unitEnemies = new UnitEnemy[5];

    public Battle(String location)
    {
        this.location = location;

        // Temp
        //this.unitAddAlly(new UnitAlly("Temp", 1, "Front"));
    }

    public void render(Canvas canvas)
    {
        // Render Background
        renderBackground(canvas);

        // Render Units
        //renderUnitAllies(canvas);
        //renderUnitEnemies(canvas);

        // Render Information
        renderInterfaceParty(canvas);
    }

    public void renderBackground(Canvas canvas)
    {
        canvas.drawBitmap(GameDisplay.assetBkgBattle, 0, 0, null);
    }

    public void renderInterfaceParty(Canvas canvas)
    {
        //Drawing.rectDraw(canvas, Drawing.getPaint("BLACK"), 900, 600, 200, 100);
        Drawing.textWrite(canvas, "Jamie", "BLACK", 1000, 600, 32);
    }

    public void renderUnitAllies(Canvas canvas)
    {
        for(int unit = 0; unit < unitAllies.length; unit++)
        {
            unitAllies[unit].render(canvas);
        }
    }

    public void renderUnitEnemies(Canvas canvas)
    {
        for(int unit = 0; unit < unitEnemies.length; unit++)
        {
            unitEnemies[unit].render(canvas);
        }
    }

    public void tick()
    {
        // if battle is moving forwards, reduce wait for all units
    }

    public void touch(MotionEvent event)
    {
        System.exit(0);
    }

    public void unitAddAlly(UnitAlly ally)
    {
        unitAllies[unitAllies.length] = ally;
    }

    public void unitAddEnemy(UnitEnemy enemy)
    {
        unitEnemies[unitEnemies.length] = enemy;
    }
}