package com.example.ben.fitordie.Login.listeners;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ben.fitordie.Login.AvatarActivity;
import com.example.ben.fitordie.Login.CalendarActivity;
import com.example.ben.fitordie.Login.HomePage;
import com.example.ben.fitordie.Login.WorkoutTracker;
import com.example.ben.fitordie.R;

/**
 * Created by Ben on 11/8/2017.
 */

public class DrawerItemListener implements ListView.OnItemClickListener {

    private Context context;
    private Intent intent;

    public DrawerItemListener(Context context){
        this.context = context;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch(position){
                case 0:
                    Toast.makeText(context,"Coming in version 2",Toast.LENGTH_SHORT).show();
                    break;
                case 1: intent = new Intent(context, CalendarActivity.class);
                    context.startActivity(intent);
                    break;
                case 2: intent = new Intent(context, WorkoutTracker.class);
                    context.startActivity(intent);
                    break;
                case 3:
                    Toast.makeText(context,"Coming in version 2",Toast.LENGTH_SHORT).show();
                    break;
                case 4:
                    intent = new Intent(context, AvatarActivity.class);
                    context.startActivity(intent);
                    break;



            }
        }
}
