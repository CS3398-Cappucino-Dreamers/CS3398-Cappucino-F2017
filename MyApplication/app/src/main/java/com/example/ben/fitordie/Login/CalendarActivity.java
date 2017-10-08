package com.example.ben.fitordie.Login;

/**
 * Created by chucks on 10/7/2017.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
import com.example.ben.fitordie.R;

public class CalendarActivity extends AppCompatActivity {

    private static final String TAG ="CalendarActivity";
    private CalendarView mCalendarView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_layout);
        mCalendarView = (CalendarView) findViewById(R.id.calendarView);
    }
}
