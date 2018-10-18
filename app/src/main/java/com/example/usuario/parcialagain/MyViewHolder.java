package com.example.usuario.parcialagain;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by alumno on 11/10/2018.
 */

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    TextView txtcantidad;
    TextView txtprecio;
    TextView txtnombre;
    MainActivity activity;
    Button mas;
    Button menos;
    int pos;


   /* public MyViewHolder(View itemView,MainActivity activity) {
        super(itemView);
        this.activity = activity;
        this.txtcantidad =(TextView) itemView.findViewById(R.id.txtCantidad);
        this.txtprecio =(TextView) itemView.findViewById(R.id.txtPrecio);
        this.mas = (Button) itemView.findViewById(R.id.btnMas);
        this.menos=(Button) itemView.findViewById(R.id.btnMenos);
        this.mas.setOnClickListener(this);
        this.menos.setOnClickListener(this);

    }*/

    public MyViewHolder(View itemView, MainActivity activity) {
        super(itemView);
        this.txtcantidad =(TextView) itemView.findViewById(R.id.txtCantidad);
        this.txtprecio =(TextView) itemView.findViewById(R.id.txtPrecio);
        this.txtnombre =(TextView) itemView.findViewById(R.id.txtNombre);
        this.mas = (Button) itemView.findViewById(R.id.btnMas);
        this.menos=(Button) itemView.findViewById(R.id.btnMenos);
        this.activity = activity;
        this.mas.setOnClickListener(this);
        this.menos.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        int x=0;
        if(v.getId() == this.mas.getId()) {
            Log.d("TEST", "Presiono Mas" + this.mas.getId());
            x=1;
        }
        if(v.getId() == this.menos.getId()) {
            Log.d("TEST", "Presiono Menos" + this.menos.getId());
            x=2;
        }
        this.activity.Nose(pos,x);


    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}