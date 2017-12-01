package com.example.ben.fitordie.Login.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ben.fitordie.Login.DataModels.ExerciseDataModel;
import com.example.ben.fitordie.Login.DataModels.ListDataModel;
import com.example.ben.fitordie.Login.LogActivity;
import com.example.ben.fitordie.R;

import java.util.ArrayList;

import static com.example.ben.fitordie.Login.ItemList.TAG;

/**
 * Created by The Dough Boys on 11/29/2017.
 */

public class CustomExerciseAdapter extends ArrayAdapter<ExerciseDataModel> implements View.OnClickListener {


    private ArrayList<ExerciseDataModel> dataSet;

    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtSet;
        TextView txtRep;
        TextView txtWeight;
        TextView txtDone;
    }

    public CustomExerciseAdapter(ArrayList<ExerciseDataModel> data, Context context) {
        super(context, R.layout.row_item, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        Intent intent;
        /*int position=(Integer) v.getTag();
        Object object= getItem(position);
        ListDataModel dataModel=(ListDataModel)object*/;

        switch (v.getId())
        {
//            case R.id.set:
//                intent = new Intent(mContext, LogActivity.class);
//                mContext.startActivity(intent);
//                break;
//            case R.id.editBtn:
//                Log.d(TAG, "onClick: ");
////                intent = new Intent(mContext, LogActivity.class);
////                mContext.startActivity(intent);
//                break;

        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ExerciseDataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_exercise_item, parent, false);
            viewHolder.txtSet = (EditText) convertView.findViewById(R.id.setNumber);
            viewHolder.txtRep = (EditText) convertView.findViewById(R.id.reps);
            viewHolder.txtWeight = (EditText) convertView.findViewById(R.id.weight);
            viewHolder.txtDone = (EditText) convertView.findViewById(R.id.done);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        if(viewHolder.txtSet == null){
            Log.d(TAG, "getView: nulll");
        }
        viewHolder.txtSet.setText(dataModel.getSetNumber());
        viewHolder.txtRep.setText(dataModel.getReps());
        viewHolder.txtWeight.setText(dataModel.getWeight());
        viewHolder.txtDone.setText(dataModel.getDone());
        // Return the completed view to render on screen
        Log.d(TAG, "getView: " + (convertView == null));
        return convertView;

    }
}
