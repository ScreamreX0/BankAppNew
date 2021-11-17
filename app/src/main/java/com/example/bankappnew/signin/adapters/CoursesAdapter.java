package com.example.bankappnew.signin.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bankappnew.R;
import com.example.bankappnew._pojo.items;

import java.text.SimpleDateFormat;

public class CoursesAdapter extends ArrayAdapter<items.Course> {
    Context context;
    items.Course[] items;
    int resourse;


    public CoursesAdapter(@NonNull Context context, int resource, @NonNull items.Course[] objects) {
        super(context, resource, objects);

        this.context = context;
        this.items = objects;
        this.resourse = resource;

    }

    @SuppressLint({"ViewHolder", "SimpleDateFormat"})
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(resourse, parent, false);

        ((TextView)view.findViewById(R.id.i_courses_buy)).setText(items[position].getBuy());
        ((TextView)view.findViewById(R.id.i_courses_full_name)).setText(items[position].getFullName());
        ((ImageView)view.findViewById(R.id.i_courses_icon)).setImageResource(items[position].getIcon());
        ((TextView)view.findViewById(R.id.i_courses_name)).setText(items[position].getName());
        ((TextView)view.findViewById(R.id.i_courses_sell)).setText(items[position].getSell());

        return view;
    }
}
