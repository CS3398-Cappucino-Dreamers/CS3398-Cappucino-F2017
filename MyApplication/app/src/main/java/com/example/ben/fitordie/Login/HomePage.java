package com.example.ben.fitordie.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.*;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.ben.fitordie.Login.bottomnav.BottomNavBar;
import com.example.ben.fitordie.Login.customviews.CircleProgressBar;
import com.example.ben.fitordie.Login.users.progresscircle.ProgressCircle;
import com.example.ben.fitordie.R;

public class HomePage extends AppCompatActivity {

    private ProgressCircle circleProgressBar;
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

        circleProgressBar = new ProgressCircle(findViewById(R.id.custom_progressBar));
        circleProgressBar.animate(this); // Runs the progress circle animation

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.lightGray));


        BottomNavBar bottomNavBar = BottomNavBar.getInstance(this,findViewById(R. id.bottom_navigation));

        progressField = (TextView)findViewById(R.id.progressField);
        calendarBtn = (Button)findViewById(R.id.calendarBtn);
        setBtnListeners();

        SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);
        goToCalendarIntent = new Intent(this, CalendarActivity.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * Button listener that takes you to the calenar activity.. Just temporary for demo #1
     */
    public void setBtnListeners() {
        calendarBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //startActivity(goToCalendarIntent;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar,menu);

        return super.onCreateOptionsMenu(menu);
    }

    private void addDrawerItems() {
        String[] osArray = { "Home Page", "Calendar", "Logger", "Tracker", "Stats", "Vertical Tester",
                "Vendor", "Settings"};
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
        mDrawerList.setAdapter(mAdapter);
    }


}
