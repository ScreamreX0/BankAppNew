package com.example.bankappnew.signin.adapters;

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

import java.text.SimpleDateFormat;

public class AtmAdapter extends ArrayAdapter<items.Atm> {
    Context context;
    items.Atm[] items;
    boolean header = true;


    public AtmAdapter(@NonNull Context context, int resource, @NonNull com.example.bankappnew._pojo.items.Atm[] objects) {
        super(context, resource, objects);

        this.context = context;
        this.items = objects;

    }

    @SuppressLint({"ViewHolder", "SimpleDateFormat"})
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_atm, parent, false);
        ((TextView) view.findViewById(R.id.i_atm_address)).setText(items[position].getAddress());
        ((TextView) view.findViewById(R.id.i_atm_type)).setText(items[position].getType());
        ((TextView) view.findViewById(R.id.i_atm_is_work)).setText(items[position].isWork());

        String time = new SimpleDateFormat("hh.mm").format(items[position].getStartTime()) + "-" +
                new SimpleDateFormat("hh.mm").format(items[position].getEndTime());

        ((TextView) view.findViewById(R.id.i_atm_time)).setText(time);


        return view;
    }
}
