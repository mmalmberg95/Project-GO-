package com.malmberg.matthew.projectgo;

import android.content.Intent;
import android.media.Image;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomePage extends AppCompatActivity {

    private ImageButton eatButton;
    private ImageButton drinkButton;
    private ImageButton doButton;

//    public ArrayList<BioData> BioArray = new ArrayList<>();
    public ArrayList<EatData> EatArray = new ArrayList<>();
    public ArrayList<DrinkData> DrinkArray = new ArrayList<>();
    public ArrayList<DoData> DoArray = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        eatButton = (ImageButton) findViewById(R.id.eat_button);
        drinkButton = (ImageButton) findViewById(R.id.drink_button);
        doButton = (ImageButton) findViewById(R.id.do_button);



        eatButton.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(view.getContext(), OptionsList.class);
                intent.putExtra("whichList", 1);
                intent.putExtra("array", EatArray);
                startActivity(intent);
            }
        });

        drinkButton.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(view.getContext(), OptionsList.class);
                intent.putExtra("whichList", 2);
                intent.putExtra("array", DrinkArray);
                startActivity(intent);
            }
        });

        doButton.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(view.getContext(), OptionsList.class);
                intent.putExtra("whichList", 3);
                intent.putExtra("array", DoArray);
                startActivity(intent);
            }
        });


        readGoData(1);
        readGoData(2);
        readGoData(3); //no images yet
    }



    private void readGoData(int whichType) {
        //takes GoData and puts it in an InputStream
        int whichList = whichType;
        InputStream is;
        if(whichList == 1) {is = getResources().openRawResource(R.raw.eat_data);}
        else if (whichList == 2) {is = getResources().openRawResource(R.raw.drink_data);}
        else {is = getResources().openRawResource(R.raw.do_data);}

        //created to read the InputStream
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );
        //loop to read file
        String line = "";
        try {
//            reader.readLine();
            while ((line = reader.readLine()) != null) {
                //split by comma
                //info is a just a identifier for the different splits
                String[] info = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

                //Read the Data
                if(whichList == 1) {
                    EatData data = new EatData();
                    data.setName(info[0]);
                    data.setPrice(Integer.parseInt(info[1]));
                    data.setStars(Integer.parseInt(info[2]));
                    data.setAddress(info[3]);
                    data.setShortDesc(info[4]);
                    data.setLongDesc(info[5]);
                    data.setLatitude(Float.parseFloat(info[6]));
                    data.setLongitude(Float.parseFloat(info[7]));
                    data.setImageName(info[8]);

                    EatArray.add(data);
                }

                if(whichList == 2) {
                    DrinkData data = new DrinkData();
                    data.setName(info[0]);
                    data.setPrice(Integer.parseInt(info[1]));
                    data.setStars(Integer.parseInt(info[2]));
                    data.setAddress(info[3]);
                    data.setShortDesc(info[4]);
                    data.setLongDesc(info[5]);
                    data.setLatitude(Float.parseFloat(info[6]));
                    data.setLongitude(Float.parseFloat(info[7]));
                    data.setImageName(info[8]);

                    DrinkArray.add(data);
                }
                if(whichList == 3) {
                    DoData data = new DoData();
                    data.setName(info[0]);
                    data.setPrice(Integer.parseInt(info[1]));
                    data.setStars(Integer.parseInt(info[2]));
                    data.setAddress(info[3]);
                    data.setShortDesc(info[4]);
                    data.setLongDesc(info[5]);
                    data.setDay(Integer.parseInt(info[6]));
                    data.setMonth(Integer.parseInt(info[7]));
                    data.setYear(Integer.parseInt(info[8]));
                    data.setLatitude(Float.parseFloat(info[9]));
                    data.setLongitude(Float.parseFloat(info[10]));
                    //data.setImageName(info[11]); //no image data in CSV yet
                }


            }
            //catches any errors that might appear while reading the file and outputs the error message
        } catch (IOException e) {
            //wtf = What a Terrible Failure
            Log.wtf("OptionsList", "Error reading file at line " + line, e);
            e.printStackTrace();
        }
    }



}
