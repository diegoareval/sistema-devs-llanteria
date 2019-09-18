package sistema.pojos;

/**
 *
 * @author DEVS
 */
public class Categorias {
    // atributos
    private int idCategoria;
    private String nombreCategoria;
    private String descCategoria;

    //constructor vacio
    public Categorias() {
    }

    //constructor lleno
    public Categorias(int idCategoria, String nombreCategoria, String descCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.descCategoria = descCategoria;
    }

    public String getDescCategoria() {
        return descCategoria;
    }

    public void setDescCategoria(String descCategoria) {
        this.descCategoria = descCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getnombreCategoria() {
        return nombreCategoria;
    }

    public void setnombreCategoria(String NombreCategoria) {
        this.nombreCategoria = NombreCategoria;
    }
    
    //metodo toString sobreescrito
    @Override
    public String toString(){
        return nombreCategoria;
    }
    
    
}
