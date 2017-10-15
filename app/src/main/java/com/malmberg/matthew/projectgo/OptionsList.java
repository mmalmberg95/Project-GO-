package com.malmberg.matthew.projectgo;

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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class OptionsList extends AppCompatActivity {

    private ListView biolist;
    ArrayList<EatData> eatList = new ArrayList<EatData>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_list);

        biolist = (ListView) findViewById(R.id.bio_list);


        EatData food1 = new EatData("Restaurant title", 5, 4, "123 Avenue", "short description", "long description");
        EatData food2 = new EatData("Restaurant title 2", 2, 2, "456 Avenue", "short description", "long description");
        EatData food3 = new EatData("Restaurant title 3", 3, 4, "489 Avenue", "short description", "long description");

        eatList.add(food1);
        eatList.add(food2);
        eatList.add(food3);

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

            ImageView image = (ImageView)view.findViewById(R.id.imageView);
            TextView name = (TextView)view.findViewById(R.id.textView_name);
            TextView description = (TextView)view.findViewById(R.id.textView_desc);
            TextView address = (TextView)view.findViewById(R.id.textView_address);

            image.setImageResource(R.drawable.house);
            name.setText(eatList.get(i).getName());
            description.setText(eatList.get(i).getShortDesc());
            address.setText(eatList.get(i).getLocation());


            return view;
        }
    }

}
