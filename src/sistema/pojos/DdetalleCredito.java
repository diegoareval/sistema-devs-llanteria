
package sistema.pojos;

import java.util.Date;

/**
 *
 * @author Diego Enrique Arevalo;
 */
public class DdetalleCredito {
    private int iddetallecredito;
    private int idcredito;
    private double pago;
    private Date fecha;

    public DdetalleCredito() {
    }

    public DdetalleCredito(int iddetallecredito, int idcredito, double pago, Date fecha) {
        this.iddetallecredito = iddetallecredito;
        this.idcredito = idcredito;
        this.pago = pago;
        this.fecha = fecha;
    }

    public int getIddetallecredito() {
        return iddetallecredito;
    }

    public void setIddetallecredito(int iddetallecredito) {
        this.iddetallecredito = iddetallecredito;
    }

    public int getIdcredito() {
        return idcredito;
    }

    public void setIdcredito(int idcredito) {
        this.idcredito = idcredito;
    }

    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
