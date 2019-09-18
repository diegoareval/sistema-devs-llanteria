
package sistema.pojos;

/**
 *
 * @author cristhian menjivar
 */
public class Sucursales {
    
    private int idSucursal;
    private String direccion;
    private String telefono;
    
    // constructores
    public Sucursales(){}
     
    public Sucursales(int idSucursal, String direccion, String telefono) {
        this.idSucursal = idSucursal;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    //sobreescritura
    @Override
    public String toString(){
        return direccion;
    }
    
    
}
