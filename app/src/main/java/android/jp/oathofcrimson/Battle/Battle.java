package android.jp.oathofcrimson.Battle;

import android.graphics.Canvas;
import android.jp.oathofcrimson.Game.GameDisplay;
import android.jp.oathofcrimson.State.StateBattle;
import android.view.MotionEvent;

public class Battle
{
    // NOTE: Consider having a BattleLocation object (can be intelligent with different angles, moving scenery,
    // ability for units to move around, interactive features (eg: artillery), etc...)
    private String location;

    private UnitAlly[] unitAllies;
    private UnitEnemy[] unitEnemies;

    public Battle(String location)
    {
        this.location = location;
    }

    public void render(Canvas canvas)
    {
        renderBackground(canvas);
        renderCharacter(canvas);
        // NOTE: Need to loop through units and call render on them
    }

    public void renderBackground(Canvas canvas)
    {
        canvas.drawBitmap(GameDisplay.assetBkgBattle, 0, 0, null);
    }

    public void renderCharacter(Canvas canvas)
    {
        //GameDisplay.assetSheetBattleTemp.drawSprite(canvas, 1000, 50, 1, 1);
        canvas.drawBitmap(GameDisplay.assetTempUnit, 1000, 50, null);
    }

    public void tick()
    {

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