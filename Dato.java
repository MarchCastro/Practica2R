import java.io.Serializable;
import java.util.Calendar;

public class Dato implements Serializable{
    int id_producto;
    String nombre_producto;
    String marca;
    float precio;
    int existencias;
    String descripcion;
    String path_img;
    String path_img1;
    
    public Dato(int i, String n, String m, float p, int e, String d, String path, String path2){
        this.id_producto = i;
        this.nombre_producto = n;
        this.marca = m;
        this.precio = p;
        this.existencias = e;
        this.descripcion = d;
        this.path_img = path;
        this.path_img1 = path2;
    }

    int setIdProducto(int prod){
        return this.id_producto = prod;
    }
   
    String setNombreProducto(String nombre){
        return this.nombre_producto = nombre;
    }

    String setMarca(String mar){
        return this.marca = mar;
    }

    float setPrecio(float pre){
        return this.precio = pre;
    }

    int setExistencias(int ex){
        return this.existencias = ex;
    }

    String setDescripcion(String des){
        return this.descripcion = des;
    }

    String setImagenes(String path){
        return this.path_img = path;
    }

    String setImagenes(String path2){
        return this.path_img1 = path2;
    }
    
    
    // GETS
    int getIdProducto(){
        return this.id_producto;
    }

    String getNombreProducto(){
        return this.nombre_producto;
    }

    String getMarca(){
        return this.marca;
    }

    float getPrecio(){
        return this.precio;
    }

    int getExistencias(){
        return this.existencias;
    }

    String getDescripcion(){
        return this.descripcion;
    }

    String getPaths(){
        return this.path_img;
    }

    String getPath_1(){
        return this.path_img1;
    }
}