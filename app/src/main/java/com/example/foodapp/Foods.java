package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodapp.f_data.GridAdapter;
import com.example.foodapp.f_data.f_data;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Arrays;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Foods extends AppCompatActivity {
    private ArrayList<String> arrayList;
//    private ArrayList<String> foods = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private ListView list;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods2);
        loadData();
        gridView = findViewById(R.id.gridview);
//        list = findViewById(R.id.lv2);
        ArrayList<String> foods = f_data.canMakeFood(arrayList);
        String [] Foods = new String[foods.size()];
        for (int i = 0; i < foods.size(); i++){
            Foods[i] = foods.get(i);
        }
        int [] images = f_data.getImages(Foods);
        GridAdapter gridAdapter = new GridAdapter(Foods.this, Foods, images);
        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Foods.this, "You clicked on " + Foods[position], Toast.LENGTH_SHORT).show();
            }
        });


        Toast.makeText(this, Arrays.toString(Foods), Toast.LENGTH_SHORT).show();
//        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, foods);
//        list.setAdapter(adapter);

    }
    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("item list", null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        arrayList = gson.fromJson(json, type);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }

    }
}