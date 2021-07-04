package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText item;
    private Button addItem, removeItem;
    private ListView list;
    private ArrayList <String> arrayList;
    private ArrayAdapter<String> adapter;
//    public static final String sharedPrefs = "shared prefs";
    public static final ArrayList <String> finalList = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\">"+ getString(R.string.app_name)+ "</font>"));
        item =findViewById(R.id.et_Item);
        addItem = findViewById(R.id.btn_addItem);
        list = findViewById(R.id.lv2);
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
                saveData();
                Intent intent = new Intent(MainActivity.this,Foods.class);
                startActivity(intent);

            }
        });
    }
    private void saveData (){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(arrayList);
        editor.putString("item list", json);
        editor.apply();


    }
}