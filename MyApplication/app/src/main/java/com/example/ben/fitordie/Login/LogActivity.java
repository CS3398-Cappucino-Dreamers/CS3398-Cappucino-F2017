package com.example.ben.fitordie.Login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ben.fitordie.Login.DataModels.ExerciseDataModel;
import com.example.ben.fitordie.Login.DataModels.ListDataModel;
import com.example.ben.fitordie.Login.adapters.CustomAdapter;
import com.example.ben.fitordie.Login.adapters.CustomExerciseAdapter;
import com.example.ben.fitordie.Login.bottomnav.BottomNavBar;
import com.example.ben.fitordie.Login.listeners.BottomNavListener;
import com.example.ben.fitordie.Login.listeners.MenuItemListener;
import com.example.ben.fitordie.R;

import java.util.ArrayList;

public class LogActivity extends AppCompatActivity {

    ArrayList<ExerciseDataModel> dataModels;
    ListView listView;
    private static CustomExerciseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        // Code ported from the homepage activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.lightGray));
        toolbar.setOnMenuItemClickListener(new MenuItemListener(this)); // listener for menu


        BottomNavBar bottomNavBar = BottomNavBar.getInstance(this,findViewById(R.id.bottom_navigation2));
        bottomNavBar.setOnTabSelectedListener(new BottomNavListener(this)); // listener for bottom nav

        listView=(ListView)findViewById(R.id.navExerciseList);

        dataModels= new ArrayList<>();
        dataModels.add(new ExerciseDataModel("1", "10" , "350lb", "+"));
        dataModels.add(new ExerciseDataModel("1", "10" , "350lb", "+"));
        dataModels.add(new ExerciseDataModel("1", "10" , "350lb", "+"));
        dataModels.add(new ExerciseDataModel("1", "10" , "350lb", "+"));
        dataModels.add(new ExerciseDataModel("1", "10" , "350lb", "+"));
        dataModels.add(new ExerciseDataModel("1", "10" , "350lb", "+"));
        dataModels.add(new ExerciseDataModel("1", "10" , "350lb", "+"));
        dataModels.add(new ExerciseDataModel("1", "10" , "350lb", "+"));
        dataModels.add(new ExerciseDataModel("1", "10" , "350lb", "+"));
        dataModels.add(new ExerciseDataModel("1", "10" , "350lb", "+"));
        dataModels.add(new ExerciseDataModel("1", "10" , "350lb", "+"));
        dataModels.add(new ExerciseDataModel("1", "10" , "350lb", "+"));




        adapter= new CustomExerciseAdapter(dataModels,getApplicationContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ExerciseDataModel dataModel= dataModels.get(position);

//                Snackbar.make(view, dataModel.getName()+"\n"+dataModel.getExercises()+" API: "+dataModel.getVersion_number(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
            }
        });
    }
}
