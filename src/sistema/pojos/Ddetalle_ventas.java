
package sistema.pojos;

/**
 *
 * @author Diego Arevalo Avelar
 */
public class Ddetalle_ventas {
    private int iddetalle;
    private int idproducto;
    private int idventa;
    private int cantidad;
    private double importe;

    public Ddetalle_ventas() {
    }

    public Ddetalle_ventas(int iddetalle, int idproducto, int idventa, int cantidad, double importe) {
        this.iddetalle = iddetalle;
        this.idproducto = idproducto;
        this.idventa = idventa;
        this.cantidad = cantidad;
        this.importe = importe;
    }

    public int getIddetalle() {
        return iddetalle;
    }

    public void setIddetalle(int iddetalle) {
        this.iddetalle = iddetalle;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
    
    
}
