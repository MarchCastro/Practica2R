import java.net.*;
import java.util.ArrayList;
import java.io.*;

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
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}