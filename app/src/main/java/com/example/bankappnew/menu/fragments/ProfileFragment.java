package com.example.bankappnew.menu.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bankappnew.R;
import com.example.bankappnew._pojo.items;
import com.example.bankappnew.menu.adapters.SettingsAdapter;

public class ProfileFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        SettingsAdapter settingsAdapter = new SettingsAdapter(getContext(), 0, new items.Setting[] {
                new items.Setting("Изменение пароля"),
                new items.Setting("Изменение логина"),
                new items.Setting("История посещений"),
                new items.Setting("Информация о приложении"),
                new items.Setting("Выход"),
        });

        View view = inflater.inflate(R.layout.f_profile, container, false);
        ((ListView)view.findViewById(R.id.f_profile_settings)).setAdapter(settingsAdapter);
        return view;
    }
}
