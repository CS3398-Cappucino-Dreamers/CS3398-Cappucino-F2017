package com.example.ben.fitordie.Login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Button;

import com.example.ben.fitordie.Login.CalendarActivity;
import com.example.ben.fitordie.Login.bottomnav.BottomNavBar;
import com.example.ben.fitordie.Login.customviews.CircleProgressBar;
import com.example.ben.fitordie.Login.listeners.DrawerItemListener;
import com.example.ben.fitordie.Login.listeners.MenuItemListener;
import com.example.ben.fitordie.R;

/**
 * Created by Lori on 11/15/2017.
 */

public class Avatar extends AppCompatActivity {

    private static final String TAG ="Avatar";
    private Thread animation; // animation thread
    private ProgressBar progressBar;
    private ArrayAdapter<String> mAdapter;
    private ListView mDrawerList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avatar_page);

        mDrawerList = (ListView)findViewById(R.id.navList); // get Drawer ListView
        addDrawerItems(); // populate drawer
        // sets click listeners for the drawer list
        mDrawerList.setOnItemClickListener(new DrawerItemListener(this));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.lightGray));
        toolbar.setOnMenuItemClickListener(new MenuItemListener(this));

        Button customize = (Button) findViewById(R.id.customize);
        // Redirects to avatar shop on button click
        customize.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Avatar.this, AvatarShop.class));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar,menu);

        return super.onCreateOptionsMenu(menu);
    }

    private void addDrawerItems() {
        String[] osArray = { "Homepage","User Stats", "Calendar", "Avatar", "Tracker", "Logbook","Machine Learning", "Settings" };
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
        mDrawerList.setAdapter(mAdapter);
    }
}
