package com.malmberg.matthew.projectgo;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static com.malmberg.matthew.projectgo.R.drawable.button1;

//import static android.R.id.button1;


public class OptionsList extends AppCompatActivity {

    private ListView biolist;
    ArrayList<EatData> eatList = new ArrayList<EatData>();
    ArrayList<DrinkData> drinkList = new ArrayList<DrinkData>();
    ArrayList<DoData> doList = new ArrayList<DoData>();
    private ImageButton resetButton;
//    Random rand = new Random();
//    int randNum;

    //TODO: int from intent 1-3 for Eat, Drink, Do
    private int whichList;

    options_adapter options_adapter = new options_adapter();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_list);

        //Create a new intent
        //Get the variable for which type of list
        //Get the correct list
        Intent myIntent = getIntent();
        whichList = myIntent.getIntExtra("whichList", 0);
        if(whichList == 1) {
            eatList = (ArrayList<EatData>) myIntent.getSerializableExtra("array");
        }
        else if(whichList == 2) {
            drinkList = (ArrayList<DrinkData>) myIntent.getSerializableExtra("array");
        }
        else {
            doList = (ArrayList<DoData>) myIntent.getSerializableExtra("array");
        }

//        option1 = myIntent.getIntExtra("option1", option1);


        biolist = (ListView) findViewById(R.id.bio_list);
        resetButton = (ImageButton) findViewById(R.id.imageButton);

        newList(whichList);

//        options_adapter options_adapter = new options_adapter();
        //biolist.setAdapter(options_adapter);

    }

    private void newList (int whichList) {
        int typeList = whichList;
        if (typeList == 1) { Collections.shuffle(eatList); }
        if (typeList == 2) {Collections.shuffle(drinkList); }
        if (typeList == 3) { Collections.shuffle(doList); }
        biolist.setAdapter(options_adapter);
    }

    class options_adapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.options_list_layout,null);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(OptionsList.this,Pop.class));
                }
            });


            ImageView image = (ImageView)view.findViewById(R.id.imageView);
            TextView name = (TextView)view.findViewById(R.id.textView_name);
            TextView description = (TextView)view.findViewById(R.id.textView_desc);
            TextView address = (TextView)view.findViewById(R.id.textView_address);


            //randNum = rand.nextInt(eatList.size());
            //int[] ints = new Random().ints(0, 50).distinct().limit(3).toArray();



            if(whichList == 1) {
                //image.setImageResource(getResources().getIdentifier("button1", "drawable", null));
                int drawableId = getResources().getIdentifier(eatList.get(i).getImageName(), "drawable", getPackageName());
                image.setImageResource(drawableId);
                //image.setImageResource(R.drawable.jethros);
                name.setText(eatList.get(i).getName());
                description.setText(eatList.get(i).getShortDesc());
                address.setText(eatList.get(i).getAddress());
            }


            if(whichList == 2) {
//                image.setImageResource(R.drawable.house);
                int drawableId = getResources().getIdentifier(drinkList.get(i).getImageName(), "drawable", getPackageName());
                image.setImageResource(drawableId);
                name.setText(drinkList.get(i).getName());
                description.setText(drinkList.get(i).getShortDesc());
                address.setText(drinkList.get(i).getAddress());
            }


            if(whichList == 3) {
                image.setImageResource(R.drawable.house);
//                int drawableId = getResources().getIdentifier(doList.get(i).getImageName(), "drawable", getPackageName());
//                image.setImageResource(drawableId);
                name.setText(doList.get(i).getName());
                description.setText(doList.get(i).getShortDesc());
                address.setText(doList.get(i).getAddress());
            }


            return view;
        }
    }

}
