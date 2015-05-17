package android.jp.oathofcrimson.Battle;

import android.graphics.Canvas;
import android.jp.oathofcrimson.Game.GameDisplay;
import android.jp.oathofcrimson.Graphics.Drawing;
import android.view.MotionEvent;


public class Battle
{
    // NOTE: Consider having a BattleLocation object (can be intelligent with different angles, moving scenery,
    // ability for units to move around, interactive features (eg: artillery), etc...)
    private String location;

    //private UnitAlly[] unitAllies = new UnitAlly[4];
    //private UnitEnemy[] unitEnemies = new UnitEnemy[5];

    // Temp
    private boolean tempBattleRunning;
    private int tempBattleTurnCount;
    private int tempBattleTurnTick;
    private boolean tempBattleTurnNew;

    // Temp
    private boolean tempUnitActionReady;
    private int tempUnitActionTick;
    private int tempUnitActionWait;
    private int tempUnitAnimFrame;
    private int tempUnitAnimTick;
    private int tempUnitWaitTurn;

    // Temp
    private boolean tempMenuCommand;

    public Battle(String location)
    {
        this.location = location;

        // Temp
        tempBattleRunning = true;
        tempBattleTurnCount = 0;
        tempBattleTurnTick = 0;
        tempBattleTurnNew = true;

        // Temp
        //this.unitAddAlly(new UnitAlly("Temp", 1, "Front"));

        // Temp
        tempUnitActionReady = false;
        tempUnitActionTick = 0;
        tempUnitActionWait = 1;
        tempUnitAnimFrame = 0;
        tempUnitAnimTick = 0;
        tempUnitWaitTurn = 3;
    }

    public void render(Canvas canvas)
    {
        // Render Background
        renderBackground(canvas);

        // Render Units
        renderUnitAllies(canvas);
        //renderUnitEnemies(canvas);

        // Render Information
        renderInterfaceParty(canvas);

        // Render Command Menu
        if(tempMenuCommand) {renderInterfaceCommand(canvas);}
    }

    public void renderBackground(Canvas canvas)
    {
        canvas.drawBitmap(GameDisplay.assetBkgBattle, 0, 0, null);
    }

    public void renderInterfaceCommand(Canvas canvas)
    {
        Drawing.rectDraw(canvas, Drawing.getPaint("BLACK"), 40, 590, 200, 100);
        Drawing.textWrite(canvas, "Attack", "WHITE", 50, 620, 32);
    }

    public void renderInterfaceParty(Canvas canvas)
    {
        Drawing.rectDraw(canvas, Drawing.getPaint("BLACK"), 840, 530, 200, 100);
        Drawing.textWrite(canvas, "Jamie", "WHITE", 850, 560, 32);
    }

    public void renderUnitAllies(Canvas canvas)
    {
        /*for(int unit = 0; unit < unitAllies.length; unit++)
        {
            unitAllies[unit].render(canvas);
        }*/

        // Temp
        canvas.drawBitmap(GameDisplay.assetTempUnitIdle[tempUnitAnimFrame], 1000, 200, null);
    }

    public void renderUnitEnemies(Canvas canvas)
    {
        /*for(int unit = 0; unit < unitEnemies.length; unit++)
        {
            unitEnemies[unit].render(canvas);
        }*/
    }

    public void tick()
    {
        // NOTE: There's little need to have units tracking ticks and wait durations separately from the main battle turn data
        // When these functions are tidied (and some are moved to the units), there should be one clear new turn event
        if(tempBattleRunning)
        {
            tickTurn();
            tickUnit();
        }
    }

    public void tickTurn()
    {
        tempBattleTurnTick += 1;
        if(tempBattleTurnTick > 10)
        {
            tempBattleTurnTick = 0;
            tempBattleTurnCount += 1;
            tickTurnAdvance();
        }
    }

    public void tickTurnAdvance()
    {
        tickTurnAdvanceLocation();
        tickTurnAdvanceUnit();
    }

    public void tickTurnAdvanceLocation()
    {
        // NOTE: Should probably just call BattleLocation.advance();
    }

    public void tickTurnAdvanceUnit()
    {
        tickTurnAdvanceUnitAllies();
        tickTurnAdvanceUnitEnemies();
    }

    public void tickTurnAdvanceUnitAllies()
    {
        // Check status effects
    }

    public void tickTurnAdvanceUnitEnemies()
    {

    }

    public void tickUnit()
    {
        tickUnitAction();
        tickUnitAnimation();
    }

    public void tickUnitAction()
    {
        // NOTE: Need to do this for all units (make a tick function in the unit classes
        tempUnitActionTick += 1;
        if(tempUnitActionTick > 20)
        {
            tempUnitActionTick = 0;
            tempUnitActionWait -= 1;
            if(tempUnitActionWait < 1)
            {
                tempUnitActionReady = true;
                tempMenuCommand = true;
            }
        }
    }

    public void tickUnitAnimation()
    {
        // Temp (the action and anim functions should belong to the unit)
        tempUnitAnimTick += 1;
        if(tempUnitAnimTick > 20)
        {
            tempUnitAnimTick = 0;
            tempUnitAnimFrame += 1;
            if(tempUnitAnimFrame > 10)
            {
                tempUnitAnimFrame = 0;
            }
        }
    }

    public void touch(MotionEvent event)
    {
        // call a function to get the touchNexus (object or string?) using event.getX() and event.getY();
        String touchNexus = "tempCommand";
        if(touchNexus.equals("tempCommand") && tempMenuCommand)
        {
            // Temp attack selected
        }

        // Temp
        System.exit(0);
    }

    /*public void unitAddAlly(UnitAlly ally)
    {
        unitAllies[unitAllies.length] = ally;
    }*/

    /*public void unitAddEnemy(UnitEnemy enemy)
    {
        unitEnemies[unitEnemies.length] = enemy;
    }*/
}