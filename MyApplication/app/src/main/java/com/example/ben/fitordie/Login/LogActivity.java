package com.example.ben.fitordie.Login;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.*;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ben.fitordie.Login.DataModels.ExerciseDataModel;
import com.example.ben.fitordie.Login.DataModels.ListDataModel;
import com.example.ben.fitordie.Login.adapters.CustomAdapter;
import com.example.ben.fitordie.Login.adapters.CustomExerciseAdapter;
import com.example.ben.fitordie.Login.bottomnav.BottomNavBar;
import com.example.ben.fitordie.Login.listeners.BottomNavListener;
import com.example.ben.fitordie.Login.listeners.MenuItemListener;
import com.example.ben.fitordie.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class LogActivity extends AppCompatActivity {

    public static boolean stopFlag = false;
    public static int time = 0;
    public Timer timeCounter;
    ArrayList<ExerciseDataModel> dataModels;
    ListView listView;
    private static CustomExerciseAdapter adapter;
    private TextView timeTxt;
    private TextView pointsTxt;
    private Button stopButton;
    public static  String title = "Chest";
    String TAG = "";
    private TextView workoutTitle;


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

        timeTxt = (TextView)findViewById(R.id.timeText);
        listView=(ListView)findViewById(R.id.navExerciseList);
        pointsTxt =(TextView)findViewById(R.id.pointAccumulator);
        pointsTxt.setText("Points: +"+ time / 5);
        stopButton= (Button)findViewById(R.id.stopButton);

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeCounter.cancel();
                time = 0;
            }
        });



        dataModels= new ArrayList<>();


        if(title.equals("Chest"))
            addChestWorkout(dataModels);
        if(title.equals("Back"))
            addBackWorkout(dataModels);
        if(title.equals("Shoulder"))
            addShouldersWorkout(dataModels);
        if(title.equals("Legs"))
            addLegWorkout(dataModels);


        workoutTitle = (TextView)findViewById(R.id.workoutTitle);
        workoutTitle.setText(title);



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


        if(timeCounter == null) {
            timeCounter = new Timer();
            timeCounter.schedule(new updateTime(), 0, 1000);
        }



    }
    @Override
    protected void onPause() {
        super.onPause();
        if(timeCounter != null)
            timeCounter.cancel();
    }

    class updateTime extends TimerTask{

        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                   time++;
                    timeTxt.setText("Seconds: " + time);
                    if(time%5 == 0) {
                        HomePage.avatarHealth++;
                        if(pointsTxt != null)
                            pointsTxt.setText("Points: +" + time / 5);
                    }
                }
            });
        }
    }

    public void addChestWorkout(ArrayList<ExerciseDataModel> dataModel){

        dataModels.add(new ExerciseDataModel(true,"Bench Press"));
        dataModels.add(new ExerciseDataModel("1", "10" , "135lb"));
        dataModels.add(new ExerciseDataModel("2", "10" , "155lb"));
        dataModels.add(new ExerciseDataModel("3", "8" , "165lb"));

        dataModels.add(new ExerciseDataModel(true,"Dips"));
        dataModels.add(new ExerciseDataModel("1", "10" , "N/A"));
        dataModels.add(new ExerciseDataModel("2", "12" , "N/A"));
        dataModels.add(new ExerciseDataModel("3", "12" , "N/A"));

        dataModels.add(new ExerciseDataModel(true,"Skull Crushers"));
        dataModels.add(new ExerciseDataModel("1", "12" , "30lb"));
        dataModels.add(new ExerciseDataModel("2", "12" , "40lb"));
        dataModels.add(new ExerciseDataModel("3", "12" , "40lb"));
    }


    public void addShouldersWorkout(ArrayList<ExerciseDataModel> dataModel){

        dataModels.add(new ExerciseDataModel(true,"Arnold Shoulders"));
        dataModels.add(new ExerciseDataModel("1", "10" , "135lb"));
        dataModels.add(new ExerciseDataModel("2", "10" , "155lb"));
        dataModels.add(new ExerciseDataModel("3", "8" , "165lb"));

        dataModels.add(new ExerciseDataModel(true,"Flys"));
        dataModels.add(new ExerciseDataModel("1", "10" , "10lb"));
        dataModels.add(new ExerciseDataModel("2", "12" , "20lb"));
        dataModels.add(new ExerciseDataModel("3", "12" , "25lb"));

        dataModels.add(new ExerciseDataModel(true,"Shrugs"));
        dataModels.add(new ExerciseDataModel("1", "12" , "150lb"));
        dataModels.add(new ExerciseDataModel("2", "12" , "170lb"));
        dataModels.add(new ExerciseDataModel("3", "12" , "190lb"));
    }

    public void addBackWorkout(ArrayList<ExerciseDataModel> dataModel){

        dataModels.add(new ExerciseDataModel(true,"Barbell Rows"));
        dataModels.add(new ExerciseDataModel("1", "10" , "135lb"));
        dataModels.add(new ExerciseDataModel("2", "10" , "155lb"));
        dataModels.add(new ExerciseDataModel("3", "8" , "165lb"));

        dataModels.add(new ExerciseDataModel(true,"PullBacks"));
        dataModels.add(new ExerciseDataModel("1", "10" , "10lb"));
        dataModels.add(new ExerciseDataModel("2", "12" , "20lb"));
        dataModels.add(new ExerciseDataModel("3", "12" , "25lb"));

        dataModels.add(new ExerciseDataModel(true,"Bent Over Rows"));
        dataModels.add(new ExerciseDataModel("1", "12" , "150lb"));
        dataModels.add(new ExerciseDataModel("2", "12" , "170lb"));
        dataModels.add(new ExerciseDataModel("3", "12" , "190lb"));
    }



    public void addLegWorkout(ArrayList<ExerciseDataModel> dataModel){

        dataModels.add(new ExerciseDataModel(true,"Squat"));
        dataModels.add(new ExerciseDataModel("1", "10" , "135lb"));
        dataModels.add(new ExerciseDataModel("2", "10" , "155lb"));
        dataModels.add(new ExerciseDataModel("3", "8" , "165lb"));

        dataModels.add(new ExerciseDataModel(true,"RDL"));
        dataModels.add(new ExerciseDataModel("1", "10" , "10lb"));
        dataModels.add(new ExerciseDataModel("2", "12" , "20lb"));
        dataModels.add(new ExerciseDataModel("3", "12" , "25lb"));

        dataModels.add(new ExerciseDataModel(true,"Hip Thrusts"));
        dataModels.add(new ExerciseDataModel("1", "12" , "150lb"));
        dataModels.add(new ExerciseDataModel("2", "12" , "170lb"));
        dataModels.add(new ExerciseDataModel("3", "12" , "190lb"));
    }




}
