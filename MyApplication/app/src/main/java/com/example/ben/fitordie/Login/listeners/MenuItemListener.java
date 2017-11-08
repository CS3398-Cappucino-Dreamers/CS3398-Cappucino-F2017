package com.example.ben.fitordie.Login.listeners;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.ben.fitordie.Login.HPVendor;
import com.example.ben.fitordie.R;

/**
 * Created by Ben on 11/8/2017.
 */

public class MenuItemListener implements android.support.v7.widget.Toolbar.OnMenuItemClickListener {

    private Context context;
    private Intent intent;
    public MenuItemListener(Context context){
        this.context = context;
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {

        switch(item.getTitle().toString()){
            case "vendor":
                intent = new Intent(context, HPVendor.class);
                context.startActivity(intent);

        }

        return true;
    }
}
