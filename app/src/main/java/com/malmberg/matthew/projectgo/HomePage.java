package com.malmberg.matthew.projectgo;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomePage extends AppCompatActivity {

    private ImageButton eatButton;
    private ImageButton drinkButton;
    private ImageButton listenButton;
    private ImageButton seeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        eatButton = (ImageButton) findViewById(R.id.eat_button);
        drinkButton = (ImageButton) findViewById(R.id.drink_button);
        listenButton = (ImageButton) findViewById(R.id.listen_button);
        seeButton = (ImageButton) findViewById(R.id.see_button);


        eatButton.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(view.getContext(), OptionsList.class);
                startActivity(intent);
            }
        });

        drinkButton.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(view.getContext(), OptionsList.class);
                startActivity(intent);
            }
        });

        listenButton.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(view.getContext(), OptionsList.class);
                startActivity(intent);
            }
        });

        seeButton.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(view.getContext(), OptionsList.class);
                startActivity(intent);
            }
        });
    }
}
