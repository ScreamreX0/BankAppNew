package com.example.bankappnew.signin.acitvities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.bankappnew.R;
import com.example.bankappnew.signin.api.CoursesApi;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    @SuppressLint("SimpleDateFormat")
    private void init() {
        new CoursesApi().execute(findViewById(R.id.a_main_usd), findViewById(R.id.a_main_eur));
    }
}