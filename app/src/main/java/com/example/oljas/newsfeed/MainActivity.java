package com.example.oljas.newsfeed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText inputTitle;
    EditText inputText;
    EditText inputDate;
    EditText inputResourceurl;
    TextView AldisText;
    Spinner spinner;
    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";
    public NewsDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
AldisText=(TextView) findViewById(R.id.aldisText);
     inputTitle=(EditText) findViewById(R.id.inputTitle);
        inputText=(EditText)findViewById(R.id.inputText) ;
        inputDate=(EditText)findViewById(R.id.inputDate);
        inputResourceurl=(EditText)findViewById(R.id.inputResourceurl);
dbHandler=new NewsDBHandler(this,null,null,1);

        String[] foods={"sports", "fashion", "travelling","politics","cooking", "arts","science"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,foods);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner=(Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setPrompt("Categories");
        ListAdapter foodAdapter= new customAdapter(this,foods);
        ListView categoryListView=(ListView)findViewById(R.id.CategoriesView);
        categoryListView.setAdapter(foodAdapter);
        categoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String food= String.valueOf(parent.getItemAtPosition(position));
                Toast.makeText(MainActivity.this,food,Toast.LENGTH_LONG).show();
                Intent d=new Intent(getApplicationContext(),NewsActivity.class);
                d.putExtra(EXTRA_MESSAGE,food);
startActivity(d);

            }
        });

    }
    public void addButtonClicked(View view)
    {

       News novedad=new News(inputTitle.getText().toString(),inputDate.getText().toString(),inputText.getText().toString(),inputResourceurl.getText().toString(),spinner.getSelectedItem().toString());
        dbHandler.addNews(novedad);



    }



}
