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

        Dato p1 = new Dato(12345,"Blusa rayada","Lacoste",199f,14,"Camisa larga en tejido de algodón. Modelo con cuello, botones delante y en los puños, canesú con pliegue en la espalda y bajo redondeado.", "Imagenes/blusa1.png","Imagenes/blusa2.png");
        Dato p2 = new Dato(67891,"Camisa estampada de viscosa","Gucci",299f,7,"Camisa de manga larga en tejido suave de viscosa con estampado, cuello y botones delante.", "Imagenes/blusa3.png", "Imagenes/blusa4.png");
        Dato p3 = new Dato(13579,"Pantalón estampado de sarga","Adidas",449f,4,"Pantalón de cinco bolsillos en sarga elástica con estampado, cintura estándar, perneras ajustadas y cierre de cremallera con botón.", "Imagenes/pantalon5.png", "Imagenes/pantalon6.png");
        Dato p4 = new Dato(24680,"Zapatillas deportivas","Nike",449f,21,"Zapatillas deportivas con cordones, borde y lengüeta ligeramente acolchados. Forro y plantillas de tela. Suelas de goma.","Imagenes/tenis7.png","Imagenes/tenis8.png" );
        Dato p5 = new Dato(12457,"Zapatos deportivas sin cierre","Adidas",339f,8,"Zapatillas deportivas sin cierre. Forro y plantillas de tela. Suelas de goma.", "Imagenes/tenis9.png","Imagenes/tenis10.png");
        Dato p6 = new Dato(23456,"Camiseta de manga larga ","Vans",349f,3,"Jersey en punto fino y suave con mangas largas, un bolsillo superior sin cierre y cuello, puños y bajo en punto de canalé. ", "Imagenes/hombre1.png","Imagenes/hombre2.png");
        Dato p7 = new Dato(93847,"Slim Jeans","Converse",599f,5,"Vaqueros de cinco bolsillos en denim elástico y lavado. Modelo de talle bajo con cierre de botón y perneras ajustadas. ", "Imagenes/hombre3.png","Imagenes/hombre4.png");
        Dato p8 = new Dato(10927,"Mocasines ","Lacoste",499f,2,"Mocasines en ante sintético con cordones decorativos. Forro y plantillas de tela, y suelas de goma. ", "Imagenes/zapato1.png","Imagenes/zapato2.png");
        Dato p9 = new Dato(35943,"Botas Chelsea ","Michael Kors",799f,7,"Botas Chelsea en ante sintético con costura decorativa alrededor de la suela elástico en los laterales y trabilla detrás. Forro y plantillas de lona. Suela de goma. Tacón aprox. de 3 cm. ", "Imagenes/botas1.png","Imagenes/botas2.png");
        Dato p10 = new Dato(20791,"Joggers de punto","Adidas",499f,8,"Joggers en punto grueso de mezcla de algodón con cintura elástica y cordón de ajuste. Bolsillos al bies con cremallera, perneras pitillo con costuras en las rodillas, secciones de ventilación de malla en la entrepierna y bajos anchos en punto elástico. ", "Imagenes/pants1.png","Imagenes/pants2.png");
        //Creo ArrayList de personas
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        lista.add(p6);
        lista.add(p7);
        lista.add(p8);
        lista.add(p9);
        lista.add(p10);


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