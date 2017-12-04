package com.example.ben.fitordie.Login;

/*********************
 * Calendar Activity *
 *********************/


import android.net.ParseException;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

//import com.example.ben.fitordie.Login.constants.time;
import com.example.ben.fitordie.R;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;


public class CalendarActivity extends AppCompatActivity {

    private static final String TAG ="CalendarActivity";
    private CalendarView mCalendarView;
    private TextView dateField;
    private Button createButton;
    private EditText categoryField;
    private EditText descriptionField;
    private LogBook logBook;
    private Date realDate;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //dateField.setText("Date");
        setContentView(R.layout.calendar_layout);
        mCalendarView = (CalendarView) findViewById(R.id.calendarView);
        logBook = new LogBook();
        dateField = (TextView) findViewById(R.id.theDate);
        createButton = (Button) findViewById(R.id.createEvent);
        categoryField = (EditText) findViewById(R.id.theCategory);
        descriptionField = (EditText) findViewById(R.id.theDescription);




        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                categoryField.setText("");
                descriptionField.setText("");
                String date = (month + 1) + "/" + (dayOfMonth) + "/" + year;
                String dateFormat = "MM/dd/yyyy";
                SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
                dateField.setText(date);
                int dateIndex = -1;

                try {
                    realDate = formatter.parse(date);
                    dateIndex = logBook.searchByDate(realDate);
                } catch (java.text.ParseException e) {
                    e.printStackTrace();
                }
                if (dateIndex >= 0) {
                    categoryField.setText(logBook.getLog(dateIndex).getCategory());
                    descriptionField.setText(logBook.getLog(dateIndex).getDescription());
                }

                createButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        logBook.addLog(realDate, categoryField.getText().toString(), descriptionField.getText().toString());
                    }
                });




            }
        });
    }
}
