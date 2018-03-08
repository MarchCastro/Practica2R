package servidor;

import java.io.Serializable;
import java.util.Calendar;

public class Dato implements Serializable{
    
    private int id_producto;
    private String nombre_producto;
    private String marca;
    private float precio;
    private int existencias;
    private String descripcion;
    private String path_img;
    
    
    public Dato(int i, String n, String m, float p, int e, String d, String path){
        this.id_producto = i;
        this.nombre_producto = n;
        this.marca = m;
        this.precio = p;
        this.existencias = e;
        this.descripcion = d;
        this.path_img = path;
    }

    /**
     * @return the id_producto
     */
    public int getId_producto() {
        return id_producto;
    }

    /**
     * @param id_producto the id_producto to set
     */
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    /**
     * @return the nombre_producto
     */
    public String getNombre_producto() {
        return nombre_producto;
    }

    /**
     * @param nombre_producto the nombre_producto to set
     */
    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * @return the existencias
     */
    public int getExistencias() {
        return existencias;
    }

    /**
     * @param existencias the existencias to set
     */
    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the path_img
     */
    public String getPath_img() {
        return path_img;
    }

    /**
     * @param path_img the path_img to set
     */
    public void setPath_img(String path_img) {
        this.path_img = path_img;
    }
}