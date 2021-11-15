package com.example.bankappnew.signin.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bankappnew.R;
import com.example.bankappnew._pojo.items;

public class AtmAdapter extends ArrayAdapter<items.Atm> {
    Context context;
    items.Atm[] items;


    public AtmAdapter(@NonNull Context context, int resource, @NonNull com.example.bankappnew._pojo.items.Atm[] objects) {
        super(context, resource, objects);

        this.context = context;
        this.items = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        return super.getView(position, convertView, parent);
    }
}
