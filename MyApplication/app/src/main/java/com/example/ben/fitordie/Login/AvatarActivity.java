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
    private ImageView background;

    private ImageView gender;
    private RadioGroup attributes;
    private SeekBar hairBar;
    private SeekBar eyeBar;
    private SeekBar skinBar;
    private SeekBar genderBar;
    private int genderFlag;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);



        customizeBtn = (Button) findViewById(R.id.customize);
        gender = (ImageView) findViewById(R.id.gender);
        hairColor = (ImageView) findViewById(R.id.hair);
        eyeColor = (ImageView) findViewById(R.id.eyes);
        skinColor = (ImageView) findViewById(R.id.skin);
        background = (ImageView) findViewById(R.id.background);

        attributes = (RadioGroup) findViewById(R.id.attributes);
        hairBar = (SeekBar) findViewById(R.id.hairBar);
        eyeBar = (SeekBar) findViewById(R.id.eyeBar);
        skinBar = (SeekBar) findViewById(R.id.skinBar);
        genderBar = (SeekBar) findViewById(R.id.genderBar);
        genderFlag = 0;



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

        genderBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                switch(progress){
                    case 0:
                        gender.setImageResource(R.drawable.female_lines);
                        eyeColor.setImageResource(R.drawable.female_eyes_green);
                        hairColor.setImageResource(R.drawable.female_hair_lightbrown);
                        skinColor.setImageResource(R.drawable.female_skin_tan);
                        background.setImageResource(R.drawable.femalebackground);

                        eyeBar.setVisibility(View.INVISIBLE);
                        skinBar.setVisibility(View.INVISIBLE);
                        hairBar.setVisibility(View.INVISIBLE);

                        genderFlag = 0;
                        break;
                    case 1:
                        gender.setImageResource(R.drawable.male_lines);
                        hairColor.setImageResource(R.drawable.male_hair_lightbrown);
                        eyeColor.setImageResource(R.drawable.male_eyes_green);
                        skinColor.setImageResource(R.drawable.male_skin_tan);
                        background.setImageResource(R.drawable.malebackground);

                        eyeBar.setVisibility(View.INVISIBLE);
                        skinBar.setVisibility(View.INVISIBLE);
                        hairBar.setVisibility(View.INVISIBLE);


                        genderFlag = 1;
                        break;
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        hairBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                switch(progress){
                    case 0:
                        if(genderFlag == 0) {
                            hairColor.setImageResource(R.drawable.female_hair_lightbrown);
                        }
                        else {
                            hairColor.setImageResource(R.drawable.male_hair_lightbrown);
                        }
                        break;
                    case 1:
                        if(genderFlag == 0) {
                            hairColor.setImageResource(R.drawable.female_hair_darkbrown);
                        }
                        else {
                            hairColor.setImageResource(R.drawable.male_hair_darkbrown);
                        }
                        break;
                    case 2:
                        if(genderFlag == 0) {
                            hairColor.setImageResource(R.drawable.female_hair_blond);
                        }
                        else {
                            hairColor.setImageResource(R.drawable.male_hair_blond);
                        }
                        break;
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        eyeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                switch(progress){
                    case 0:
                        if(genderFlag == 0) {
                            eyeColor.setImageResource(R.drawable.female_eyes_green);
                        }
                        else {
                            eyeColor.setImageResource(R.drawable.male_eyes_green);
                        }
                        break;
                    case 1:
                        if(genderFlag == 0) {
                            eyeColor.setImageResource(R.drawable.female_eyes_blue);
                        }
                        else {
                            eyeColor.setImageResource(R.drawable.male_eyes_blue);
                        }
                        break;
                    case 2:
                        if(genderFlag == 0) {
                            eyeColor.setImageResource(R.drawable.female_eyes_brown);
                        }
                        else {
                            eyeColor.setImageResource(R.drawable.male_eyes_brown);
                        }
                        break;
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        skinBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                switch(progress){
                    case 0:
                        if(genderFlag == 0) {
                            skinColor.setImageResource(R.drawable.female_skin_tan);
                        }
                        else {
                            skinColor.setImageResource(R.drawable.male_skin_tan);
                        }
                        break;
                    case 1:
                        if(genderFlag == 0) {
                            skinColor.setImageResource(R.drawable.female_skin_dark);
                        }
                        else {
                            skinColor.setImageResource(R.drawable.male_skin_dark);
                        }
                        break;
                    case 2:
                        if(genderFlag == 0) {
                            skinColor.setImageResource(R.drawable.female_skin_pale);
                        }
                        else {
                            skinColor.setImageResource(R.drawable.male_skin_pale);
                        }
                        break;
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



/*
        customizeBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
            //    Intent intent = new Intent(AvatarActivity.this, Customize.class);
            //    startActivity(intent);
                hairColor.setImageResource(R.drawable.female_hair_lightbrown);

            }
        });

*/
    }
}