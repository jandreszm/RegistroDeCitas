package com.example.registrodecitas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.registrodecitas.adaptadores.ListaCitasAdapter;
import com.example.registrodecitas.controller.CitaController;
import com.example.registrodecitas.model.Cita;

import java.util.ArrayList;

public class Consult extends AppCompatActivity {
    RecyclerView listaCitas;
    ArrayList<Cita> listaArrayCitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);

        listaCitas = findViewById(R.id.listaCitas);

        listaCitas.setLayoutManager(new LinearLayoutManager(this));

        CitaController cita = new CitaController(Consult.this);

        listaArrayCitas = new ArrayList<Cita>();

        ListaCitasAdapter adapter = new ListaCitasAdapter(cita.listarCitas());
        listaCitas.setAdapter(adapter);
    }
}