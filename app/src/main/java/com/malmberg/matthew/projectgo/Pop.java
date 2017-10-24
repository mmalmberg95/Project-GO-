package com.malmberg.matthew.projectgo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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

        getWindow().setLayout((int)(width*.8), (int)(height*.6));

        setContentView(R.layout.activity_pop);

        Intent myIntent = getIntent();
        whichList = myIntent.getIntExtra("whichList", 0);
        if(whichList == 1) {
            eatList = (ArrayList<EatData>) myIntent.getSerializableExtra("array");
        }
        else if(whichList == 2) {
            drinkList = (ArrayList<DrinkData>) myIntent.getSerializableExtra("array");
        }
//        else {
//            doList = (ArrayList<DoData>) myIntent.getSerializableExtra("array");
//        }
        option = myIntent.getIntExtra("position", 0);

        biolist = (ListView) findViewById(R.id.listview);

        pop_adapter pop_adapter = new pop_adapter();
        biolist.setAdapter(pop_adapter);


    }

//    class pop_adapter extends BaseAdapter {
//
//        @Override
//        public int getCount() {return 1;}
//
//        @Override
//        public Object getItem(int postion) {
//            return myIntent.getIntExtra("position", 0);
//        }
//
//        @Override
//        public long getItemId(int i) {
//            return 0;
//        }
//
//        @Override
//        public View getView(int i, View view, ViewGroup viewGroup) {
//            view = getLayoutInflater().inflate(R.layout.popupwindow, null);
//
//            ImageView image = (ImageView)view.findViewById(R.id.mapView);
//            TextView name = (TextView)view.findViewById(R.id.name);
//            RatingBar stars = (RatingBar)view.findViewById(R.id.stars);
//            TextView description = (TextView)view.findViewById(R.id.text_desc);
//            TextView address = (TextView)view.findViewById(R.id.address);
//
//            if(whichList == 1) {
//                //image.setImageResource(R.drawable.house);
//                name.setText(eatList.get(position).getName());
//                stars.setRating(eatList.get(position).getStars());
//                description.setText(eatList.get(position).getLongDesc());
//                address.setText(eatList.get(position).getAddress());
//            }
//
//            else if(whichList == 2) {
//                //image.setImageResource(R.drawable.house);
//                name.setText(drinkList.get(i).getName());
//                stars.setRating(drinkList.get(i).getStars());
//                description.setText(drinkList.get(i).getLongDesc());
//                address.setText(drinkList.get(i).getAddress());
//            }
//
//            return view;
//        }
//    }

}
