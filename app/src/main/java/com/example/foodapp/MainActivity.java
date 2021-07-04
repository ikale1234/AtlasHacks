package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText item;
    private Button addItem, removeItem;
    private ListView list;
    private ArrayList <String> arrayList;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\">"+ getString(R.string.app_name)+ "</font>"));
        item =findViewById(R.id.et_Item);
        addItem = findViewById(R.id.btn_addItem);
        list = findViewById(R.id.lv);
        removeItem = findViewById(R.id.btn_removeItem);

        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayList);
        list.setAdapter(adapter);

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.add(item.getText().toString());
                adapter.notifyDataSetChanged();
                item.getText().clear();
            }
        });
        removeItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.remove(arrayList.size()-1);
                adapter.notifyDataSetChanged();
            }
        });

        nextButton();

    }
    public void nextButton (){
        Button findButton = findViewById(R.id.btn_findFood);
        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Foods.class));
            }
        });
    }
}