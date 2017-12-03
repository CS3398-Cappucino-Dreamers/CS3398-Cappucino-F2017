package com.example.ben.fitordie.Login;

import android.content.Context;
import android.graphics.drawable.LayerDrawable;

import com.example.ben.fitordie.R;

/**
 * Created by Lori on 11/29/2017.
 */

public class AvatarDrawable{
    public LayerDrawable avatar;
    //public Drawable gender;//index: 3
    //public Drawable skin;  //index: 0
    //public Drawable eye;   //index: 1
    //public Drawable hair;  //index: 2

    AvatarDrawable(Context context) {
        avatar.addLayer(context.getDrawable(R.drawable.female_skin_pale));
        avatar.addLayer(context.getDrawable(R.drawable.female_eyes_green));
        avatar.addLayer(context.getDrawable(R.drawable.female_hair_lightbrown));
        avatar.addLayer(context.getDrawable(R.drawable.female_lines));
    }
    public LayerDrawable getAvatar(){
        return avatar;
    }

    public void setGender(char gender,Context context) {
        if (gender == 'f')
            avatar.setDrawable(3, context.getDrawable(R.drawable.female_lines));

    }

}
