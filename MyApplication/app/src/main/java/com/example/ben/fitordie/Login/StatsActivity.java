package com.example.ben.fitordie.Login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.ben.fitordie.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.w3c.dom.Text;

import java.util.Iterator;
import java.util.Random;

public class StatsActivity extends AppCompatActivity {


    private SeekBar seekBar;
    private GraphView graph;
    private Random rand;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        rand = new Random(System.currentTimeMillis());

        textView = (TextView)findViewById(R.id.textView);

        seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBarListener();

        graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3)
        });

        graph.addSeries(series);;
    }




    public void seekBarListener(){
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                graph.removeAllSeries();
                graph.addSeries(new LineGraphSeries<>(new DataPoint[] {
                        new DataPoint(rand.nextInt()%19 + 1, rand.nextInt()%19 + 1),
                        new DataPoint(rand.nextInt()%19 + 1, rand.nextInt()%19 + 1),
                        new DataPoint(rand.nextInt()%19 + 1, rand.nextInt()%19 + 1)
                }));
                String points = "Graph Variant #" + progress;
                textView.setText(points);
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
