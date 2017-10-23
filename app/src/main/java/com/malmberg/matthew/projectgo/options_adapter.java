package com.malmberg.matthew.projectgo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jennapfingsten on 10/15/17.
 */


public class options_adapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private List<Integer> random = new ArrayList<Integer>();

    private ListView biolist;
    ArrayList<EatData> eatList = new ArrayList<EatData>();
    ArrayList<DrinkData> drinkList = new ArrayList<DrinkData>();
    ArrayList<DoData> doList = new ArrayList<DoData>();
    private ImageButton resetButton;
   // private List<Integer> random = new ArrayList<Integer>();

    private int option1;
    private int option2;
    private int option3;

//    Intent myIntent = getIntent();
//    option1 = myIntent.getIntExtra("option1", option1);
//        random.add(option1);
//    option2 = myIntent.getIntExtra("option2", option2);
//        random.add(option2);
//    option3 = myIntent.getIntExtra("option3", option3);
//        random.add(option3);

//    Intent myIntent = getIntent();
//    whichList = myIntent.getIntExtra("whichList", 0);

//    Intent myIntent = getIntent();
//    whichList = myIntent.getIntExtra("whichList", 0);
//        if(whichList == 1) {
//        eatList = (ArrayList<EatData>) myIntent.getSerializableExtra("array");
//    }
//        else if(whichList == 2) {
//        drinkList = (ArrayList<DrinkData>) myIntent.getSerializableExtra("array");
//    }
//        else {
//        doList = (ArrayList<DoData>) myIntent.getSerializableExtra("array");
//    }

//    public options_adapter(Context context, ArrayList<Integers> random); {
//        mContext = context;
//        mDataSource = random;
//        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//    }

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
//        view = getLayoutInflater().inflate(R.layout.options_list_layout,null);
//
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(.this,Pop.class);
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
//                intent.putExtra("option", option1);
//
//                startActivity(intent);
//
//
//            }
//        });


//        ImageView image = (ImageView)view.findViewById(R.id.imageView);
//        TextView name = (TextView)view.findViewById(R.id.textView_name);
//        TextView description = (TextView)view.findViewById(R.id.textView_desc);
//        TextView address = (TextView)view.findViewById(R.id.textView_address);
//
//
//        //TODO: random aspect
//        if(whichList == 1) {
//
//            image.setImageResource(R.drawable.house);
//            name.setText(eatList.get(i).getName());
//            description.setText(eatList.get(i).getShortDesc());
//            address.setText(eatList.get(i).getAddress());
//
//
//        }
//
//        if(whichList == 2) {
//            image.setImageResource(R.drawable.house);
//            name.setText(drinkList.get(i).getName());
//            description.setText(drinkList.get(i).getShortDesc());
//            address.setText(drinkList.get(i).getAddress());
//        }
//
//        //TODO: change drink list to do list
//        if(whichList == 3) {
//            image.setImageResource(R.drawable.house);
//            name.setText(eatList.get(i).getName());
//            description.setText(eatList.get(i).getShortDesc());
//            address.setText(eatList.get(i).getAddress());
//        }


        return view;
    }
}



