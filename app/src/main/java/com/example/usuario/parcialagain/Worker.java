package com.example.usuario.parcialagain;

import android.os.Handler;
import android.os.Message;
import android.text.BoringLayout;
import android.util.Log;

import java.net.URL;

/**
 * Created by alumno on 11/10/2018.
 */

public class Worker extends Thread {

    Handler h;
    URL url;
    Boolean bool;
    String conex;

    public Worker(Handler h, String url)
    {
        this.h =h;
        this.conex = url;


    }

    @Override
    public void run() {


        Log.d("Hola","Worker" + this.conex.toString());

        try {
           // Conexion c = new Conexion();
            HttpConection z = new HttpConection("GET");

            /*try {
            msg.arg1 = 1;
            msg.obj = XMLParser.ParsearProductos(new String(this.httpConnection.getBytesData(this.url)));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }*/
            Thread.sleep(4000);
            Message m = new Message();
            m.arg1=1;
           // m.obj = ParseProductoXML.Listar(z.getStringData(conex));
            h.sendMessage(m);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}