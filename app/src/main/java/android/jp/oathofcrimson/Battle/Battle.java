package android.jp.oathofcrimson.Battle;

import android.graphics.Canvas;
import android.jp.oathofcrimson.Battle.Command.Menu;
import android.jp.oathofcrimson.Battle.Environment.Environment;
import android.jp.oathofcrimson.Battle.Party.Display;
import android.jp.oathofcrimson.Campaign.Campaign;
import android.jp.oathofcrimson.Game.GameDisplay;
import android.jp.oathofcrimson.Graphics.Drawing;
import android.jp.oathofcrimson.Interface.Button.ButtonGroup;
import android.jp.oathofcrimson.State.StateBattle;
import android.view.MotionEvent;

import java.util.ArrayList;


public class Battle
{
    // Battle
    private StateBattle battleState;
    private Campaign battleCampaign;
    private boolean battleRunning;

    // NOTE: Consider having a BattleLocation object (can be intelligent with different angles, moving scenery,
    // ability for units to move around, interactive features (eg: artillery), etc...)

    // Environment
    private Environment environment;

    // Interface
    private Display interfaceParty;
    private Menu interfaceCommand;
    private ButtonGroup interfaceButton;

    private UnitAlly[] unitAlly = new UnitAlly[4];
    //private UnitEnemy[] unitEnemy = new UnitEnemy[5];

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

    public Battle(StateBattle state, Campaign campaign)
    {
        // Battle
        this.battleState = state;
        this.battleCampaign = campaign;
        this.battleRunning = true;

        // Environment
        this.environment = environment;

        // Units
        //this.unitAlly;

        // Interface
        this.interfaceParty = new Display(this);
        this.interfaceCommand = null;
        this.interfaceButton = new ButtonGroup();
        this.interfaceButton.addButton("PAUSE", 1161, 5, "PAUSE");

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

    public void commandMenu()
    {
        this.interfaceCommand = null;
    }

    public void commandMenu(UnitAlly unit)
    {
        this.interfaceCommand = new Menu(this, unit);
    }

    public UnitAlly[] getUnitAlly()
    {
        return this.unitAlly;
    }

    private void pause(boolean running)
    {
        this.battleRunning = running;
    }

    public void render(Canvas canvas)
    {
        // Render Environment
        this.environment.render(canvas);

        // Render Units
        renderUnitAllies(canvas);
        //renderUnitEnemies(canvas);

        // Render Party Information
        this.interfaceParty.render(canvas);

        // Render Command Menu
        if(this.interfaceCommand != null) {this.interfaceCommand.render(canvas);}

        // Render Buttons
        this.interfaceButton.render(canvas);
    }

    private void renderUnitAllies(Canvas canvas)
    {
        /*for(int unit = 0; unit < unitAllies.length; unit++)
        {
            unitAllies[unit].render(canvas);
        }*/

        // Temp
        canvas.drawBitmap(GameDisplay.assetSheetUnitTemp[tempUnitAnimFrame], 1000, 200, null);
    }

    private void renderUnitEnemies(Canvas canvas)
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

    private void tickTurn()
    {
        tempBattleTurnTick += 1;
        if(tempBattleTurnTick > 10)
        {
            tempBattleTurnTick = 0;
            tempBattleTurnCount += 1;
            tickTurnAdvance();
        }
    }

    private void tickTurnAdvance()
    {
        tickTurnAdvanceLocation();
        tickTurnAdvanceUnit();
    }

    private void tickTurnAdvanceLocation()
    {
        // NOTE: Should probably just call BattleLocation.advance();
    }

    private void tickTurnAdvanceUnit()
    {
        tickTurnAdvanceUnitAllies();
        tickTurnAdvanceUnitEnemies();
    }

    private void tickTurnAdvanceUnitAllies()
    {
        // Check status effects
    }

    private void tickTurnAdvanceUnitEnemies()
    {

    }

    private void tickUnit()
    {
        tickUnitAction();
        tickUnitAnimation();
    }

    private void tickUnitAction()
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

    private void tickUnitAnimation()
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
        // Pause Menu
        //if(this.interfacePause != null)
        // TEMP
        if(!this.battleRunning) {this.pause(true);}

        // Command Menu
        if(this.interfaceCommand != null) {this.touchCommand(event);}

        // Buttons
        this.touchButton(event);
    }

    private void touchButton(MotionEvent event)
    {
        String button = this.interfaceButton.touch(event);
        if(button == "PAUSE") {this.pause(false);}
    }

    private void touchCommand(MotionEvent event)
    {
        if(this.interfaceCommand.getTouch(event))
        {
            String command = this.interfaceCommand.touch(event);
            // NOTE: if command != null then the player has chosen a command
        }
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