package com.example.pictionary;

import android.widget.Toast;
import android.widget.EditText;
import android.content.Intent;
import android.view.View;
import com.example.pictionary.R;
import com.example.pictionary.R.layout;
import com.example.pictionary.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

/**
 * // -------------------------------------------------------------------------
 * /** The main activity serves as the landing screen for the Pictionary app. It
 * requests the player to input how many players will be in the game, and it
 * also has a start button to begin the game and call the drawActivty.
 *
 * @author Pictionary Team (Chris Deisher, Edward McEnrue, Michael Liu)
 * @version Apr 16, 2014
 */

public class MainActivity
    extends Activity
{



    public static GameController controller; // A new instance of the game is made.

    // The key value pair to send the player amount to DrawActivity
    public final static String GAME_CONTROLLER = "com.Pictionary.MainActivity.CONTROLLER";





    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    // Getting the button to start the draw activity and pass player amt info
    // below:

    /**
     * Listens for the startDrawing button to be clicked, and if the editText
     * has information entered, then the DrawActivity activity will be called
     * with the player amount data passed through an intent.
     *
     * @param view
     *            The button view named "startDrawing."
     */
    public void startDrawing(View view)
    {




        EditText editTextPlayerCount = (EditText)findViewById(R.id.playerAmount);

        try
        {
            int playerCount = new Integer(editTextPlayerCount.getText().toString()).intValue();


            if(playerCount < 1) // Ensures the amount of players is not 0.
            {
                Toast.makeText(getApplicationContext(), "Enter a valid number", Toast.LENGTH_SHORT).show();
            }
            else
            {
                // Build an intent and the key value pairs in response to the button.

                Intent mainIntent = new Intent(this, DrawActivity.class);

                // Package the intent with the instance of the game controller
                // made specifically for this game.

                controller = new GameController(playerCount);

                // TODO GameController needs to implement serializable
                //mainIntent.putExtra(GAME_CONTROLLER, controller);

                startActivity(mainIntent);
            }
        }
        catch(NumberFormatException e) // Ensures the editText isn't blank.
        {
            Toast.makeText(getApplicationContext(), "Enter a valid number", Toast.LENGTH_SHORT).show();
        }





    }

    // TODO Check if the static strings should be final and such

    // TODO Should we hardcode our string values into the @string resource?

    // TODO Find out how to test Toast notifications.
    // TODO Find out if we need a test class for each activity.
    // TODO Make sure the game controller isn't unpackaged in terms of an intent in the draw activity twice
}
