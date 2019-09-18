package sistema.pojos;

/**
 *
 * @author DEVS
 */
public class Marcas {
    
    private int idMarca;
    private String nombreMarca;
    
    public Marcas(){} // constructor vacio

    public Marcas(int idMarca, String nombreMarca) {
        this.idMarca = idMarca;
        this.nombreMarca = nombreMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }
    
    // sobreescritura
    @Override
    public String toString(){
        return nombreMarca;
    }
    
    
}
