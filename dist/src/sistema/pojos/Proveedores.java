package sistema.pojos;

/**
 *
 * @author DEVS
 */
public class Proveedores {
    
    private int idProveedor;
    private String nombreEmpresa;
    private String direccionEmpresa;
    private String telefonoEmpresa;
    
    public Proveedores(){}

    public Proveedores(int idProveedor, String nombreEmpresa, String direccionEmpresa, String telefonoEmpresa) {
        this.idProveedor = idProveedor;
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }
    
    //sibreescritura
    @Override
    public String toString(){
        return nombreEmpresa;
    }
            
}
