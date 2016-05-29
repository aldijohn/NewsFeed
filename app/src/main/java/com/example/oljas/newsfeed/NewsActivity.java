package com.example.oljas.newsfeed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

public class NewsActivity extends AppCompatActivity {


    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        NewsDBHandler dbHandler=new NewsDBHandler(this,null,null,1);
Intent d=getIntent();
        String z=d.getStringExtra(EXTRA_MESSAGE);
        String[] titles=dbHandler.titlearray(z);
        String[] texts=dbHandler.textsarray(z);
        String[] dates=dbHandler.datearray(z);
        String[] resourceurl=dbHandler.sourceurlsarray(z);
        ListAdapter titleadapter=new customNewsAdapter(this,titles,texts,dates,resourceurl);
        ListView newsListView=(ListView)findViewById(R.id.newsListView);
        newsListView.setAdapter(titleadapter);

    }
}
