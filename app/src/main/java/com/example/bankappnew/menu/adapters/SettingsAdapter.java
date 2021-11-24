package com.example.bankappnew.menu.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bankappnew.R;
import com.example.bankappnew._pojo.items;

public class SettingsAdapter extends ArrayAdapter<items.Setting> {
    Context context;
    items.Setting[] settings;

    public SettingsAdapter(@NonNull Context context, int resource, @NonNull items.Setting[] objects) {
        super(context, resource, objects);
        settings = objects;
        this.context = context;
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_profile_setting, parent, false);

        ((TextView)view.findViewById(R.id.i_profile_setting)).setText(settings[position].getHeader());

        return view;
    }
}
