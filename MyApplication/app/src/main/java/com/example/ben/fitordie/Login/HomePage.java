package com.example.ben.fitordie.Login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.ben.fitordie.Login.customviews.CircleProgressBar;
import com.example.ben.fitordie.R;

public class HomePage extends AppCompatActivity {

    private TextView progressField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        progressField = (TextView)findViewById(R.id.progressField);

        final CircleProgressBar circleProgressBar = (CircleProgressBar)findViewById(R.id.custom_progressBar);
        SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);

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
}
