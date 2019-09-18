/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.pojos;

/**
 *
 * @author Diego Enrique Arevalo
 */
public class Dinventario {
    private int id;
    private String nombre;
    private int stock;
    private Double preciocompra;
    private Double precioreal;

    public Dinventario() {
    }

    public Dinventario(int id, String nombre, int stock, Double preciocompra, Double precioreal) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.preciocompra = preciocompra;
        this.precioreal = precioreal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Double getPreciocompra() {
        return preciocompra;
    }

    public void setPreciocompra(Double preciocompra) {
        this.preciocompra = preciocompra;
    }

    public Double getPrecioreal() {
        return precioreal;
    }

    public void setPrecioreal(Double precioreal) {
        this.precioreal = precioreal;
    }
    
}
