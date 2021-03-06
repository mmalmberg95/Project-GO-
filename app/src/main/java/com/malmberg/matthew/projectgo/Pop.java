package com.malmberg.matthew.projectgo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Matthew on 10/16/2017.
 */

public class Pop extends Activity {

    private ListView biolist;
    ArrayList<EatData> eatList = new ArrayList<EatData>();
    ArrayList<DrinkData> drinkList = new ArrayList<DrinkData>();
    ArrayList<DoData> doList = new ArrayList<DoData>();
    private ImageButton resetButton;



    //TODO: int from intent 1-3 for Eat, Drink, Do
    private int whichList;
    private int option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .9), (int) (height * .8));

        setContentView(R.layout.popupwindow);
        RelativeLayout  relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayoutid);

        Intent myIntent = getIntent();
        whichList = myIntent.getIntExtra("whichList", 0);
        if (whichList == 1) {
            eatList = (ArrayList<EatData>) myIntent.getSerializableExtra("array");
            relativeLayout.setBackgroundResource(R.drawable.eatresult3);

        } else if (whichList == 2) {
            drinkList = (ArrayList<DrinkData>) myIntent.getSerializableExtra("array");
            relativeLayout.setBackgroundResource(R.drawable.drinkresult3);
        }
        else {
            doList = (ArrayList<DoData>) myIntent.getSerializableExtra("array");
            relativeLayout.setBackgroundResource(R.drawable.doresult3);
        }
        option = myIntent.getIntExtra("position", 0);
      
        int position = option;


        ImageView image = (ImageView) findViewById(R.id.mapView);
        TextView name = (TextView) findViewById(R.id.name);
        RatingBar stars = (RatingBar) findViewById(R.id.stars);
        TextView description = (TextView) findViewById(R.id.text_desc);
        TextView address = (TextView) findViewById(R.id.address);
        TextView price = (TextView) findViewById(R.id.price);

        if (whichList == 1){
            int drawableId = getResources().getIdentifier(eatList.get(position).getImageName(), "drawable", getPackageName());
            image.setImageResource(drawableId);
            name.setText(eatList.get(position).getName());
            stars.setRating(eatList.get(position).getStars());
            description.setText(eatList.get(position).getLongDesc());
            address.setText(eatList.get(position).getAddress());
            price.setText(eatList.get(position).getPrice());
        }

        else if (whichList == 2) {
            int drawableId = getResources().getIdentifier(drinkList.get(position).getImageName(), "drawable", getPackageName());
            image.setImageResource(drawableId);
            name.setText(drinkList.get(position).getName());
            stars.setRating(drinkList.get(position).getStars());
            description.setText(drinkList.get(position).getLongDesc());
            address.setText(drinkList.get(position).getAddress());
            price.setText(drinkList.get(position).getPrice());
        }

        else {
            int drawableId = getResources().getIdentifier(doList.get(position).getImageName(), "drawable", getPackageName());
            image.setImageResource(drawableId);
            name.setText(doList.get(position).getName());
            stars.setRating(doList.get(position).getStars());
            description.setText(doList.get(position).getLongDesc());
            address.setText(doList.get(position).getAddress());
            price.setText(doList.get(position).getPrice());
        }
    }
}


