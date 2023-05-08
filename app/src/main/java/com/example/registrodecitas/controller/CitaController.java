package com.example.registrodecitas.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.registrodecitas.model.Cita;
import com.example.registrodecitas.model.DbHelper;
import com.example.registrodecitas.model.DbAdmintrator;

import java.util.ArrayList;

public class CitaController extends DbHelper {
    Context context;

    public CitaController(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public boolean insertCita(String identificacion, String nombre, String email, String fecha) {
        try {
            DbAdmintrator db = new DbAdmintrator();
            db.connectSQL();
            return db.insertRecord(identificacion,nombre,email,fecha);
        } catch (Exception ex) {
            Log.d("MyTag", ex.getMessage());
            return false;
        }
    }

    public ArrayList<Cita> listarCitas() {
        ArrayList<Cita> listaCitas = new ArrayList<>();

        try {
            DbAdmintrator db = new DbAdmintrator();
            db.connectSQL();
            listaCitas = db.consultRecord();
        } catch (Exception ex) {
            ex.toString();
        }

        return listaCitas;
    }
}
