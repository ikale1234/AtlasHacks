package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import com.example.foodapp.f_data.f_data;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Foods extends AppCompatActivity {
    private ArrayList<String> arrayList;
//    private ArrayList<String> foods = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods2);
        loadData();
        list = findViewById(R.id.lv2);
        ArrayList<String> foods = f_data.canMakeFood(arrayList);
//        Toast.makeText(this, arrayList.toString(), Toast.LENGTH_SHORT).show();
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, foods);
        list.setAdapter(adapter);

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