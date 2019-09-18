
package sistema.pojos;

import java.util.Date;

/**
 *
 * @author Diego Enrique Arevalo
 */
public class Dventas {
    private int id;
    private Date fecha;
    private Double monto;
    private String tipo_venta;
    private String tipo_pago;

    public Dventas() {
    }

    public Dventas(int id, Date fecha, Double monto, String tipo_venta, String tipo_pago) {
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
        this.tipo_venta = tipo_venta;
        this.tipo_pago = tipo_pago;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getTipo_venta() {
        return tipo_venta;
    }

    public void setTipo_venta(String tipo_venta) {
        this.tipo_venta = tipo_venta;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }
    
    
}
