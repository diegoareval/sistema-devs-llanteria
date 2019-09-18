
package sistema.pojos;

/**
 *
 * @author cristhian menjivar
 */
public class detalleEnvio {
    
    private int idDetalleEnvio;
    private int idProducto;
    private double cantidadEnviado;
    private int idEnvio;

    public detalleEnvio() {
    }

    public detalleEnvio(int idDetalleEnvio, int idProducto, double cantidadEnviado, int idEnvio) {
        this.idDetalleEnvio = idDetalleEnvio;
        this.idProducto = idProducto;
        this.cantidadEnviado = cantidadEnviado;
        this.idEnvio = idEnvio;
    }

    public double getCantidadEnviado() {
        return cantidadEnviado;
    }

    public void setCantidadEnviado(double cantidadEnviado) {
        this.cantidadEnviado = cantidadEnviado;
    }

    public int getIdDetalleEnvio() {
        return idDetalleEnvio;
    }

    public void setIdDetalleEnvio(int idDetalleEnvio) {
        this.idDetalleEnvio = idDetalleEnvio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(int idEnvio) {
        this.idEnvio = idEnvio;
    }
    
    
}
