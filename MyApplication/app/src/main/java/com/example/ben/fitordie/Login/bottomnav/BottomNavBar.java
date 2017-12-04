package com.example.ben.fitordie.Login.bottomnav;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.ben.fitordie.Login.StatsActivity;
import com.example.ben.fitordie.R;

/**
 * Created by Ben on 10/30/2017.
 */

public class BottomNavBar extends AppCompatActivity{

    private static BottomNavBar bottomNavBar;
    private AHBottomNavigationItem item1; // Bottom nav bar button 1(far left)
    private AHBottomNavigationItem item2; // Bottom nav bar button 2(middle)
    private AHBottomNavigationItem item3; // Bottom nav bar button 3(far right)
    private AHBottomNavigation bottomNavigation;
    private Context context;

    private BottomNavBar(final Context context, View view) {
        this.context = context;
        Log.d("", "BottomNavBar: " + context.getString(R.string.botNavBarItem1));
        item1 = new AHBottomNavigationItem(context.getString(R.string.botNavBarItem1), R.drawable.home);
        item2 = new AHBottomNavigationItem(context.getString(R.string.botNavBarItem2), R.drawable.pencil);
        item3 = new AHBottomNavigationItem(context.getString(R.string.botNavBarItem3), R.drawable.graph);
        //Get the bottom nav view from home-page xml
        bottomNavigation = (AHBottomNavigation) view;

        if (bottomNavigation == null) {
            Log.d("", "BottomNavBar: GOD DAMNIT");
        }
        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);

        //bottomNavigation.setCurrentItem(0);

    }


                /**
                 * Allows for only one instance of the bottomNavBar to exist
                 * @return instance of BottomNavBar
                 */
        public static BottomNavBar getInstance(Context context, View view){
            // Having only one instance wasn't working for multiple activites and just the
            // activity lifecycle in general. Now a new one gets instantiated every time. Works.
//        if(bottomNavBar == null){
//            bottomNavBar = new BottomNavBar(context,view);
//        }
            bottomNavBar = new BottomNavBar(context,view);
            return bottomNavBar;
        }

        public void setOnTabSelectedListener(AHBottomNavigation.OnTabSelectedListener listener){
            bottomNavigation.setOnTabSelectedListener(listener);
        }

        public void setCurrentItem(int index){
            bottomNavigation.setCurrentItem(index);
        }
}
