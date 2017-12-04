package com.example.ben.fitordie.Login.listeners;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.example.ben.fitordie.Login.HomePage;
import com.example.ben.fitordie.Login.LogActivity;
import com.example.ben.fitordie.Login.StatsActivity;
import com.example.ben.fitordie.Login.WorkoutTracker;

/**
 * Created by Ben on 11/8/2017.
 */

public class BottomNavListener implements AHBottomNavigation.OnTabSelectedListener {

    private Context context;
    private Intent intent;

    public BottomNavListener(Context context){
        this.context = context;
    }
    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {


        switch(position){

            case 0:
                if(context.getClass() != HomePage.class) {
                    intent = new Intent(context, HomePage.class);
                    context.startActivity(intent);
                }
                break;
            case 2:
                Toast.makeText(context,"Coming in V2",Toast.LENGTH_SHORT);
                break;
            case 1:
                if(context.getClass() != WorkoutTracker.class) {
                    intent = new Intent(context, WorkoutTracker.class);
                    context.startActivity(intent);
                }
                break;
        }

        return true;
    }
}
