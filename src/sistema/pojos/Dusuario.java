package sistema.pojos;

/**
 *
 * @author Diego Arevalo Avelar
 */
public class Dusuario {

    private static int id;
    private static String usuario;
    private static String contra;
    private static String tipo;

    public Dusuario() {
    }

    public Dusuario(int id, String usuario, String contra, String tipo) {
        this.id = id;
        this.usuario = usuario;
        this.contra = contra;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
