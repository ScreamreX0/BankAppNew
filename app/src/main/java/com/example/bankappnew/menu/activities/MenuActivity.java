package com.example.bankappnew.menu.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.bankappnew.R;
import com.example.bankappnew.menu.fragments.MenuFragment;
import com.example.bankappnew.menu.fragments.ProfileFragment;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        init();
    }

    private void init() {

        // App bar
        setSupportActionBar(findViewById(R.id.a_menu_tool_bar));
        getSupportActionBar().setTitle("");

        // Установка имени из внутренней базы shared preferences
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        ((TextView) findViewById(R.id.a_menu_user_name)).setText(sharedPreferences.getString("username", String.valueOf(getApplicationContext())));

        // Утсановка фрагмента
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.a_menu_fragment, new MenuFragment());
        fragmentTransaction.commit();

        // "Слушатель" кнопки профиля
        findViewById(R.id.a_menu_profile_iv).setOnClickListener(view -> {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
            fragmentTransaction2.replace(R.id.a_menu_fragment, new ProfileFragment());
            fragmentTransaction2.commit();
        });
    }
}