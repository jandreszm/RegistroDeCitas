package com.example.registrodecitas.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.registrodecitas.model.Cita;
import com.example.registrodecitas.model.DbHelper;

import java.util.ArrayList;

public class CitaController extends DbHelper {
    Context context;

    public CitaController(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertCita(String identificacion, String nombre, String email, String fecha) {
        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("identificacion", identificacion);
            values.put("nombre", nombre);
            values.put("email", email);
            values.put("fecha", fecha);

            id = db.insert(TABLE_CITAS, null, values);
        } catch (Exception ex) {
            ex.toString();
        }

        return id;
    }

    public ArrayList<Cita> listarCitas() {
        Cita cita = null;
        Cursor cursorCitas = null;
        ArrayList<Cita> listaCitas = new ArrayList<>();

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            cursorCitas = db.rawQuery("select * from " + TABLE_CITAS, null);

            if (cursorCitas.moveToFirst()){
                do {
                    cita = new Cita();
                    cita.setId(cursorCitas.getString(0));
                    cita.setIdentificacion(cursorCitas.getString(1));
                    cita.setNombre(cursorCitas.getString(2));
                    cita.setEmail(cursorCitas.getString(3));
                    cita.setFecha(cursorCitas.getString(4));
                    listaCitas.add(cita);
                } while (cursorCitas.moveToNext());
            }

            cursorCitas.close();
        } catch (Exception ex) {
            ex.toString();
        }

        return listaCitas;
    }
}
