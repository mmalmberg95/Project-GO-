package com.malmberg.matthew.projectgo;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;


public class OptionsList extends AppCompatActivity {

    private ListView biolist;
    ArrayList<EatData> eatList = new ArrayList<EatData>();
    ArrayList<DrinkData> drinkList = new ArrayList<DrinkData>();

    //TODO: int from intent 1-3 for Eat, Drink, Do
    private int whichList;
    private int option1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_list);

        Intent myIntent = getIntent();
        whichList = myIntent.getIntExtra("whichList", 0);
        option1 = myIntent.getIntExtra("option1", option1);


        biolist = (ListView) findViewById(R.id.bio_list);

        //This is just test data. Real code will have arrayList passed in from intent.
        EatData food1 = new EatData("Restaurant title 3", 3, 4, "123 Avenue", "short description", "long description");
        EatData food2 = new EatData("Restaurant title 2", 2, 2, "456 Avenue", "short description", "long description");
        EatData food3 = new EatData("Restaurant title 3", 3, 4, "489 Avenue", "short description", "long description");

        eatList.add(food1);
        eatList.add(food2);
        eatList.add(food3);

        DrinkData drink1 = new DrinkData("Bar title", 5, 4, "123 Avenue", "short bar description", "long bar description");
        DrinkData drink2 = new DrinkData("Bar title 2", 1, 2, "456 Avenue", "short bar description 2", "long bar description");
        DrinkData drink3 = new DrinkData("Bar title 3", 3, 3, "789 Avenue", "short bar description 3", "long bar description");

        drinkList.add(drink1);
        drinkList.add(drink2);
        drinkList.add(drink3);

        //end test section

        options_adapter options_adapter = new options_adapter();
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


            //TODO: random aspect
            if(whichList == 1) {
                image.setImageResource(R.drawable.house);
                name.setText(eatList.get(i).getName());
                description.setText(eatList.get(i).getShortDesc());
                address.setText(eatList.get(i).getLocation());
            }

            if(whichList == 2) {
                image.setImageResource(R.drawable.house);
                name.setText(drinkList.get(i).getName());
                description.setText(drinkList.get(i).getShortDesc());
                address.setText(drinkList.get(i).getLocation());
            }

            if(whichList == 3) {
                image.setImageResource(R.drawable.house);
                name.setText(eatList.get(i).getName());
                description.setText(eatList.get(i).getShortDesc());
                address.setText(eatList.get(i).getLocation());
            }


            return view;
        }
    }

}
