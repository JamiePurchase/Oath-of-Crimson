package android.jp.oathofcrimson.Game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.jp.oathofcrimson.Campaign.Campaign;
import android.jp.oathofcrimson.Graphics.Spritesheet;
import android.jp.oathofcrimson.R;
import android.jp.oathofcrimson.State.State;
import android.jp.oathofcrimson.State.StateTitle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.io.File;
import java.util.HashMap;

public class GameDisplay extends SurfaceView implements SurfaceHolder.Callback
{
    // Display
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 800;

    // Engine
    private GameThread thread;
    private static State state;
    private static File dataFolder;

    // Campaign
    public static Campaign CAMPAIGN;

    // Assets
    public static Bitmap assetImageBattleBkg, assetImageTitleBkg, assetImageTileGrass;
    public static Bitmap[] assetSheetUnitTemp;

    // Assets (move these)
    public static Spritesheet assetSheetBattleTemp;

    public GameDisplay(Context context)
    {
        // Display
        super(context);
        getHolder().addCallback(this);

        // Engine
        thread = new GameThread(getHolder(), this);
        setFocusable(true);
        dataFolder = context.getFilesDir();

        // Campaign
        CAMPAIGN = new Campaign();

        // Assets
        assetImageBattleBkg = BitmapFactory.decodeResource(getResources(), R.drawable.bkg_battle);
        assetImageTitleBkg = BitmapFactory.decodeResource(getResources(), R.drawable.bkg_title);

        // Temp Board Tiles
        assetImageTileGrass = BitmapFactory.decodeResource(getResources(), R.drawable.board_tile_grass1);

        // Temp Images
        Bitmap[] tempUnit = new Bitmap[11];
        tempUnit[0] = BitmapFactory.decodeResource(getResources(), R.drawable.sprite_battle_temp_idle1);
        tempUnit[1] = BitmapFactory.decodeResource(getResources(), R.drawable.sprite_battle_temp_idle2);
        tempUnit[2] = BitmapFactory.decodeResource(getResources(), R.drawable.sprite_battle_temp_idle3);
        tempUnit[3] = BitmapFactory.decodeResource(getResources(), R.drawable.sprite_battle_temp_idle4);
        tempUnit[4] = BitmapFactory.decodeResource(getResources(), R.drawable.sprite_battle_temp_idle5);
        tempUnit[5] = BitmapFactory.decodeResource(getResources(), R.drawable.sprite_battle_temp_idle6);
        tempUnit[6] = BitmapFactory.decodeResource(getResources(), R.drawable.sprite_battle_temp_idle7);
        tempUnit[7] = BitmapFactory.decodeResource(getResources(), R.drawable.sprite_battle_temp_idle8);
        tempUnit[8] = BitmapFactory.decodeResource(getResources(), R.drawable.sprite_battle_temp_idle9);
        tempUnit[9] = BitmapFactory.decodeResource(getResources(), R.drawable.sprite_battle_temp_idle10);
        tempUnit[10] = BitmapFactory.decodeResource(getResources(), R.drawable.sprite_battle_temp_idle11);
        assetSheetUnitTemp = tempUnit;

        // Spritesheets (move these)
        assetSheetBattleTemp = new Spritesheet(BitmapFactory.decodeResource(getResources(), R.drawable.sheet_temp), 160, 160);
    }

    @Override
    public void draw(Canvas canvas)
    {
        final float scaleFactorX = getWidth() / (WIDTH * 1.f);
        final float scaleFactorY = getHeight() / (HEIGHT * 1.f);
        if(canvas != null)
        {
            final int savedState = canvas.save();
            canvas.scale(scaleFactorX, scaleFactorY);
            state.render(canvas);
            canvas.restoreToCount(savedState);
        }
    }

    public static File getDataFolder()
    {
        return dataFolder;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            state.touch(event);
            return true;
        }

        if(event.getAction() == MotionEvent.ACTION_UP)
        {
            return true;
        }

        return super.onTouchEvent(event);
    }

    public static void setState(State newState)
    {
        state = newState;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
    {
        //
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder)
    {
        boolean retry = true;
        while(retry)
        {
            try
            {
                thread.setRunning(false);
                thread.join();
            }
            catch(InterruptedException e) {e.printStackTrace();}
            retry = false;
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {
        setState(new StateTitle());
        thread.setRunning(true);
        thread.start();
    }

    public void tick()
    {
        state.tick();
    }

}