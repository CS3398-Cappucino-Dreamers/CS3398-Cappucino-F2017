package com.example.ben.fitordie.Login;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.*;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.ben.fitordie.Login.bottomnav.BottomNavBar;
import com.example.ben.fitordie.Login.customviews.CircleProgressBar;
import com.example.ben.fitordie.Login.listeners.BottomNavListener;
import com.example.ben.fitordie.Login.listeners.DrawerItemListener;
import com.example.ben.fitordie.Login.listeners.MenuItemListener;
import com.example.ben.fitordie.R;

public class HomePage extends AppCompatActivity {

    private CircleProgressBar circleProgressBar;
    private Thread animation; // animation thread
    private TextView progressField;
    private Button calendarBtn;
    private Intent goToCalendarIntent;
    private AHBottomNavigationItem item1; // item1 of the bottom nav bar (Far left)
    private ListView mDrawerList; // listview for the navigation drawer
    private ArrayAdapter<String> mAdapter; // Adapts Data

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        mDrawerList = (ListView)findViewById(R.id.navList); // get Drawer ListView
        addDrawerItems(); // populate drawer
        // sets click listeners for the drawer list
        mDrawerList.setOnItemClickListener(new DrawerItemListener(this));


        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.lightGray));
        toolbar.setOnMenuItemClickListener(new MenuItemListener(this)); // listener for menu


        BottomNavBar bottomNavBar = BottomNavBar.getInstance(this,findViewById(R. id.bottom_navigation));
        bottomNavBar.setOnTabSelectedListener(new BottomNavListener(this)); // listener for bottom nav

        progressField = (TextView)findViewById(R.id.progressField);
        setBtnListeners();

        circleProgressBar = (CircleProgressBar)findViewById(R.id.custom_progressBar);
        goToCalendarIntent = new Intent(this, CalendarActivity.class);
        
    }



    @Override
    protected void onStart() {
        super.onStart();
        circleProgressBar.setProgress(0);
        progressField.setText("");

        new Thread(new Runnable() {
            @Override
            public void run() {


                // Initial Sleep
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Animation
                int b = 0;
                for(int i = 0; i < 70; i++) {
                    final int a = i;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            circleProgressBar.setProgress(a);
                            circleProgressBar.setColor(Color.rgb(0,0,a*3));
                            progressField.setText("Goal: " + a + "% Complete");
                        }
                    });
                    try {

                        Thread.currentThread().sleep(50);
                        if(a >= 50){
                            Thread.currentThread().sleep(b+=5);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * Button listener that takes you to the calenar activity.. Just temporary for demo #1
     */
    public void setBtnListeners() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar,menu);

        return super.onCreateOptionsMenu(menu);
    }

    private void addDrawerItems() {
        String[] osArray = { "User Stats", "Calendar", "Tracker", "Logbook","Machine Learning", "Settings" };
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
        mDrawerList.setAdapter(mAdapter);
    }



}
