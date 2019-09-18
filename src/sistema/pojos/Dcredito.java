
package sistema.pojos;

import java.util.Date;

/**
 *
 * @author Diego Arevalo Avelar
 */
public class Dcredito {
    private int idcredito;
    private int idcliente;
    private int idventa;
    private float monto;
    private Date fecha;

    public Dcredito() {
    }

    public Dcredito(int idcredito, int idcliente, int idventa, float monto, Date fecha) {
        this.idcredito = idcredito;
        this.idcliente = idcliente;
        this.idventa = idventa;
        this.monto = monto;
        this.fecha = fecha;
    }

    public int getIdcredito() {
        return idcredito;
    }

    public void setIdcredito(int idcredito) {
        this.idcredito = idcredito;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
