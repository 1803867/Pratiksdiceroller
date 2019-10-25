package com.example.pratiksdiceroller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int score =0;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void on_button_click(View view){

        int number = Roll_the_dice();

        TextView tv = this.findViewById(R.id.numberView);
        tv.setText(Integer.toString(number));

        EditText inputText = (EditText)findViewById(R.id.Enternumber);

        TextView gv = this.findViewById(R.id.guessView);
        TextView suv =this.findViewById(R.id.success);

        try {
            int guess = Integer.parseInt(inputText.getText().toString());
            gv.setText(Integer.toString(guess));
            suv.setText("");

            TextView scv = this.findViewById(R.id.viewscore);


            if(inputText == null){
                inputText.setText("0");
            }


            if(guess > 6 || guess < 1){
                tv.setText("Invalid number");
            }
            inputText.setText("");
            if(number == guess){
                suv.setText("Nice!");
                this.score++;
                scv.setText(Integer.toString(score));

            }
        }catch (NumberFormatException e){
            tv.setText("No Input");
        }


    }
    public int Roll_the_dice() {
        //gets random number
        Random rand = new Random();
        int number = rand.nextInt(7);
        return number;
    }

public void when_button_clicked(View view){

        TextView mv = this.findViewById(R.id.question);
        ArrayList<String> questionlist = new ArrayList<String>();

        questionlist.add("If you could go anywhere in the world,where would you go?");
        questionlist.add("If you were stranded on a desert island, what three things would you want to take with you?");
        questionlist.add("If you could eat only one food for the rest of your life, what would that be?");
        questionlist.add("If you won a million dollars, what is the first thing you would buy?");
        questionlist.add("If you could spend the day with one fictional character, who would it be?");
        questionlist.add("If you found a magic lantern and a genie gave you three wishes, what would you wish?");

        int randomnumber = (int) (Math.random()*6);

        mv.setText(questionlist.get(randomnumber));

    }



}