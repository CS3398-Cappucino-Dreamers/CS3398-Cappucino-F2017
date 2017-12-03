package com.example.ben.fitordie.Login.listeners;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.example.ben.fitordie.Login.StatsActivity;

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
        Toast.makeText(context, "Selected" + position, Toast.LENGTH_SHORT).show();
        switch(position){


            case 2:
                Intent intent = new Intent(context, StatsActivity.class);
                context.startActivity(intent);
        }

        return true;
    }
}
