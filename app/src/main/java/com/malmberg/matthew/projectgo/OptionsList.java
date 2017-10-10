package com.malmberg.matthew.projectgo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class OptionsList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_list);

        readGoData();

    }

    private List<BioData> BioList = new ArrayList<>();
    private void readGoData() {
        //takes GoData and puts it in an InputStream
        InputStream is = getResources().openRawResource(R.raw.godata);
        //created to read the InputStream
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );
    //loop to read file
        String line = "";
        try {
            while ( (line = reader.readLine()) != null ) {
                //split by comma
                //info is a just a identifier for the different splits
                String[] info = line.split(",");

                //Read the Data
                BioData data = new BioData();
                data.setName(info[0]);
                data.setPrice(Integer.parseInt(info[1]));
                data.setDescription(info[2]);
                data.setEat(Boolean.parseBoolean(info[3]));
                data.setDrink(Boolean.parseBoolean(info[4]));
                data.setListen(Boolean.parseBoolean(info[5]));
                data.setSee(Boolean.parseBoolean(info[6]));

                //adds the data to our arrayList
                BioList.add(data);
            }
        //catches any errors that might appear while reading the file and outputs the error message
        } catch (IOException e) {
            //wtf = What a Terrible Failure
            Log.wtf("OptionsList", "Error reading file at line " + line, e);
            e.printStackTrace();
        }


    }
}
