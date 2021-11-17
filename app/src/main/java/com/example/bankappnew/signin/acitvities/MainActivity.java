package com.example.bankappnew.signin.acitvities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bankappnew.menu.activities.MenuActivity;
import com.example.bankappnew.R;
import com.example.bankappnew.signin.api.CoursesApi;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        startActivity(new Intent(this, MenuActivity.class));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    @SuppressLint("SimpleDateFormat")
    private void init() {
        (findViewById(R.id.a_main_atms)).setOnClickListener(view -> {
            Intent intent = new Intent(this, AtmActivity.class);
            startActivity(intent);
        });

        (findViewById(R.id.a_main_courses)).setOnClickListener(view -> {
            Intent intent = new Intent(this, CoursesActivity.class);
            startActivity(intent);
        });

        new CoursesApi().execute(findViewById(R.id.a_main_usd), findViewById(R.id.a_main_eur));

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String loginPassword = sharedPreferences.getString("auth", String.valueOf(getApplicationContext()));

        findViewById(R.id.a_main_enter).setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            ConstraintLayout cl = (ConstraintLayout) getLayoutInflater().inflate(R.layout.d_enter, null);
            builder.setView(cl);

            builder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });

            builder.setPositiveButton("Войти", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    String login = ((EditText)cl.findViewById(R.id.d_enter_login)).getText().toString();
                    String password = ((EditText)cl.findViewById(R.id.d_enter_password)).getText().toString();

                    if (login.equals(loginPassword.split(":")[0]) &&
                            password.equals(loginPassword.split(":")[1])) {
                        Intent intent = new Intent(cl.getContext(), MenuActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Неверный логин или пароль", Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                    }
                }
            });

            builder.show();
        });
    }
}