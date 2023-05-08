package com.example.registrodecitas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.registrodecitas.controller.CitaController;

public class Register extends AppCompatActivity {
    EditText identificacion;
    EditText name;
    EditText email;
    EditText appointmentDate;

    private void clear() {
        identificacion.setText("");
        name.setText("");
        email.setText("");
        appointmentDate.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        identificacion = (EditText) findViewById(R.id.txtId);
        name = (EditText) findViewById(R.id.txtName);
        email = (EditText) findViewById(R.id.txtEmail);
        appointmentDate = (EditText) findViewById(R.id.txtDate);

        Button btnRegisterUser = (Button) findViewById(R.id.btnRegisterUser);
        Button btnBackRegister = (Button) findViewById(R.id.btnBackRegister);

        btnRegisterUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CitaController cita = new CitaController(Register.this);
                boolean insert = cita.insertCita(identificacion.getText().toString(), name.getText().toString(), email.getText().toString(), appointmentDate.getText().toString());

                if (insert == true) {
                    Toast.makeText(Register.this, "REGISTRO GUARDADO", Toast.LENGTH_SHORT).show();
                    clear();
                } else {
                    Toast.makeText(Register.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnBackRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent vistaRegister = new Intent(Register.this, MainActivity.class);
                startActivity(vistaRegister);
            }
        });
    }
}