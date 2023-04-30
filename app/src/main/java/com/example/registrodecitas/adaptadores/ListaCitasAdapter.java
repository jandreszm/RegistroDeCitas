package com.example.registrodecitas.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.registrodecitas.R;
import com.example.registrodecitas.model.Cita;

import java.util.ArrayList;

public class ListaCitasAdapter extends RecyclerView.Adapter<ListaCitasAdapter.CitaViewHolder> {
    ArrayList<Cita> listaCitas;

    public ListaCitasAdapter(ArrayList<Cita> listaCitas) {
        this.listaCitas= listaCitas;
    }

    @NonNull
    @Override
    public CitaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_cita, null, false);
        return new CitaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CitaViewHolder holder, int position) {
        holder.viewIdentificacion.setText(listaCitas.get(position).getIdentificacion());
        holder.viewNombre.setText(listaCitas.get(position).getNombre());
        holder.viewEmail.setText(listaCitas.get(position).getEmail());
        holder.viewFecha.setText(listaCitas.get(position).getFecha());
    }

    @Override
    public int getItemCount() {
        return listaCitas.size();
    }

    public class CitaViewHolder extends RecyclerView.ViewHolder {
        TextView viewIdentificacion, viewNombre, viewEmail, viewFecha;
        public CitaViewHolder(@NonNull View itemView) {
            super(itemView);

            viewIdentificacion = itemView.findViewById(R.id.viewIdentificacion);
            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewEmail = itemView.findViewById(R.id.viewEmail);
            viewFecha = itemView.findViewById(R.id.viewFecha);
        }
    }
}
