package android.jp.oathofcrimson.Battle.Environment;

import android.graphics.Canvas;
import android.jp.oathofcrimson.Battle.Battle;
import android.jp.oathofcrimson.Game.GameDisplay;

public class Environment
{
    private Battle environmentBattle;
    private Weather environmentWeather;
    private int environmentPosX, environmentPosY;

    public Environment(Battle battle)
    {
        this.environmentBattle = battle;
        this.environmentWeather = Weather.CLEAR;
        this.environmentPosX = 0;
        this.environmentPosY = 0;
    }

    public void render(Canvas canvas)
    {
        this.renderBackground(canvas);
    }

    private void renderBackground(Canvas canvas)
    {
        // NOTE: we might want to have some scrolling backgrounds
        canvas.drawBitmap(GameDisplay.assetImageBattleBkg, 0, 0, null);
    }

    private void renderWeather(Canvas canvas)
    {
        //
    }

}