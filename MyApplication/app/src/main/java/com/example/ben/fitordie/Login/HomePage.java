package com.example.ben.fitordie.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.ben.fitordie.Login.bottomnav.BottomNavBar;
import com.example.ben.fitordie.Login.customviews.CircleProgressBar;
import com.example.ben.fitordie.R;

public class HomePage extends AppCompatActivity {

    private TextView progressField;
    private Button calendarBtn;
    private Intent goToCalendarIntent;
    private AHBottomNavigationItem item1; // item1 of the bottom nav bar (Far left)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        BottomNavBar bottomNavBar = BottomNavBar.getInstance(this,findViewById(R.id.bottom_navigation));

        progressField = (TextView)findViewById(R.id.progressField);
        calendarBtn = (Button)findViewById(R.id.calendarBtn);
        setBtnListeners();

        final CircleProgressBar circleProgressBar = (CircleProgressBar)findViewById(R.id.custom_progressBar);
        SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);
        goToCalendarIntent = new Intent(this, CalendarActivity.class);



        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                circleProgressBar.setProgress(progress/10);
                progressField.setText(progress/10 + "." + progress%10);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    /**
     * Button listener that takes you to the calenar activity.. Just temporary for demo #1
     */
    public void setBtnListeners(){
        calendarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(goToCalendarIntent);
            }
        });
    }
}
