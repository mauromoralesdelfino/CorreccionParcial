package com.example.usuario.parcialagain;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.lang.*;
import java.util.concurrent.ExecutionException;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    Handler h;
    URL url;
    RecyclerView rvProductos;
    List<Producto> p;
    MyAdapter adapter;
    Thread hilo;
    Worker w;
    List<Producto> j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //url = new URL("192.168.2.231:8080/Prodcutos.xml");
        h=new Handler(this);
       // Worker w = new Worker(h,"http://192.168.2.231:8080/Productos.xml");
         w = new Worker(h,"file:///C:/Users/Usuario/Downloads/dataset.xml");
        hilo = new Thread(w);
        hilo.start();

        p = new ArrayList<>();
        p.add(new Producto("a","b","c","d"));
        p.add(new Producto("a","b","c","d"));
        p.add(new Producto("a","b","c","d"));
        p.add(new Producto("a","b","a","b"));
        p.add(new Producto("a","b","c","d"));
        p.add(new Producto("a","b","c","d"));
        p.add(new Producto("a","b","c","d"));
        p.add(new Producto("a","b","c","d"));
        p.add(new Producto("a","b","c","d"));
        p.add(new Producto("a","b","c","d"));

        rvProductos = (RecyclerView) findViewById(R.id.listaRV);
        //tv = (TextView) findViewById(R.id.txtPrecio);

        rvProductos.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(p,this);
        rvProductos.setAdapter(adapter);


    }
    /*List<Producto> lista = (List<Producto>) msg.obj;
            adapter = new MyAdapter(this, lista);
            rvProductos.setAdapter(adapter);
            rvProductos.setLayoutManager(new LinearLayoutManager(this));*/

    @Override
    public boolean handleMessage(Message msg) {

        //lista = (RecyclerView) findViewById(R.id.listaRV);
        Log.d("TEST", "Presiono Mas");
        j = new ArrayList<>();
        j.add(new Producto("1","2","1","1"));
        j.add(new Producto("1","2","2","2"));
        j.add(new Producto("1","2","3","3"));
        j.add(new Producto("1","2","4","4"));
        j.add(new Producto("1","2","5","5"));
        j.add(new Producto("1","2","6","6"));

        adapter = new MyAdapter(j,this);
        rvProductos.setAdapter(adapter);
       // adapter.notifyDataSetChanged();
        rvProductos.setLayoutManager(new LinearLayoutManager(this));
        //adapter.notifyDataSetChanged();
        /*List<Producto> p = (List<Producto>) msg.obj;
        MyAdapter adapter = new MyAdapter(p);
        lista.setAdapter(adapter);
        //tv.setText(p.get(10).toString());*/

        return false;
    }

    public void Nose(int position, int id)
    {
        if (id==1) {
            int cantidad = Integer.parseInt( j.get(position).getCantidad()) + 1;
            String c = String.valueOf(cantidad);
            j.get(position).setCantidad(c);
            Log.d("sumo", "pos: "+ j.get(position).getId().toString()+"id:"+id +" cantidad: " + cantidad );
            adapter.notifyDataSetChanged();
        }
        if (id==2)
        {
            int cantidad = Integer.parseInt( j.get(position).getCantidad()) - 1;
           String c = String.valueOf(cantidad);
            j.get(position).setCantidad(c);
            Log.d("resto", "pos: "+ j.get(position).getId().toString()+"id:"+id +" cantidad: " + cantidad );
            adapter.notifyDataSetChanged();
        }
    }
}