package com.malmberg.matthew.projectgo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Matthew on 10/20/2017.
 */

public class pop_adapter extends BaseAdapter {
//    private Context mContext;
//    private LayoutInflater mInflater;
//    private ArrayList<EatData> mDataSource;
//
//    public pop_adapter(Context context, ArrayList<EatData> items){
//        mContext = context;
//        mDataSource = items;
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
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        return null;
    }
}
