package com.malmberg.matthew.projectgo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

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

    private int option1;
    private int option2;
    private int option3;

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
        return view;
    }
}



