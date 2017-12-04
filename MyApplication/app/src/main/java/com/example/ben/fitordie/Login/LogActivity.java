package com.example.ben.fitordie.Login;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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
                stopFlag = true;
                timeCounter.cancel();
            }
        });



        dataModels= new ArrayList<>();

        dataModels.add(new ExerciseDataModel(true,"Bench Press"));
        dataModels.add(new ExerciseDataModel("1", "10" , "350lb", "+"));
        dataModels.add(new ExerciseDataModel("1", "10" , "350lb", "+"));

        dataModels.add(new ExerciseDataModel(true,"Dips"));
        dataModels.add(new ExerciseDataModel("1", "10" , "6", "+"));
        dataModels.add(new ExerciseDataModel("1", "12" , "2", "+"));

        dataModels.add(new ExerciseDataModel(true,"Skull Crushers"));
        dataModels.add(new ExerciseDataModel("1", "12" , "50", "+"));
        dataModels.add(new ExerciseDataModel("1", "12" , "10", "+"));





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


        if(!stopFlag) {
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
}
