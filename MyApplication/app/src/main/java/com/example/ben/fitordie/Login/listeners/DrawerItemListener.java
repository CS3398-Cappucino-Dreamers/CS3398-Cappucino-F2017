package com.example.ben.fitordie.Login.listeners;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ben.fitordie.Login.Avatar;
import com.example.ben.fitordie.Login.CalendarActivity;
import com.example.ben.fitordie.Login.HomePage;
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
                case 1: intent = new Intent(context, CalendarActivity.class);
                    context.startActivity(intent);
                case 2: intent = new Intent(context, Avatar.class);
                    context.startActivity(intent);
            }
        }
}
