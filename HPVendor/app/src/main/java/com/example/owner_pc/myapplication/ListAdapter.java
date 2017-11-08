package com.example.owner_pc.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import com.squareup.picasso.Picasso;
import android.graphics.Typeface;

public class ListAdapter extends BaseAdapter {
    public static final String TAG = ListAdapter.class.getSimpleName();

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<ItemList> mDataSource;

    public ListAdapter(Context context, ArrayList<ItemList> items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * Counts how many items are in the data set represented by this Adapter.
     *
     */
    @Override
    public int getCount() {
        return mDataSource.size();
    }

    /**
     * Gets the data item associated with the specified position in the data set.
     *
     */
    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    /**
     * Gets the row id associated with the specified position in the list.
     *
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        // Checks if the view already exists if so, no need to inflate and findViewById again
        if (convertView == null) {
            // Inflate the custom row layout from your XML.
            convertView = mInflater.inflate(R.layout.list_item, parent, false);

            // Creates a new "Holder" with subviews
            holder = new ViewHolder();
            holder.iconView = (ImageView) convertView.findViewById(R.id.icon);
            holder.nameView = (TextView) convertView.findViewById(R.id.name);
            holder.descriptionView = (TextView) convertView.findViewById(R.id.description);
            holder.priceView = (TextView) convertView.findViewById(R.id.price);
            //holder.categoryView = (TextView) convertView.findViewById(R.id.category);

            convertView.setTag(holder);
        }
        else {
            // Skips all the expensive inflation/findViewById and just gets the holder you already made
            holder = (ViewHolder) convertView.getTag();
        }
        // Gets relevant subviews of row view
        TextView nameView = holder.nameView;
        TextView descriptionView = holder.descriptionView;
        TextView priceView = holder.priceView;
        ImageView iconView = holder.iconView;
        //TextView categoryView = holder.categoryView;

        // Gets corresponding item for row
        ItemList list = (ItemList) getItem(position);

        // Updates row view's textviews to display item information
        nameView.setText(list.name);
        descriptionView.setText(list.description);
        priceView.setText(list.price);
        //categoryView.setText(list.category);

        // Uses Picasso to load the image
        Picasso.with(mContext).load(list.icon).placeholder(R.mipmap.ic_launcher).into(iconView);

        return convertView;
    }

    private static class ViewHolder {
        public TextView nameView;
        public TextView descriptionView;
        public TextView priceView;
        public ImageView iconView;
        //public TextView categoryView;
    }
}