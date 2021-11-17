package com.example.bankappnew.signin.acitvities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.bankappnew.R;
import com.example.bankappnew._pojo.items;
import com.example.bankappnew.signin.adapters.CoursesAdapter;

public class CoursesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        init();
    }

    private void init() {
        setSupportActionBar(findViewById(R.id.a_courses_toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView listView = findViewById(R.id.a_courses_list_view);
        listView.setAdapter(new CoursesAdapter(this, R.layout.item_courses, new items.Course[] {
                new items.Course(R.mipmap.ae, "USD", "Американский доллар", "64.95", "69.96"),
                new items.Course(R.mipmap.ae, "USD", "Американский доллар", "64.95", "69.96"),
                new items.Course(R.mipmap.ae, "USD", "Американский доллар", "64.95", "69.96"),
                new items.Course(R.mipmap.ae, "USD", "Американский доллар", "64.95", "69.96"),
                new items.Course(R.mipmap.ae, "USD", "Американский доллар", "64.95", "69.96"),
                new items.Course(R.mipmap.ae, "USD", "Американский доллар", "64.95", "69.96"),
                new items.Course(R.mipmap.ae, "USD", "Американский доллар", "64.95", "69.96"),
                new items.Course(R.mipmap.ae, "USD", "Американский доллар", "64.95", "69.96"),
        }));
    }
}