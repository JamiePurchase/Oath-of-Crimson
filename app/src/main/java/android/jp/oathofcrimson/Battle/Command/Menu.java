package android.jp.oathofcrimson.Battle.Command;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.jp.oathofcrimson.Battle.Battle;
import android.jp.oathofcrimson.Battle.UnitAlly;
import android.jp.oathofcrimson.Game.GameDisplay;
import android.jp.oathofcrimson.Graphics.Drawing;
import android.view.MotionEvent;

import java.util.ArrayList;

public class Menu
{
    // Menu
    private Battle menuBattle;
    private UnitAlly menuUnit;
    private final Rect menuArea = new Rect(40, 560, 200, 760);

    // Commands
    private ArrayList<MenuOption> menuCommands;

    // Selection
    private boolean menuSelectActive;
    private int menuSelectOption;

    // Cursor
    private int menuCursorTick, menuCursorFrame;
    private boolean menuCursorAnim;

    public Menu(Battle battle, UnitAlly unit)
    {
        // Menu
        this.menuBattle = battle;
        this.menuUnit = unit;

        // Commands
        this.menuCommands = new ArrayList();

        // Selection
        this.menuSelectActive = false;
        this.menuSelectOption = 0;

        // Cursor
        this.menuCursorTick = 0;
        this.menuCursorFrame = 0;
        this.menuCursorAnim = true;

        // TEMP
        this.addOption("ATTACK", "ATTACK", MenuOptionType.ATTACK, "Strike an enemy with your weapon");
        this.addOption("TECH1", "SWORDPLAY", MenuOptionType.TECHNIQUE, "Perform sword skills that you have learnt");
        this.addOption("DEFEND", "DEFEND", MenuOptionType.DEFEND, "Stand firm and resist attacks");
        this.addOption("ITEM", "ITEM", MenuOptionType.ITEM, "Use items from your inventory");
    }

    private void addOption(String ref, String caption, MenuOptionType type, String hint)
    {
        this.menuCommands.add(new MenuOption(this, ref, caption, type, hint));
    }

    public Rect getArea()
    {
        return this.menuArea;
    }

    private Rect getAreaCommand(int command)
    {
        return new Rect(this.menuArea.left, this.menuArea.top + (command * 50), this.menuArea.right, this.menuArea.top + (command * 50) + 50);
    }

    public boolean getTouch(MotionEvent event)
    {
        if(this.getArea().contains((int) event.getX(), (int) event.getY())) {return true;}
        return false;
    }

    public void render(Canvas canvas)
    {
        this.renderFrame(canvas);
        this.renderOption(canvas);
        this.renderCursor(canvas);
    }

    private void renderCursor(Canvas canvas)
    {
        Drawing.imageDraw(canvas, GameDisplay.assetImageCursor1, this.getArea().left + this.menuCursorFrame, this.getArea().top + 30);
    }

    private void renderFrame(Canvas canvas)
    {
        // Shadow
        Drawing.rectShadow(canvas, "MenuShadow", this.getArea());

        // Background
        Drawing.rectFill(canvas, "MenuGreen", this.getArea());

        // Border
        //Drawing.rectDraw(canvas, "BLACK", this.getArea());
    }

    private void renderOption(Canvas canvas)
    {
        for(int x = 0; x < this.menuCommands.size(); x++)
        {
            if(this.menuSelectActive && this.menuSelectOption == x) {Drawing.rectFill(canvas, "MenuGreen2", this.getAreaCommand(x));}
            Drawing.textWrite(canvas, "Attack", "BLACK", this.getArea().left + 15, this.getArea().top + 30 + (x * 50), 32);
            Drawing.rectDraw(canvas, "BLACK", this.getAreaCommand(x));
        }
    }

    private void select(int option)
    {
        this.menuSelectActive = true;
        this.menuSelectOption = option;
        for (int x = 0; x < this.menuCommands.size(); x++)
        {
            if(x == option) {this.menuCommands.get(x).select(true);}
            else {this.menuCommands.get(x).select(false);}
        }
    }

    public void tick()
    {
        this.tickCursor();
    }

    private void tickCursor()
    {
        this.menuCursorTick += 1;
        if(this.menuCursorTick >= 30)
        {
            this.menuCursorTick = 0;
            if(this.menuCursorAnim)
            {
                this.menuCursorFrame += 1;
                if(this.menuCursorFrame >= 20) {this.menuCursorAnim = false;}
            }
            else
            {
                this.menuCursorFrame -= 1;
                if(this.menuCursorFrame <= 0) {this.menuCursorAnim = true;}
            }
        }
    }

    public String touch(MotionEvent event)
    {
        for (int x = 0; x < this.menuCommands.size(); x++)
        {
            if(this.getAreaCommand(x).contains((int) event.getX(), (int) event.getY()))
            {
                if(this.menuCommands.get(x).isSelected()) {return this.menuCommands.get(x).getRef();}
                else {this.select(x);}
            }
        }
        return null;
    }

}