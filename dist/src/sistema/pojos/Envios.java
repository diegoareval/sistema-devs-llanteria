
package sistema.pojos;

/**
 *
 * @author cristhian menjivar
 */
public class Envios {
    
    private int idEnvio;
    private int idSucursal;
    private String fechaEnvio;

    public Envios() {
    }

    public Envios(int idEnvio, int idSucursal, String fechaEnvio) {
        this.idEnvio = idEnvio;
        this.idSucursal = idSucursal;
        this.fechaEnvio = fechaEnvio;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public int getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(int idEnvio) {
        this.idEnvio = idEnvio;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }
    
    
}
