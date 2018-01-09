package com.smithjterm.scarnesdice;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int userOverall = 0;
    private int userTurn = 0;
    private int computerOverall = 0;
    private int computerTurn = 0;
    private TextView textBox = (TextView) findViewById(R.id.textView);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void resetButtonPress(View view){
      Button resetButton = (Button) findViewById(R.id.resetButton);

      userOverall = 0;
      userTurn = 0;
      computerOverall = 0;
      computerTurn = 0;


      textBox.setText("Your Score : 0 Computer Score : 0 Your Turn Score: 0");
    }

    public void holdButtonPress (View view){
        Button holdButton = (Button) findViewById(R.id.holdButton);

        userOverall += userTurn;

        String turnstring = "Your Score: "+userOverall+ " Computer Score: "+computerOverall+" Your Turn Score: "+ userTurn;
        textBox.setText(turnstring);
    }

    public void rollButtonPress (View view){
        Button rollButton = (Button) findViewById(R.id.rollButton);
        int roll = (int) (Math.random()*5)+1;

        int result;
        if (roll == 1){
            userTurn = 0;
            result = R.drawable.dice1;

            String turnstring = "Your Score: "+userOverall+ " Computer Score: "+computerOverall+" Your Turn Score: 0";
            textBox.setText(turnstring);
        }
        else {
            userTurn = roll;

            String turnstring = "Your Score: "+userOverall+ " Computer Score: "+computerOverall+" Your Turn Score: "+ roll;
            textBox.setText(turnstring);

            if (roll == 2) {
                result = R.drawable.dice2;
            } else if (roll == 3) {
                result = R.drawable.dice3;
            } else if (roll == 4) {
                result = R.drawable.dice4;
            } else if (roll == 5) {
                result = R.drawable.dice5;
            } else {
                result = R.drawable.dice6;
            }
        }
        ImageView dieView = (ImageView) findViewById(R.id.die_image);
        dieView.setImageResource(result);
        // and then I have to change the display
    }
}
