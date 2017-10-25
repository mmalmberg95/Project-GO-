package com.malmberg.matthew.projectgo;

import android.content.Intent;
import android.location.Location;
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
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

import static com.malmberg.matthew.projectgo.R.drawable.button1;

//import static android.R.id.button1;



public class OptionsList extends AppCompatActivity {

    private ListView biolist;
    ArrayList<EatData> eatList = new ArrayList<EatData>();
    ArrayList<DrinkData> drinkList = new ArrayList<DrinkData>();
    ArrayList<DoData> doList = new ArrayList<DoData>();
    private ImageButton resetButton;
    private SeekBar distance_slider;

    ArrayList<EatData> displayEatList = new ArrayList<EatData>();
    ArrayList<DrinkData> displayDrinkList = new ArrayList<DrinkData>();
    ArrayList<DoData> displayDoList = new ArrayList<DoData>();

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
            displayEatList = (ArrayList<EatData>) myIntent.getSerializableExtra("array");
        }
        else if(whichList == 2) {
            drinkList = (ArrayList<DrinkData>) myIntent.getSerializableExtra("array");
            displayDrinkList = (ArrayList<DrinkData>) myIntent.getSerializableExtra("array");
        }
        else {
            doList = (ArrayList<DoData>) myIntent.getSerializableExtra("array");
            displayDoList = (ArrayList<DoData>) myIntent.getSerializableExtra("array");
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
        resetButton = (ImageButton) findViewById(R.id.imageButton);
        distance_slider = (SeekBar) findViewById(R.id.seekBar);

        resetButton.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                newList(whichList);
            }
        });

        newList(whichList);

        distance_slider.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        checkValidity(0, progress);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                } );

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


            //randNum = rand.nextInt(eatList.size());
            //int[] ints = new Random().ints(0, 50).distinct().limit(3).toArray();



            if(whichList == 1) {
                 //image.setImageResource(getResources().getIdentifier("button1", "drawable", null));
                int drawableId = getResources().getIdentifier(displayEatList.get(i).getImageName(), "drawable", getPackageName());
                image.setImageResource(drawableId);
                //image.setImageResource(R.drawable.jethros);
                name.setText(displayEatList.get(i).getName());
                description.setText(displayEatList.get(i).getShortDesc());
                address.setText(displayEatList.get(i).getAddress());


            }


            if(whichList == 2) {
//                image.setImageResource(R.drawable.house);
                int drawableId = getResources().getIdentifier(displayDrinkList.get(i).getImageName(), "drawable", getPackageName());
                image.setImageResource(drawableId);
                name.setText(displayDrinkList.get(i).getName());
                description.setText(displayDrinkList.get(i).getShortDesc());
                address.setText(displayDrinkList.get(i).getAddress());
            }


            if(whichList == 3) {
                image.setImageResource(R.drawable.house);
//                int drawableId = getResources().getIdentifier(doList.get(i).getImageName(), "drawable", getPackageName());
//                image.setImageResource(drawableId);
                name.setText(displayDoList.get(i).getName());
                description.setText(displayDoList.get(i).getShortDesc());
                address.setText(displayDoList.get(i).getAddress());
            }


            return view;
        }
    }

    /*
Accepts an int value for as there is no way to give it a pure array.
maxDistance accepts an int for whatever the slider is set to
*/

    boolean checkDate(int eventID)
    {
        Date currentTime = Calendar.getInstance().getTime();

        //checks to see if the override time of Month = 12 and Day = 31 is in use
        if((doList.get(eventID).getDay() == 31) && (doList.get(eventID).getMonth() == 12))
        {
            return true;
        }

        else if((doList.get(eventID).getDay() == currentTime.getDay()) && (doList.get(eventID).getMonth() == currentTime.getMonth()) && (doList.get(eventID).getYear() == currentTime.getYear()))
        {
            return true;
        }

        else
        {
            return false;
        }
    }


    void checkValidity(int eventID, int maxDistance)
    {
        Location user =  new Location("user");
        Location event = new Location("event");

        //Location of Iowa Capitol Building
        user.setLatitude(41.6005448);
        user.setLongitude(-93.6091064);

        //empties arrays
        displayEatList.clear();
        displayDrinkList.clear();
        displayDoList.clear();

        if(whichList == 1) {
            event.setLatitude(eatList.get(eventID).getLatitude());
            event.setLongitude(eatList.get(eventID).getLongitude());
        }

        else if(whichList == 2) {
            event.setLatitude(drinkList.get(eventID).getLatitude());
            event.setLongitude(drinkList.get(eventID).getLongitude());
        }

        else {
        event.setLatitude(doList.get(eventID).getLatitude());
        event.setLongitude(doList.get(eventID).getLongitude());}


        //finds and compares distance

        double distance = user.distanceTo(event)/1609.39; //meters to miles

        //Adds to array if applicable
        if(whichList == 1)
        {
            if(distance <= maxDistance)
            {
                displayEatList.add(eatList.get(eventID));
            }

            //Checks to see if the entire array has been scanned
            if(eventID < (eatList.size() - 1))
            {
                checkValidity(eventID + 1, maxDistance);
            }
        }

        else if(whichList == 2)
        {
            if(distance <= maxDistance)
            {
                displayDrinkList.add(drinkList.get(eventID));
            }

            //Checks to see if the entire array has been scanned
            if(eventID < (drinkList.size() - 1))
            {
                checkValidity(eventID + 1, maxDistance);
            }
        }

        else
        {
            if((distance <= maxDistance) && (checkDate(eventID) == true))
            {
                displayDoList.add(doList.get(eventID));
            }

            //Checks to see if the entire array has been scanned
            if(eventID < (doList.size() - 1))
            {
                checkValidity(eventID + 1, maxDistance);
            }
        }
    }



}
