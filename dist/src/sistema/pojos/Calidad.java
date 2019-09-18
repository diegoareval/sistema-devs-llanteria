package sistema.pojos;

/**
 *
 * @author DEVS
 */
public class Calidad {
    
    private int idCalidad;
    private String nombreCalidad;
    
    public Calidad(){} // constructor vacio

    public Calidad(int idCalidad, String nombreCalidad) {
        this.idCalidad = idCalidad;
        this.nombreCalidad = nombreCalidad;
    }

    public String getNombreCalidad() {
        return nombreCalidad;
    }

    public void setNombreCalidad(String nombreCalidad) {
        this.nombreCalidad = nombreCalidad;
    }

    public int getIdCalidad() {
        return idCalidad;
    }

    public void setIdCalidad(int idCalidad) {
        this.idCalidad = idCalidad;
    }
    
    //sobreescritura
    @Override
    public String toString(){
        return nombreCalidad;
    }
    
    
}
