package servidor;

import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class Servidor{
    static ArrayList<Dato> lista = new ArrayList<Dato>();
    
    private static void cargaDatos() throws Exception{
        File f = new File("inventario.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while((linea = br.readLine())!=null){
            String aux[] = linea.split("#");
            if(linea.length() > 1){
                Dato d = new Dato(Integer.parseInt(aux[0]), aux[1], aux[2], Float.parseFloat(aux[3]), Integer.parseInt(aux[4]), aux[5], aux[6], aux[7]);
                lista.add(d);
            }
        }
        fr.close();
        br.close();
        System.out.println("Datos del inventario cargados correctamente");
    }
    
    private static boolean guardaCambios(){
        try {
            FileWriter f = new FileWriter("inventario.txt");
            PrintWriter pw = new PrintWriter(f);
            for(int i = 0; i < lista.size(); i++){
                Dato d = (Dato) lista.get(i);
                pw.println(d.getIdProducto() + "#" + d.getNombreProducto() + "#" + d.getMarca() + "#" + d.getPrecio() + "#" + d.getExistencias() + "#" + d.getDescripcion() + "#" + d.getPath_img() + "#" + d.getPath_img1());
            }
            f.close();
            System.out.println("Inventario actualizado correctamente");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String [] args){
        try{
        int pto = 9000;
        ServerSocket s = new ServerSocket(pto);
        s.setReuseAddress(true);
        System.out.println("Servicio iniciado...preparado para recibir clientes");


        Socket cl = s.accept();
        System.out.println("Cliente conectado desde: " + cl.getInetAddress() + ":" + cl.getPort());
        cargaDatos();
        PrintWriter numero = new PrintWriter(new OutputStreamWriter(cl.getOutputStream()));
            numero.println(lista.size());
            numero.flush();
            //System.out.println("\n Tamaño: "+lista.size());
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
            
            guardaCambios();

            //Envia objeto con productos actualizados
            /*numero.println(lista.size());
            numero.flush();
            System.out.println("\n Tamaño: "+lista.size());

            for(int i = 0; i < lista.size(); i++){
                ObjectOutputStream oos = new ObjectOutputStream(cl.getOutputStream());
                oos.writeObject(lista.get(i));
                //System.out.println("\n Envio: "+lista.get(i).getNombre());
                oos.flush();   
            } */
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}