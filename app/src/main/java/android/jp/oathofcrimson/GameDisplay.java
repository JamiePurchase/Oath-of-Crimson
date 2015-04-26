package android.jp.oathofcrimson;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.io.File;

public class GameDisplay extends SurfaceView implements SurfaceHolder.Callback
{
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 800;
    private GameThread thread;
    private static State state;
    private static File dataFolder;

    // Assets (move these)
    public static Bitmap assetBkgBattle;
    public static Bitmap assetBkgTitle;

    public GameDisplay(Context context)
    {
        super(context);
        getHolder().addCallback(this);
        thread = new GameThread(getHolder(), this);
        setFocusable(true);

        // Directory for Save/Load
        dataFolder = context.getFilesDir();

        // Backgrounds (move these to an assets class>)
        assetBkgBattle = BitmapFactory.decodeResource(getResources(), R.drawable.bkg_battle);
        assetBkgTitle = BitmapFactory.decodeResource(getResources(), R.drawable.bkg_title);
    }

    @Override
    public void draw(Canvas canvas)
    {
        final float scaleFactorX = getWidth()/(WIDTH*1.f);
        final float scaleFactorY = getHeight()/(HEIGHT*1.f);
        if(canvas!=null)
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
        if(event.getAction()==MotionEvent.ACTION_DOWN)
        {
            state.touch(event);
            return true;
        }

        if(event.getAction()==MotionEvent.ACTION_UP)
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