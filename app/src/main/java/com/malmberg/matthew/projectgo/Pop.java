package com.malmberg.matthew.projectgo;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Matthew on 10/16/2017.
 */

public class Pop extends Activity {
    ArrayList<EatData> eatList = new ArrayList<EatData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popupwindow);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8), (int)(height*.6));

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
            view = getLayoutInflater().inflate(R.layout.popupwindow, null);

            ImageView image = (ImageView)view.findViewById(R.id.mapView);
            TextView name = (TextView)view.findViewById(R.id.textView_name);
            //SomethingView stars = (SomethingView)view.findViewbyId(R.id.stars);
            TextView description = (TextView)view.findViewById(R.id.textView_desc);
            TextView address = (TextView)view.findViewById(R.id.textView_address);

            
            return view;
        }
    }

}
