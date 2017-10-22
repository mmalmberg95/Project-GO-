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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class OptionsList extends AppCompatActivity {

    private ListView biolist;
    ArrayList<EatData> eatList = new ArrayList<EatData>();
    ArrayList<DrinkData> drinkList = new ArrayList<DrinkData>();
    ArrayList<DoData> doList = new ArrayList<DoData>();
    private ImageButton resetButton;
    List<Integer> random = new ArrayList<Integer>();

    //TODO: int from intent 1-3 for Eat, Drink, Do
    private int whichList;
    private int option1;
    private int option2;
    private int option3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_list);

        //Create a new intent
        //Get the variable for which type of list
        //Get the correct list
        //NOTE: the other two lists will be empty
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

        option1 = myIntent.getIntExtra("option1", option1);
        random.add(option1);
        option2 = myIntent.getIntExtra("option2", option2);
        random.add(option2);
        option3 = myIntent.getIntExtra("option3", option3);
        random.add(option3);


        biolist = (ListView) findViewById(R.id.bio_list);
        resetButton = (ImageButton) findViewById(R.id.imageButton);

        options_adapter options_adapter = new options_adapter();
        biolist.setAdapter(options_adapter);

        biolist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(OptionsList.this,Pop.class);
                if(whichList == 1) {
                    intent.putExtra("array", eatList);
                    intent.putExtra("whichList", 1);
                }
                else if(whichList == 2){
                    intent.putExtra("array", drinkList);
                    intent.putExtra("whichList", 2);
                }
                else{
                    intent.putExtra("array", doList);
                    intent.putExtra("whichList", 3);
                }
                intent.putExtra("option", option1);

                startActivity(intent);


            }
        });


    }

    class options_adapter extends BaseAdapter {

        @Override
        public int getCount() {
            return random.size();
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


            ImageView image = (ImageView)view.findViewById(R.id.imageView);
            TextView name = (TextView)view.findViewById(R.id.textView_name);
            TextView description = (TextView)view.findViewById(R.id.textView_desc);
            TextView address = (TextView)view.findViewById(R.id.textView_address);


            //TODO: random aspect
            if(whichList == 1) {

                image.setImageResource(R.drawable.house);
                name.setText(eatList.get(i).getName());
                description.setText(eatList.get(i).getShortDesc());
                address.setText(eatList.get(i).getAddress());


            }

            if(whichList == 2) {
                image.setImageResource(R.drawable.house);
                name.setText(drinkList.get(i).getName());
                description.setText(drinkList.get(i).getShortDesc());
                address.setText(drinkList.get(i).getAddress());
            }

            //TODO: change drink list to do list
            if(whichList == 3) {
                image.setImageResource(R.drawable.house);
                name.setText(eatList.get(i).getName());
                description.setText(eatList.get(i).getShortDesc());
                address.setText(eatList.get(i).getAddress());
            }


            return view;
        }
    }

}
