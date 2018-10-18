package com.example.usuario.parcialagain;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;

import java.util.List;

/**
 * Created by alumno on 11/10/2018.
 */


public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        MyViewHolder h = new MyViewHolder(v,this.activity);
        return h;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Producto p = this.lista.get(position);
        String s = p.getCantidad().toString();
        holder.txtprecio.setText(p.getPrecio());
        holder.txtcantidad.setText(p.getCantidad());
        holder.txtnombre.setText(p.getNombre());
        holder.setPos(position);


    }

    @Override
    public int getItemCount() {
        return this.lista.size();
    }

     List<Producto> lista;
     MainActivity activity;

    /*public MyAdapter(List<Producto> lista, MainActivity activity) {
        this.lista = lista;
        this.activity=activity;
    }*/
    public MyAdapter(List<Producto> lista, MainActivity activity) {
        this.lista = lista;
        this.activity=activity;
    }
}