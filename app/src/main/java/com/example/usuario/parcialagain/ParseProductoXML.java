package com.example.usuario.parcialagain;

import android.graphics.LightingColorFilter;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alumno on 11/10/2018.
 */

public class ParseProductoXML {




    public static List<Producto> Listar(String stringXML){
        List<Producto> productos = new ArrayList<>();
        Producto p = null;

        try {
            XmlPullParser xml = Xml.newPullParser();
            xml.setInput(new StringReader(stringXML));

            int event = xml.getEventType();
            while(event== XmlPullParser.END_DOCUMENT) {
                switch (event) {
                    case XmlPullParser.START_DOCUMENT:
                        break;

                    case XmlPullParser.START_TAG:
                        if ("productos".equals(xml.getName())){
                            p = new Producto();
                        }else if ("id".equals(xml.getName())) {
                            p.setId(xml.nextText());
                        }else if ("nombre".equals(xml.getName())) {
                            p.setNombre(xml.nextText());
                        }else if ("precio".equals(xml.getName())) {
                            p.setPrecio(xml.nextText());
                        }else if ("cantidad".equals(xml.getName())) {
                            p.setCantidad(xml.nextText());
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if("productos".equals(xml.getName()))
                        {
                            productos.add(p);
                        }
                        break;
                }
                event   = xml.next();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return productos;
    }


}