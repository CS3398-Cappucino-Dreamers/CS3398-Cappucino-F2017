package com.example.ben.fitordie.Login;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.*;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.ben.fitordie.Login.DataModels.ListDataModel;
import com.example.ben.fitordie.Login.adapters.CustomAdapter;
import com.example.ben.fitordie.Login.bottomnav.BottomNavBar;
import com.example.ben.fitordie.Login.listeners.BottomNavListener;
import com.example.ben.fitordie.Login.listeners.MenuItemListener;
import com.example.ben.fitordie.R;

import java.util.ArrayList;

public class WorkoutTracker extends AppCompatActivity {

    ArrayList<ListDataModel> dataModels;
    ListView listView;
    private static CustomAdapter adapter;
    private TextView healthBarText;
    private ProgressBar progressBar;
    private BottomNavBar bottomNavBar;
    String TAG = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_tracker);

        // Code ported from the homepage activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.lightGray));
        toolbar.setOnMenuItemClickListener(new MenuItemListener(this)); // listener for menu


        bottomNavBar = BottomNavBar.getInstance(this,findViewById(R.id.bottom_navigation2));
        bottomNavBar.setOnTabSelectedListener(new BottomNavListener(this)); // listener for bottom nav
        bottomNavBar.setCurrentItem(1);

        listView=(ListView)findViewById(R.id.navList);

        healthBarText = (TextView)findViewById(R.id.healthBarText);
        progressBar = (ProgressBar)findViewById(R.id.healthBarTracker);

        progressBar.setProgress(HomePage.avatarHealth);
        healthBarText.setText("Health: " + HomePage.avatarHealth*10 + "/1000");


        dataModels= new ArrayList<>();

        dataModels.add(new ListDataModel("Chest", "Bench x3, SkullCrushers x3,", "1","September 23, 2008"));
        dataModels.add(new ListDataModel("Back", "Barbell Rows x3, PullBacks x3, Bent Over Rows x3", "1","September 23, 2008"));
        dataModels.add(new ListDataModel("Legs", "Squat x3, RDL x4, HipThrusts x3", "1","September 23, 2008"));
        dataModels.add(new ListDataModel("Shoulder", "Arnold Shoudlers x3, Flys x3, Shrugs x3", "1","September 23, 2008"));
        dataModels.add(new ListDataModel("ChestV2", "Bench x1, Barbell Bench x2, Flys x3, Dips x2, Bench x1, Barbell Bench x2, Flys x3, Dips x2", "1","September 23, 2008"));


        adapter= new CustomAdapter(dataModels,this);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ListDataModel dataModel= dataModels.get(position);

//                Snackbar.make(view, dataModel.getName()+"\n"+dataModel.getExercises()+" API: "+dataModel.getVersion_number(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
            }
        });

        RadioGroup imagePicker = (RadioGroup)findViewById(R.id.imagePicker);
        imagePicker.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                Intent myIntent;
                switch(checkedId){
                    case R.id.chest_btn:
                        myIntent = new Intent(getBaseContext(),LogActivity.class);
                        LogActivity.title = "Chest";
                        startActivity(myIntent);
                        break;
                    case R.id.legs_btn:
                        myIntent = new Intent(getBaseContext(),LogActivity.class);
                        LogActivity.title = "Legs";
                        startActivity(myIntent);
                        break;
                    case R.id.shoulder_btn:
                        myIntent = new Intent(getBaseContext(),LogActivity.class);
                        LogActivity.title = "Shoulder";
                        startActivity(myIntent);
                        break;
                    case R.id.back_btn:
                        myIntent = new Intent(getBaseContext(),LogActivity.class);
                        LogActivity.title = "Back";
                        startActivity(myIntent);
                        break;
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setProgress(HomePage.avatarHealth);
        healthBarText.setText("Health: " + HomePage.avatarHealth*10 + "/1000");
        if(bottomNavBar != null){
            bottomNavBar.setCurrentItem(1);
        }

    }


}
