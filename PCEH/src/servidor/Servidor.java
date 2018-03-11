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

        Dato p1 = new Dato(12345,"Blusa rayada","Lacoste",199f,14,"Camisa larga en tejido de algodón. Modelo con cuello, botones delante y en los puños.", "Imagenes/blusa1.png","Imagenes/blusa2.png");
        Dato p2 = new Dato(67891,"Camisa estampada de viscosa","Gucci",299f,7,"Camisa de manga larga en tejido suave de viscosa con estampado, cuello y botones delante.", "Imagenes/blusa3.png", "Imagenes/blusa4.png");
        Dato p3 = new Dato(13579,"Pantalón estampado de sarga","Adidas",449f,4,"Pantalón de cinco bolsillos en sarga elástica con estampado, cintura estándar y cierre.", "Imagenes/pantalon5.png", "Imagenes/pantalon6.png");
        Dato p4 = new Dato(24680,"Zapatillas deportivas","Nike",449f,21,"Zapatillas deportivas con cordones, borde y lengüeta ligeramente acolchados. Forro y plantillas de tela. Suelas de goma.","Imagenes/tenis7.png","Imagenes/tenis8.png" );
        Dato p5 = new Dato(12457,"Zapatos deportivas sin cierre","Adidas",339f,8,"Zapatillas deportivas sin cierre. Forro y plantillas de tela. Suelas de goma.", "Imagenes/tenis9.png","Imagenes/tenis10.png");
        Dato p6 = new Dato(23456,"Camiseta de manga larga ","Vans",349f,3,"Jersey en punto fino y suave con mangas largas, puños y bajo en punto de canalé. ", "Imagenes/hombre1.png","Imagenes/hombre2.png");
        Dato p7 = new Dato(93847,"Slim Jeans","Converse",599f,5,"Vaqueros de cinco bolsillos en denim elástico y lavado. Modelo de talle bajo con cierre de botón y perneras ajustadas. ", "Imagenes/hombre3.png","Imagenes/hombre4.png");
        Dato p8 = new Dato(10927,"Mocasines ","Lacoste",499f,2,"Mocasines en ante sintético con cordones decorativos. Forro y plantillas de tela, y suelas de goma. ", "Imagenes/zapato1.png","Imagenes/zapato2.png");
        Dato p9 = new Dato(35943,"Botas Chelsea ","Michael Kors",799f,7,"Botas Chelsea en ante sintético con costura decorativa alrededor de la suela elástico en los laterales y trabilla detrás. ", "Imagenes/botas1.png","Imagenes/botas2.png");
        Dato p10 = new Dato(20791,"Joggers de punto","Adidas",499f,8,"Joggers en punto grueso de mezcla de algodón con cintura elástica y cordón de ajuste. ", "Imagenes/pants1.png","Imagenes/pants2.png");
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
            //Envia objeto con productos
            for(int i = 0; i < lista.size(); i++){
                ObjectOutputStream oos = new ObjectOutputStream(cl.getOutputStream());
                oos.writeObject(lista.get(i));
                //System.out.println("\n Envio: "+lista.get(i).getNombre());
                oos.flush();   
            } 

            //Recibo numero de productos y leo cada uno de los objetos
            String id_prod_compras = "";
            String opc = "";
            BufferedReader br2 = new BufferedReader(new InputStreamReader(cl.getInputStream()));
            opc = br2.readLine();
            System.out.println(" Recibiré: " + opc + " productos");
            int numero_acv = Integer.parseInt(opc);
            
            for(int i = 0; i < numero_acv ; i++){
                id_prod_compras = br2.readLine();
                System.out.println(" Recibo: " +  id_prod_compras);
                //Separo en 2 el string que recibi
                String[] parts = id_prod_compras.split(",", 2);
                String part1 = parts[0]; 
                int id = Integer.parseInt(part1);
                String part2 = parts[1];
                int compra = Integer.parseInt(part2);
                System.out.println("Articulo " +  id + " compra "+compra);
                //Busco el id
                for(int j = 0; j < lista.size(); j++ ){
                    if(lista.get(j).getIdProducto() == id){
                        System.out.println("Articulo " +  lista.get(j).getExistencias());
                        int existe_nuevo = lista.get(j).getExistencias() - compra;
                        lista.get(j).setExistencias(existe_nuevo);
                        System.out.println("Articulo " +  lista.get(j).getExistencias());
                    }
                }
            }

            //Envia objeto con productos actualizados
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