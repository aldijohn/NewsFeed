package com.example.oljas.newsfeed;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by oljas on 29.05.2016.
 */
public class customNewsAdapter extends ArrayAdapter<String> {

    String[] titles;String[] texts;String[] dates;String[] resourceurl;
    public customNewsAdapter(Context context, String[] titles,String[] texts,String[] dates,String[] resourceurl) {
        super(context, R.layout.custom_row,titles);
        this.titles=titles;
        this.texts=texts;
        this.dates=dates;
        this.resourceurl=resourceurl;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater aldisInflater= LayoutInflater.from(getContext());
        View CustomView=aldisInflater.inflate(R.layout.customnews_row,parent,false);
        String singleTitleItem=getItem(position);
        TextView aldisTitle=(TextView)CustomView.findViewById(R.id.aldisTitle);
        TextView aldisText=(TextView)CustomView.findViewById(R.id.aldisText);
        TextView aldisDate=(TextView)CustomView.findViewById(R.id.aldisDate);
        TextView aldisResourceUrl=(TextView)CustomView.findViewById(R.id.aldisResourceurl);

        aldisTitle.setText(singleTitleItem);
        aldisText.setText(texts[position]);
        aldisDate.setText(dates[position]);
        aldisResourceUrl.setText(resourceurl[position]);


        return CustomView;
    }
}
