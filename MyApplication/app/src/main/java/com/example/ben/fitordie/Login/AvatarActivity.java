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

import java.util.ArrayList;

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
    private int[] avatarData = new int[4];


    /*********************
     * Set/Refresh Avatar *
     *********************/
    public void setAvatar(int genderIndex, int skinIndex, int hairIndex, int eyeIndex)
    {

        if(genderIndex == 0){
            gender.setImageResource(R.drawable.female_lines);
            background.setImageResource(R.drawable.femalebackground);
            setSkinColor(0,skinIndex);
            setHairColor(0,hairIndex);
            setEyeColor(0,eyeIndex);
        }
        else {
            gender.setImageResource(R.drawable.male_lines);
            background.setImageResource(R.drawable.malebackground);
            setSkinColor(1,skinIndex);
            setHairColor(1,hairIndex);
            setEyeColor(1,eyeIndex);
        }
    }

    /*********************
     * Set Skin Color    *
     *********************/
    public void setSkinColor(int genderIndex, int skinIndex){
        if(skinIndex == 0) {
            if (genderIndex == 0) {
                skinColor.setImageResource(R.drawable.female_skin_tan);
            } else {
                skinColor.setImageResource(R.drawable.male_skin_tan);
            }
        }
        else if(skinIndex == 1) {
            if (genderIndex == 0) {
                skinColor.setImageResource(R.drawable.female_skin_dark);
            } else {
                skinColor.setImageResource(R.drawable.male_skin_dark);
            }
        }
        else if(skinIndex == 2) {
            if (genderIndex == 0) {
                skinColor.setImageResource(R.drawable.female_skin_pale);
            } else {
                skinColor.setImageResource(R.drawable.male_skin_pale);
            }
        }
    }
    /*********************
     * Set Hair Color    *
     *********************/

    public void setHairColor(int genderIndex, int hairIndex){
        if(hairIndex == 0) {
            if (genderIndex == 0) {
                hairColor.setImageResource(R.drawable.female_hair_darkbrown);
            } else {
                hairColor.setImageResource(R.drawable.male_hair_darkbrown);
            }
        }
        else if(hairIndex == 1) {
            if (genderIndex == 0) {
                hairColor.setImageResource(R.drawable.female_hair_lightbrown);
            } else {
                hairColor.setImageResource(R.drawable.male_hair_lightbrown);
            }
        }
        else if(hairIndex == 2) {
            if (genderIndex == 0) {
                hairColor.setImageResource(R.drawable.female_hair_blond);
            } else {
                hairColor.setImageResource(R.drawable.male_hair_blond);
            }
        }
    }

    /******************
     * Set Eye Color  *
     ******************/

    public void setEyeColor(int genderIndex, int eyeIndex){
        if(eyeIndex == 0) {
            if (genderIndex == 0) {
                eyeColor.setImageResource(R.drawable.female_eyes_green);
            } else {
                eyeColor.setImageResource(R.drawable.male_eyes_green);
            }
        }
        else if(eyeIndex == 1) {
            if (genderIndex == 0) {
                eyeColor.setImageResource(R.drawable.female_eyes_blue);
            } else {
                eyeColor.setImageResource(R.drawable.male_eyes_blue);
            }
        }
        else if(eyeIndex == 2) {
            if (genderIndex == 0) {
                eyeColor.setImageResource(R.drawable.female_eyes_brown);
            } else {
                eyeColor.setImageResource(R.drawable.male_eyes_brown);
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar);

        avatarData[0] = 0;
        avatarData[1] = 0;
        avatarData[2] = 0;
        avatarData[3] = 0;


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
        setAvatar(avatarData[0],avatarData[1],avatarData[2],avatarData[3]);



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
                        avatarData[0] = 0;
                        setAvatar(avatarData[0],avatarData[1],avatarData[2],avatarData[3]);
                        break;
                    case 1:
                        avatarData[0] = 1;
                        setAvatar(avatarData[0],avatarData[1],avatarData[2],avatarData[3]);
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
                        avatarData[1] = 0;
                        setAvatar(avatarData[0],avatarData[1],avatarData[2],avatarData[3]);
                        break;
                    case 1:
                        avatarData[1] = 1;
                        setAvatar(avatarData[0],avatarData[1],avatarData[2],avatarData[3]);
                        break;
                    case 2:
                        avatarData[1] = 2;
                        setAvatar(avatarData[0],avatarData[1],avatarData[2],avatarData[3]);
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
                        avatarData[2] = 0;
                        setAvatar(avatarData[0],avatarData[1],avatarData[2],avatarData[3]);
                        break;
                    case 1:
                        avatarData[2] = 1;
                        setAvatar(avatarData[0],avatarData[1],avatarData[2],avatarData[3]);
                        break;
                    case 2:
                        avatarData[2] = 2;
                        setAvatar(avatarData[0],avatarData[1],avatarData[2],avatarData[3]);
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
                        avatarData[3] = 0;
                        setAvatar(avatarData[0],avatarData[1],avatarData[2],avatarData[3]);
                        break;
                    case 1:
                        avatarData[3] = 1;
                        setAvatar(avatarData[0],avatarData[1],avatarData[2],avatarData[3]);
                        break;
                    case 2:
                        avatarData[3] = 2;
                        setAvatar(avatarData[0],avatarData[1],avatarData[2],avatarData[3]);
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
    }
}