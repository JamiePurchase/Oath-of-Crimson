package android.jp.oathofcrimson.State;

import android.content.Context;
import android.graphics.Canvas;
import android.jp.oathofcrimson.Game.GameDisplay;
import android.jp.oathofcrimson.Graphics.Drawing;
import android.jp.oathofcrimson.Interface.Button.ButtonGroup;
import android.view.MotionEvent;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StateDev extends State
{
    // Touch Coordinates
    private int devTouchX, devTouchY;

    // Buttons
    private ButtonGroup devButton;

    // Temp
    private String tempData;

    public StateDev()
    {
        // Touch Coordinates
        this.devTouchX = 0;
        this.devTouchY = 0;

        // Buttons
        this.devButton = new ButtonGroup();
        this.devButton.addButton("BATTLE", 100, 100, "BATTLE");
        this.devButton.addButton("BOARD", 400, 100, "BOARD");
        this.devButton.addButton("SAVE", 100, 400, "SAVE");
        this.devButton.addButton("LOAD", 400, 400, "LOAD");

        // Temp
        this.tempData = "...";
    }

    private void fileLoad()
    {
        String fileContents = "";
        try
        {
            InputStream inputStream = GameDisplay.CONTEXT.openFileInput("testdata");
            if(inputStream != null)
            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String fileLine = "";
                try
                {
                    while((fileLine = reader.readLine()) != null) {fileContents += fileLine;}
                }
                catch (IOException e) {e.printStackTrace();}
            }
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        this.tempData = fileContents;
    }

    private void fileSave()
    {
        String filename = "testdata";
        String string = "Hello world!";
        FileOutputStream outputStream;
        try
        {
            outputStream = GameDisplay.CONTEXT.openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        }
        catch (Exception e) {e.printStackTrace();}
        this.tempData = "SAVED!";
    }

    public void render(Canvas canvas)
    {
        // Background
        Drawing.screenFill(canvas, "WHITE");

        // Touch
        Drawing.textWrite(canvas, "TOUCH: " + this.devTouchX + "," + this.devTouchY, "BLACK", 25, 700, 32);

        // Buttons
        this.devButton.render(canvas);

        // Temp Data
        Drawing.textWrite(canvas, this.tempData, "BLACK", 25, 550, 32);
    }

    public void tick()
    {

    }

    public void touch(MotionEvent event)
    {
        // Update Touch Coordinates
        this.devTouchX = (int) event.getX();
        this.devTouchY = (int) event.getY();

        // Buttons
        String button = this.devButton.touch(event);
        if(button == "BATTLE") {GameDisplay.setState(new StateBattle());}
        if(button == "BOARD") {GameDisplay.setState(new StateBoard());}
        if(button == "SAVE") {fileSave();}
        if(button == "LOAD") {fileLoad();}
    }

}