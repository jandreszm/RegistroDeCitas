package com.example.registrodecitas;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.registrodecitas.model.DbHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String path;
        SQLiteDatabase checkDB = null;

        try {
            if (Build.VERSION.SDK_INT >= 17) {
                path = MainActivity.this.getApplicationInfo().dataDir + "/databases/";
            } else {
                path = "/data/data/" + MainActivity.this.getPackageName() + "/databases/";
            }

            path = path + "citas.db";

            checkDB = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);

            DbHelper dbHelper = null;
            if (checkDB == null) {
                dbHelper = new DbHelper(MainActivity.this);

                SQLiteDatabase db = dbHelper.getWritableDatabase();

                if (db != null) {
                    Toast.makeText(MainActivity.this, "BASE DE DATOS CREADA", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "ERROR AL CREAR BASE DE DATOS", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(MainActivity.this, "YA EXISTE BASE DE DATOS", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception ex){
            ex.toString();
        }

        Button btnRegister = (Button) findViewById(R.id.btnRegister);
        Button btnConsult = (Button) findViewById(R.id.btnConsult);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent vistaRegister = new Intent(MainActivity.this, Register.class);
                startActivity(vistaRegister);
            }
        });

        btnConsult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent vistaConsult = new Intent(MainActivity.this, Consult.class);
                startActivity(vistaConsult);
            }
        });
    }
}