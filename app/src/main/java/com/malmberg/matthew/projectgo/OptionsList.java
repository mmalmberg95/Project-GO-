package com.malmberg.matthew.projectgo;

import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
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

    int[] background_images = new int[3];

//    Random rand = new Random();
//    int randNum;
    //TODO: int from intent 1-3 for Eat, Drink, Do
    private int whichList;

    options_adapter options_adapter = new options_adapter();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_list);

        resetButton = (ImageButton) findViewById(R.id.imageButton);


        //Create a new intent
        //Get the variable for which type of list
        //Get the correct list and correct styling
        Intent myIntent = getIntent();
        whichList = myIntent.getIntExtra("whichList", 0);
        if(whichList == 1) {
            eatList = (ArrayList<EatData>) myIntent.getSerializableExtra("array");
            resetButton.setImageResource(R.drawable.eatrefresh);
            background_images[0] = R.drawable.eatresult1;
            background_images[1] = R.drawable.eatresults2;
            background_images[2] = R.drawable.eatresult3;
        }
        else if(whichList == 2) {
            drinkList = (ArrayList<DrinkData>) myIntent.getSerializableExtra("array");
            resetButton.setImageResource(R.drawable.drinkrefresh);
            background_images[0] = R.drawable.drinkresult1;
            background_images[1] = R.drawable.drinkresult2;
            background_images[2] = R.drawable.drinkresult3;
        }
        else {
            doList = (ArrayList<DoData>) myIntent.getSerializableExtra("array");
            resetButton.setImageResource(R.drawable.dorefresh);
            background_images[0] = R.drawable.doresult1;
            background_images[1] = R.drawable.doresult2;
            background_images[2] = R.drawable.doresult3;
        }


//        option1 = myIntent.getIntExtra("option1", option1);
//        random.add(option1);
//        option2 = myIntent.getIntExtra("option2", option2);
//        random.add(option2);
//        option3 = myIntent.getIntExtra("option3", option3);
//        random.add(option3);
//
//
//        biolist = (ListView) findViewById(R.id.bio_list);
//        resetButton = (ImageButton) findViewById(R.id.imageButton);
//
//        options_adapter options_adapter = new options_adapter();
//        biolist.setAdapter(options_adapter
        biolist = (ListView) findViewById(R.id.bio_list);


        resetButton.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                newList(whichList);
            }
        });

        newList(whichList);

//        options_adapter options_adapter = new options_adapter();
        //biolist.setAdapter(options_adapter);


//        biolist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(OptionsList.this,Pop.class);
//                if(whichList == 1) {
//                    intent.putExtra("array", eatList);
//                    intent.putExtra("whichList", 1);
//                }
//                else if(whichList == 2){
//                    intent.putExtra("array", drinkList);
//                    intent.putExtra("whichList", 2);
//                }
//                else{
//                    intent.putExtra("array", doList);
//                    intent.putExtra("whichList", 3);
//                }
//                //intent.putExtra("option", option1);
//
//                startActivity(intent);
//
//
//            }
//        });


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
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.options_list_layout,null);

            biolist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(OptionsList.this,Pop.class);
                    if(whichList == 1) {
                        intent.putExtra("array", eatList);
                        intent.putExtra("whichList", 1);
                        intent.putExtra("position", i);
                    }
                    else if(whichList == 2){
                        intent.putExtra("array", drinkList);
                        intent.putExtra("whichList", 2);
                    }
                    else{
                        intent.putExtra("array", doList);
                        intent.putExtra("whichList", 3);
                    }
                    //intent.putExtra("option", option1);

                    startActivity(intent);


                }
            });


            ImageView image = (ImageView)view.findViewById(R.id.imageView);
            TextView name = (TextView)view.findViewById(R.id.textView_name);
            TextView description = (TextView)view.findViewById(R.id.textView_desc);
            TextView address = (TextView)view.findViewById(R.id.textView_address);
            ImageView background = (ImageView)view.findViewById(R.id.background_image);


            //randNum = rand.nextInt(eatList.size());
            //int[] ints = new Random().ints(0, 50).distinct().limit(3).toArray();



            if(whichList == 1) {
                 //image.setImageResource(getResources().getIdentifier("button1", "drawable", null));
                int drawableId = getResources().getIdentifier(eatList.get(i).getImageName(), "drawable", getPackageName());
                image.setImageResource(drawableId);
                background.setImageResource(background_images[i]);
                //image.setImageResource(R.drawable.jethros);
                name.setText(eatList.get(i).getName());
                description.setText(eatList.get(i).getShortDesc());
                address.setText(eatList.get(i).getAddress());



            }


            if(whichList == 2) {
//                image.setImageResource(R.drawable.house);
                int drawableId = getResources().getIdentifier(drinkList.get(i).getImageName(), "drawable", getPackageName());
                image.setImageResource(drawableId);
                background.setImageResource(background_images[i]);
                name.setText(drinkList.get(i).getName());
                description.setText(drinkList.get(i).getShortDesc());
                address.setText(drinkList.get(i).getAddress());
            }


            if(whichList == 3) {
                //image.setImageResource(R.drawable.house);
                int drawableId = getResources().getIdentifier(doList.get(i).getImageName(), "drawable", getPackageName());
                image.setImageResource(drawableId);
                background.setImageResource(background_images[i]);
                name.setText(doList.get(i).getName());
                description.setText(doList.get(i).getShortDesc());
                address.setText(doList.get(i).getAddress());
            }


            return view;
        }
    }

}
