import java.net.*;
import java.util.ArrayList;
import java.io.*;


import servidor.Dato;

public class Cliente{  

    public static void main(String [] args){
        try{
            String dst = "127.0.0.1";
            int pto = 9000;
            Socket cl = new Socket(dst,pto);
            System.out.println("Conexion establecida...creando objeto...");
            
            //Recibo numero de registros
            BufferedReader br2 = new BufferedReader(new InputStreamReader(cl.getInputStream()));
            String numero = br2.readLine();
            int numero1 = Integer.parseInt(numero);
            //System.out.println(" \nTamaño." + numero + numero1);
            int i = 0;
            System.out.println(" \nRecibiendo datos...");
            System.out.println("\n << Datos recibidos >>");
            while(i < numero1){
                ObjectInputStream ois = new ObjectInputStream(cl.getInputStream());
                Dato d1 = (Dato)ois.readObject();
                System.out.println(i + ". " + d1.getNombreProducto());
                i++;
            }

            String opcion1 = "4";
            PrintWriter x1 = new PrintWriter(new OutputStreamWriter(cl.getOutputStream()));
            x1.println(opcion1);
            x1.flush();

            //Envio al servidor el objeto
            String busca = "";
            BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("\n Archivo a modificar");
            busca = br3.readLine();
            //Mando nombre
            PrintWriter pw_cliente = new PrintWriter(new OutputStreamWriter(cl.getOutputStream()));
            pw_cliente.println(busca);
            pw_cliente.flush();

            //Envio al servidor el objeto
            ObjectInputStream ois = new ObjectInputStream(cl.getInputStream());
            Dato d1 = (Dato)ois.readObject();
            System.out.println("Contacto: " + d1.getNombre());
            
            //Pido nuevo dato
            int existe = 4;
            d1.setExistencias(existe);
            //Envio al servidor el objeto
            ObjectOutputStream oos = new ObjectOutputStream(cl.getOutputStream());
            oos.writeObject(d1);
            oos.flush();
                
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}