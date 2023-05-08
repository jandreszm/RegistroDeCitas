package com.example.registrodecitas.model;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbAdmintrator {
    private String url = "jdbc:mysql://34.28.132.14:3306/bdcitas";
    private String user = "root";
    private String password = "prueba1234";
    private String instructionSQL;
    Connection connect;

    public boolean connectSQL() {
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, password);
            Log.d("MyTag", "Succesfull connection");
            return true;
        }
        catch (Exception ex) {
            Log.d("MyTag", ex.getMessage());
            return false;
        }
    }

    public boolean insertRecord(String id, String name, String email, String fecha) {
        instructionSQL = "insert into tbl_cita(identificacion,nombre,email,fecha) values ('" + id + "', '" + name + "', '" + email + "', '" + fecha + "');";

        try{
            connect.prepareStatement(instructionSQL).execute();
            return true;
        }
        catch (Exception ex) {
            Log.d("MyTag", ex.getMessage());
            return false;
        }
    }

    public ArrayList<Cita> consultRecord() {
        instructionSQL = "select * from tbl_cita;";
        ArrayList<Cita> listaCitas = new ArrayList<>();

        try{
            ResultSet results = connect.prepareStatement(instructionSQL).executeQuery();
            while (results.next()) {
                Cita c = new Cita();
                c.setId(results.getString("id"));
                c.setIdentificacion(results.getString("identificacion"));
                c.setNombre(results.getString("nombre"));
                c.setEmail(results.getString("email"));
                c.setFecha(results.getString("fecha"));
                listaCitas.add(c);
            }
            return listaCitas;
        }
        catch (Exception ex) {
            Log.d("MyTag", ex.getMessage());
            return null;
        }
    }
}
