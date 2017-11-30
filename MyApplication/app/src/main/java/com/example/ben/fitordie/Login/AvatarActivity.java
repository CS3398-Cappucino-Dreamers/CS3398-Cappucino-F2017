package com.example.ben.fitordie.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import com.example.ben.fitordie.R;

public class AvatarActivity extends AppCompatActivity {
    private Button customizeBtn;
    private ImageView hairColor;
    private ImageView eyeColor;
    private ImageView skinColor;
    private RadioGroup attributes;
    private SeekBar hairBar;
    private SeekBar eyeBar;
    private SeekBar skinBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);

        //customizeBtn = (Button) findViewById(R.id.customize);
        hairColor = (ImageView) findViewById(R.id.hair);
        eyeColor = (ImageView) findViewById(R.id.eyes);
        skinColor = (ImageView) findViewById(R.id.skin);
        attributes = (RadioGroup) findViewById(R.id.attributes);
        hairBar = (SeekBar) findViewById(R.id.hairBar);
        eyeBar = (SeekBar) findViewById(R.id.eyeBar);
        skinBar = (SeekBar) findViewById(R.id.skinBar);

        attributes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch(checkedId)
                {
                    case R.id.skinChoice:
                        skinBar.setVisibility(View.VISIBLE);
                        hairBar.setVisibility(View.INVISIBLE);
                        eyeBar.setVisibility(View.INVISIBLE);
                        // TODO Something
                        break;
                    case R.id.eyeChoice:
                        eyeBar.setVisibility(View.VISIBLE);
                        hairBar.setVisibility(View.INVISIBLE);
                        skinBar.setVisibility(View.INVISIBLE);
                        // TODO Something
                        break;

                    case R.id.hairChoice:
                        hairBar.setVisibility(View.VISIBLE);
                        eyeBar.setVisibility(View.INVISIBLE);
                        skinBar.setVisibility(View.INVISIBLE);
                        // TODO Something
                        break;



                }
            }
        });

        /*

        customizeBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
            //    Intent intent = new Intent(AvatarActivity.this, Customize.class);
            //    startActivity(intent);
                hair.setImageResource(R.drawable.female_hair_lightbrown);

            }
        });

       */
    }
}