package com.example.ben.fitordie.Login.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ben.fitordie.Login.DataModels.ListDataModel;
import com.example.ben.fitordie.Login.LogActivity;
import com.example.ben.fitordie.R;

import java.util.ArrayList;

import static com.example.ben.fitordie.Login.ItemList.TAG;

/**
 * Created by The Dough Boys on 11/29/2017.
 */

public class CustomAdapter extends ArrayAdapter<ListDataModel> implements View.OnClickListener {


    private ArrayList<ListDataModel> dataSet;
    private Intent intent;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtExercises;
        ImageView go;
        ImageView edit;
        int index;
    }

    public CustomAdapter(ArrayList<ListDataModel> data, Context context) {
        super(context, R.layout.row_item, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {


        /*int position=(Integer) v.getTag();
        Object object= getItem(position);
        ListDataModel dataModel=(ListDataModel)object*/;

        switch (v.getId())
        {
            case R.id.go:
                goToCorrectLog((String)v.getTag());
                break;
            case R.id.editBtn:
                Log.d(TAG, "onClick: ");
//                intent = new Intent(mContext, LogActivity.class);
//                mContext.startActivity(intent);
                break;

        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ListDataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtExercises = (TextView) convertView.findViewById(R.id.exercises);
            viewHolder.go = (ImageView) convertView.findViewById(R.id.go);
            viewHolder.edit = (ImageView) convertView.findViewById(R.id.editBtn);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.txtName.setText(dataModel.getName());
        viewHolder.txtExercises.setText(dataModel.getExercises());
        viewHolder.go.setOnClickListener(this);
        viewHolder.go.setTag(viewHolder.txtName.getText());
        viewHolder.edit.setOnClickListener(this);
        // Return the completed view to render on screen
        Log.d(TAG, "getView: " + (convertView == null));
        return convertView;

    }

    public void goToCorrectLog(String title){

        Intent myIntent = new Intent(mContext,LogActivity.class);
        LogActivity.title = title;
        mContext.startActivity(myIntent);
        Log.d(TAG, "goToCorrectLog: "+ title);
    }
}
