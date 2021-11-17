package com.example.bankappnew.signin.acitvities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toolbar;

import com.example.bankappnew.R;
import com.example.bankappnew._pojo.items;
import com.example.bankappnew.signin.adapters.AtmAdapter;

import java.util.Date;

public class AtmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atm);
        init();
    }

    private void init() {
        ListView listView = findViewById(R.id.a_atm_list_view);
        listView.setAdapter(new AtmAdapter(this, 0, new items.Atm[] {
                new items.Atm("Тестовый адрес №1", "Тестовый тип №1", new Date(), new Date()),
                new items.Atm("Тестовый адрес №2", "Тестовый тип №2", new Date(), new Date()),
                new items.Atm("Тестовый адрес №3", "Тестовый тип №3", new Date(), new Date()),
                new items.Atm("Тестовый адрес №4", "Тестовый тип №4", new Date(), new Date()),
                new items.Atm("Тестовый адрес №5", "Тестовый тип №5", new Date(), new Date()),
                new items.Atm("Тестовый адрес №6", "Тестовый тип №6", new Date(), new Date()),
                new items.Atm("Тестовый адрес №7", "Тестовый тип №7", new Date(), new Date()),
                new items.Atm("Тестовый адрес №7", "Тестовый тип №7", new Date(), new Date()),
                new items.Atm("Тестовый адрес №7", "Тестовый тип №7", new Date(), new Date()),
                new items.Atm("Тестовый адрес №7", "Тестовый тип №7", new Date(), new Date()),
                new items.Atm("Тестовый адрес №7", "Тестовый тип №7", new Date(), new Date()),
                new items.Atm("Тестовый адрес №7", "Тестовый тип №7", new Date(), new Date()),
                new items.Atm("Тестовый адрес №7", "Тестовый тип №7", new Date(), new Date()),
        }));

        setSupportActionBar(findViewById(R.id.a_atm_toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Главный экран");
        findViewById(R.id.a_atm_toolbar).setOnClickListener(view -> {

        });

        findViewById(R.id.a_atm_toolbar);
    }
}