package com.example.registrodecitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.registrodecitas.model.DbAdmintrator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRegister = (Button) findViewById(R.id.btnRegister);
        Button btnConsult = (Button) findViewById(R.id.btnConsult);

        DbAdmintrator base = new DbAdmintrator();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                boolean confirm = base.connectSQL();

                if (confirm == true){
                    Intent vistaRegister = new Intent(MainActivity.this, Register.class);
                    startActivity(vistaRegister);
                } else {
                    Toast.makeText(MainActivity.this, "No se pudo conectar a la base de datos", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnConsult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                boolean confirm = base.connectSQL();

                if (confirm == true){
                    Intent vistaConsult = new Intent(MainActivity.this, Consult.class);
                    startActivity(vistaConsult);
                } else {
                    Toast.makeText(MainActivity.this, "No se pudo conectar a la base de datos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}