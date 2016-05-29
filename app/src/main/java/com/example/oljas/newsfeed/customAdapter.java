package com.example.oljas.newsfeed;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oljas.newsfeed.R;

/**
 * Created by oljas on 28.05.2016.
 */
public class customAdapter extends ArrayAdapter<String> {
    public customAdapter(Context context, String[] foods) {
        super(context, R.layout.custom_row,foods);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater aldisInflater = LayoutInflater.from(getContext());
        View CustomView = aldisInflater.inflate(R.layout.custom_row, parent, false);

        String singleFoodItem = getItem(position);
        TextView aldistext = (TextView) CustomView.findViewById(R.id.aldisText);
        ImageView aldisimage = (ImageView) CustomView.findViewById(R.id.aldisimage);


        aldistext.setText(singleFoodItem);
        int z=getContext().getResources().getIdentifier("drawable/"+singleFoodItem,null, getContext().getPackageName());

        aldisimage.setImageResource(z);

return CustomView;
    }
}
