
package sistema.pojos;

/**
 *
 * @author cristhian menjivar
 */
public class productosMasVendidos {
    
    private int idProductosMas;
    private int idProducto;
    private String año;
    private String mes;
    private String dia;
    private double cantidad;

    public productosMasVendidos() {
    }

    public productosMasVendidos(int idProductosMas, int idProducto, String año, String mes, String dia, double cantidad) {
        this.idProductosMas = idProductosMas;
        this.idProducto = idProducto;
        this.año = año;
        this.mes = mes;
        this.dia = dia;
        this.cantidad = cantidad;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdProductosMas() {
        return idProductosMas;
    }

    public void setIdProductosMas(int idProductosMas) {
        this.idProductosMas = idProductosMas;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
    
    
}
