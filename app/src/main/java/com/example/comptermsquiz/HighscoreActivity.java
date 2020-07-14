package com.example.comptermsquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class HighscoreActivity extends AppCompatActivity {
    TextView alert;
    Menu myMenu;
    ToggleButton btn1;
    Button level2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);
        alert = (TextView) findViewById(R.id.alert);
        TextView txtScore = (TextView) findViewById(R.id.textScore);
        Button back = (Button) findViewById(R.id.back);
        level2 = (Button) findViewById(R.id.level2);



        level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(HighscoreActivity.this, CompActivity.class);
                startActivity(int1);
               // myMenu.findItem(R.id.nav_his)
                 //       .setEnabled(true);
            }
        });

        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);
        txtScore.setText("Your Score:   " + score);

//need to get at least  half of the item to continue
        if (score <= 5) {
            alert.setText("You have to Read more about the topic!");

        } else {
            alert.setText("Do you want to continue");
            level2.setEnabled(true);
           // quiz1.setEnabled(true);


        }
    }
}

       /* @Override
                public boolean onPrepareOptionsMenu(Menu menu){
            myMenu.findItem(R.id.nav_his).setEnabled(true);
        super.onPrepareOptionsMenu(menu);*/
































    

      /*  ToggleButton btn1 = (ToggleButton) findViewById(R.id.option1);
        btn1.setOnCheckedChangeListener(btnOnCheckedChangeListener);
    }

    CompoundButton.OnCheckedChangeListener btnOnCheckedChangeListener =
            new CompoundButton.OnCheckedChangeListener(){

                @Override
                public void onCheckedChanged(CompoundButton buttonView,
                                             boolean isChecked) {
                    if(myMenu != null){
                        if(buttonView==btn1){
                            myMenu.findItem(R.id.nav_his)
                                    .setEnabled(isChecked);
                        }
                    }

                }};

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer_menu, menu);
        myMenu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.nav_his:
                Toast.makeText(HighscoreActivity.this,
                        "menuopt1",
                        Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

}



//back to Quiz
      back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        Intent int1 = new Intent(HighscoreActivity.this, PartsActivity.class);
        startActivity(int1);
            }
        });

        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);
        txtScore.setText("Your Score:   " + score);



    }
}*/
