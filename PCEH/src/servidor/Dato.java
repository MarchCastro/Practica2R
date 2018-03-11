package servidor;

import java.io.Serializable;

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

    public int setIdProducto(int prod){
        return this.id_producto = prod;
    }
   
    public String setNombreProducto(String nombre){
        return this.nombre_producto = nombre;
    }

    public String setMarca(String mar){
        return this.marca = mar;
    }

    public float setPrecio(float pre){
        return this.precio = pre;
    }

    public int setExistencias(int ex){
        return this.existencias = ex;
    }

    public String setDescripcion(String des){
        return this.descripcion = des;
    }

    public String setPath_img(String path){
        return this.path_img = path;
    }

    public String setPath_img1(String path2){
        return this.path_img1 = path2;
    }
    
    
    // GETS
    public int getIdProducto(){
        return this.id_producto;
    }

    public String getNombreProducto(){
        return this.nombre_producto;
    }

    public String getMarca(){
        return this.marca;
    }

    public float getPrecio(){
        return this.precio;
    }

    public int getExistencias(){
        return this.existencias;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public String getPath_img(){
        return this.path_img;
    }

    public String getPath_img1(){
        return this.path_img1;
    }
}