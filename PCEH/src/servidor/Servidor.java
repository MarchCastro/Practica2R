package servidor;

import java.net.*;
import java.util.ArrayList;
import java.io.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Servidor{
    static ArrayList<Dato> lista = new ArrayList<Dato>();

    public static void main(String [] args){
        try{
        int pto = 9000;
        ServerSocket s = new ServerSocket(pto);
        s.setReuseAddress(true);
        System.out.println("Servicio iniciado...preparado para recibir cliente");

        Dato p1 = new Dato(12345,"Blusa blanca","Lacoste",756.23f,14,"Blusa bonita", "---");
        Dato p2 = new Dato(67891,"Cinturón café","Gucci",490.34f,7,"Cinturón de piel café con hebilla dorada", "---");
        Dato p3 = new Dato(13579,"Tenis blancos","Adidas",1320.32f,4,"Tenis blancos con pequeñas franjas negras a los lados", "---");
        Dato p4 = new Dato(24680,"Calcetines","Nike",203.45f,21,"Calcetines de colores con franjas negras", "---");
        Dato p5 = new Dato(12457,"Zapatos dorados","Gucci",789.23f,8,"Flats dorados con moño negro al frente", "---");
        //Creo ArrayList de personas
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);

        Socket cl = s.accept();
        System.out.println("Cliente conectado desde: " + cl.getInetAddress() + ":" + cl.getPort());
        
        PrintWriter numero = new PrintWriter(new OutputStreamWriter(cl.getOutputStream()));
            numero.println(lista.size());
            numero.flush();
            System.out.println("\n Tamaño: "+lista.size());
            for(int i = 0; i < lista.size(); i++){
                ObjectOutputStream oos = new ObjectOutputStream(cl.getOutputStream());
                oos.writeObject(lista.get(i));
                //System.out.println("\n Envio: "+lista.get(i).getNombre());
                oos.flush();   
            } 
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}