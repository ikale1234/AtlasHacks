package com.example.foodapp.f_data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodapp.R;

public class GridAdapter extends BaseAdapter {
    Context context;
    String [] Foods;
    int [] images;

    LayoutInflater inflater;

    public GridAdapter(Context context, String [] Foods, int[] images) {
        this.context = context;
        this.Foods = Foods;
        this.images = images;
    }



    @Override
    public int getCount() {
        return Foods.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.grid_item, null);

        }
        ImageView imageView = convertView.findViewById(R.id.gridimage);
        TextView textView = convertView.findViewById(R.id.item_name);

        imageView.setImageResource(images[position]);
        textView.setText(Foods[position]);
        return convertView;
    }
}
