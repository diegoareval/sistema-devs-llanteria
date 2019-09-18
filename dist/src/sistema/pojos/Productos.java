package sistema.pojos;

import sistema.datos.baseDatos;

/**
 *
 * @author cristian menjivar
 */
public class Productos {
    private int idProducto;
    private String nombreProduc;
    private String medidaProduc;
    private double precioCompra;
    private double precioSujerido;
    private int stocksProduc;
    private double existenciasProduc;
    private int averiado;
    private int idCategoria;
    private int idCalidad;
    private int idMarca;
    private int idProveedor;
    private String tipoRegistro; //producto o servicio
    
    //constructores:
    public Productos(){}

    public Productos(int idProducto, String nombreProduc, String medidaProduc, double precioCompra, double precioSujerido, int stocksProduc, double existenciasProduc, int averiado, int idCategoria, int idCalidad, int idMarca, int idProveedor) {
        this.idProducto = idProducto;
        this.nombreProduc = nombreProduc;
        this.medidaProduc = medidaProduc;
        this.precioCompra = precioCompra;
        this.precioSujerido = precioSujerido;
        this.stocksProduc = stocksProduc;
        this.existenciasProduc = existenciasProduc;
        this.averiado = averiado;
        this.idCategoria = idCategoria;
        this.idCalidad = idCalidad;
        this.idMarca = idMarca;
        this.idProveedor = idProveedor;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProduc() {
        return nombreProduc;
    }

    public void setNombreProduc(String nombreProduc) {
        this.nombreProduc = nombreProduc;
    }

    public String getMedidaProduc() {
        return medidaProduc;
    }

    public void setMedidaProduc(String medidaProduc) {
        this.medidaProduc = medidaProduc;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioSujerido() {
        return precioSujerido;
    }

    public void setPrecioSujerido(double precioSujerido) {
        this.precioSujerido = precioSujerido;
    }

    public int getStocksProduc() {
        return stocksProduc;
    }

    public void setStocksProduc(int stocksProduc) {
        this.stocksProduc = stocksProduc;
    }

    public double getExistenciasProduc() {
        return existenciasProduc;
    }

    public void setExistenciasProduc(double existenciasProduc) {
        this.existenciasProduc = existenciasProduc;
    }

    public int getAveriado() {
        return averiado;
    }

    public void setAveriado(int averiado) {
        this.averiado = averiado;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdCalidad() {
        return idCalidad;
    }

    public void setIdCalidad(int idCalidad) {
        this.idCalidad = idCalidad;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(String tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }
    
    
    private String nombreMarca;
    public void setNombreMarca(String nombreMarca){
        this.nombreMarca=nombreMarca;
    }
    
    public String getNombreMarca() {
        return nombreMarca;
    }
    
    //metodo sobreescrito
    @Override
    public String toString(){
        return nombreProduc +" "+ medidaProduc + " " + nombreMarca;
    }

    

    
    
      
}
