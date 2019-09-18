package sistema.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import sistema.pojos.Calidad;
import sistema.pojos.Categorias;
import sistema.pojos.Dusuario;
import sistema.pojos.Marcas;
import sistema.pojos.Productos;
import sistema.pojos.Proveedores;

/**
 *
 * @author cristhian menjivar
 */
public class baseDatos {
    //instancia de coneccion nula

    Connection cnn = null;
    Statement st = null;  // para ejecutar..
    ResultSet rs = null;    // resultado en arrays
    PreparedStatement ps = null; // para usar parametros
    Dusuario user = new Dusuario(); // objeto usuario
    
    
     // funcion retorna true cuando encuentra un usuario y contraseña en base de datos..
    public boolean verificarUsuario(String usuario, String contraseña) throws SQLException {
        cnn = Coneccion.getConnection();
        

        // preparo la variable Statement contendra la conexion
        Statement st = cnn.createStatement();
        // resultado igual vacio
        ResultSet rs = null;
        
        // consulta general
        String consulta = "Select * from usuarios";

        
        // ejecuto la consulta
        rs = st.executeQuery(consulta);

        // recorro el resultado 
        while (rs.next()) {
            // si lo encuentra manda el tipo
            if (usuario.equals(rs.getString("usuario")) && contraseña.equals(rs.getString("contraseña"))) {
                user.setId(Integer.parseInt(rs.getString("idusuario")));
                user.setUsuario(rs.getString("usuario"));
                user.setContra(rs.getString("contraseña"));
                user.setTipo(rs.getString("tipo_usuario"));
                
                return true;
            }

        }
        return false;
    }

    // insertar productos
    public int insertarProductos(Productos product) {
        int resultado = 0;

        cnn = Coneccion.getConnection();

        try {
            
            String sql = "INSERT INTO productos(medida, nombre, precio_compra, precio_sugerido, stock,"
                    + " inventario, averiado, idmarca, idproveedor, idcategoria, idcalidad,tipoRegistro) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = cnn.prepareStatement(sql);

            ps.setString(1, product.getMedidaProduc());
            ps.setString(2, product.getNombreProduc());
            ps.setDouble(3, product.getPrecioCompra());
            ps.setDouble(4, product.getPrecioSujerido());
            ps.setInt(5, product.getStocksProduc());
            ps.setDouble(6, product.getExistenciasProduc());
            ps.setInt(7, product.getAveriado());
            ps.setInt(8, product.getIdMarca());
            ps.setInt(9, product.getIdProveedor());
            ps.setInt(10, product.getIdCategoria());
            ps.setInt(11, product.getIdCalidad());
            ps.setString(12, product.getTipoRegistro());

            resultado = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }
    
    
    // actualizar productos
    public int actualizarProductos(Productos product) {
        int resultado = 0;

        cnn = Coneccion.getConnection();

        try {
            String sql = "Update productos SET medida=?,precio_compra=?, precio_sugerido=?, stock=?,"
                    + " averiado=?, idmarca=?, idproveedor=?, idcategoria=?, idcalidad=?, nombre=? where idproducto=?";
            ps = cnn.prepareStatement(sql);

            ps.setString(1, product.getMedidaProduc());
            ps.setDouble(2, product.getPrecioCompra());
            ps.setDouble(3, product.getPrecioSujerido());
            ps.setInt(4, product.getStocksProduc());
            ps.setInt(5, product.getAveriado());
            ps.setInt(6, product.getIdMarca());
            ps.setInt(7, product.getIdProveedor());
            ps.setInt(8, product.getIdCategoria());
            ps.setInt(9, product.getIdCalidad());
            ps.setString(10, product.getNombreProduc());
            ps.setInt(11, product.getIdProducto());

            resultado = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }
    
    
    //eliminar productos
    public int eliminarProductos(Productos product) {
        int resultado = 0;

        cnn = Coneccion.getConnection();

        try {
            String sql = "Delete from productos where idproducto=?";
            ps = cnn.prepareStatement(sql);

            ps.setInt(1, product.getIdProducto());

            resultado = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }
    
    // obtener todos los productos
    public ArrayList<Productos> obtenerProductosCriterio(String criterio) {
        // creacion de un array list lista de objetos productos
        ArrayList<Productos> listaProductos = new ArrayList<Productos>();
        try {
            cnn = Coneccion.getConnection();

            String sql = "SELECT * FROM productos INNER JOIN marca ON productos.idmarca=marca.idmarca  WHERE productos.idproducto like '" + criterio + "%' or productos.nombre like '%" + criterio + "%' order by productos.nombre";

            st = cnn.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {
                // obtencion de cada campo de la tabla producto
                int idProducto = rs.getInt("idproducto");
                String nombre = rs.getString("nombre");
                String medida = rs.getString("medida");
                double precioCompra = rs.getDouble("precio_compra");
                double precioSujerido = rs.getDouble("precio_sugerido");
                int stock = rs.getInt("stock");
                int existencias = rs.getInt("inventario");
                int averiado = rs.getInt("averiado");
                int idMarca = rs.getInt("idmarca");
                int idProveedor = rs.getInt("idproveedor");
                int idCategoria = rs.getInt("idcategoria");
                int idCalidad = rs.getInt("idcalidad");
                String tipoRegistro = rs.getString("tipoRegistro");
                String nombreMarca = rs.getString("marca");
                
                if (idMarca==1){
                    nombreMarca="-";
                }

                // creacion de objeto con sus atrinutos inicializados
             Productos objProv = new Productos(idProducto, nombre, medida, precioCompra, precioSujerido, stock, existencias, averiado, idCategoria, idCalidad, idMarca, idProveedor);
             objProv.setTipoRegistro(tipoRegistro);
             
             objProv.setNombreMarca(nombreMarca);// para presentarla
                // le añadimos el objeto producto al array list de productos
             listaProductos.add(objProv);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaProductos;
    }
    
    // Insertar calidad
    public int insertarCalidad(Calidad calidad) {
        int resultado = 0;

        cnn = Coneccion.getConnection();

        try {
            String sql = "INSERT INTO calidad(calidad) VALUES (?)";
            ps = cnn.prepareStatement(sql);

            ps.setString(1, calidad.getNombreCalidad());

            resultado = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }
    
    //eliminar calidad
    public int eliminarCalidad(Calidad calidad) {
        int resultado = 0;

        cnn = Coneccion.getConnection();

        try {
            String sql = "DELETE FROM calidad where idcalidad=? and idcalidad<>1";
            ps = cnn.prepareStatement(sql);

            ps.setInt(1, calidad.getIdCalidad());

            resultado = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }
    
    
    // actualizar calidad
    public int modificarCalidad(Calidad calidad) {
        int resultado = 0;

        cnn = Coneccion.getConnection();

        try {
            String sql = "UPDATE calidad SET calidad=? where idcalidad=?";
            ps = cnn.prepareStatement(sql);

            ps.setString(1, calidad.getNombreCalidad());
            ps.setInt(2, calidad.getIdCalidad());

            resultado = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }
    
    
    // OBTENER CALIDAD
    public ArrayList<Calidad> obtenerCalidad(String criterio) {
        // creacion de un array list lista de objetos calidad
        ArrayList<Calidad> listaCalidad = new ArrayList<Calidad>();
        try {
            cnn = Coneccion.getConnection();

            String sql = "SELECT * FROM calidad where calidad like '%"+criterio+"%'";

            st = cnn.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {
                // obtencion de cada campo de la tabla producto
                int idCalidad = rs.getInt("idcalidad");
                String nombreCalidad = rs.getString("calidad");
               
                // creacion de objeto con sus atrinutos inicializados
                Calidad cali = new Calidad(idCalidad,nombreCalidad);
             
                // le añadimos el objeto calidad al array list de calidad
             listaCalidad.add(cali);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaCalidad;
    }
    
    /**
     *  procesos de la clase categoria
     *
     **/
    
    // Insertar calidad
    public int insertarCategoria(Categorias cat) {
        int resultado = 0;

        cnn = Coneccion.getConnection();

        try {
            String sql = "INSERT INTO categorias(Nom_categoria,descripcion) VALUES (?,?)";
            ps = cnn.prepareStatement(sql);

            ps.setString(1, cat.getnombreCategoria());
            ps.setString(2,cat.getDescCategoria());

            resultado = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }
    
    //eliminar categoria
    public int eliminarCategoria(Categorias cat) {
        int resultado = 0;

        cnn = Coneccion.getConnection();

        try {
            String sql = "DELETE FROM categorias where idcategoria=? and idcategoria<>1";
            ps = cnn.prepareStatement(sql);

            ps.setInt(1, cat.getIdCategoria());

            resultado = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }
    
    
    // actualizar categoria
    public int modificarCategoria(Categorias cat) {
        int resultado = 0;

        cnn = Coneccion.getConnection();

        try {
            String sql = "UPDATE categorias SET Nom_categoria=?, descripcion=? where idcategoria=?";
            ps = cnn.prepareStatement(sql);

            ps.setString(1, cat.getnombreCategoria());
             ps.setString(2, cat.getDescCategoria());
            ps.setInt(3, cat.getIdCategoria());

            resultado = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }
    
    
    // OBTENER CALIDAD
    public ArrayList<Categorias> obtenerCategorias(String criterio) {
        // creacion de un array list lista de objetos categorias
        ArrayList<Categorias> listaCategoria = new ArrayList<Categorias>();
        try {
            cnn = Coneccion.getConnection();

            String sql = "SELECT * FROM categorias where Nom_categoria like '%"+criterio+"%'";

            st = cnn.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {
                // obtencion de cada campo de la tabla categoria
                int idcategoria = rs.getInt("idcategoria");
                String nombCategoria = rs.getString("Nom_categoria");
                String descripcionCat = rs.getString("descripcion");
               
                // creacion de objeto con sus atrinutos inicializados
                Categorias cat = new Categorias(idcategoria,nombCategoria,descripcionCat);
             
                // le añadimos el objeto categoria al array list de categoria
             listaCategoria.add(cat);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaCategoria;
    }
    
    /**
     *  procesos de la clase marcas
     *
     **/
    
    // Insertar marca
    public int insertarMarcas(Marcas mar) {
        int resultado = 0;

        cnn = Coneccion.getConnection();

        try {
            String sql = "INSERT INTO marca(marca) VALUES (?)";
            ps = cnn.prepareStatement(sql);

            ps.setString(1, mar.getNombreMarca());

            resultado = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }
    
    //eliminar marca
    public int eliminarMarca(Marcas mar) {
        int resultado = 0;

        cnn = Coneccion.getConnection();

        try {
            String sql = "DELETE FROM marca where idmarca=? and idmarca<>1";
            ps = cnn.prepareStatement(sql);

            ps.setInt(1, mar.getIdMarca());

            resultado = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }
    
    
    // actualizar marca
    public int modificarMarca(Marcas mar) {
        int resultado = 0;

        cnn = Coneccion.getConnection();

        try {
            String sql = "UPDATE marca SET marca=? where idmarca=?";
            ps = cnn.prepareStatement(sql);

            ps.setString(1, mar.getNombreMarca());
            ps.setInt(2, mar.getIdMarca());

            resultado = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }
    
    
    // OBTENER MARCA
    public ArrayList<Marcas> obtenerMarca(String criterio) {
        // creacion de un array list lista de objetos categorias
        ArrayList<Marcas> listamarca = new ArrayList<Marcas>();
        try {
            cnn = Coneccion.getConnection();

            String sql = "SELECT * FROM marca where marca like '%"+criterio+"%'";

            st = cnn.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {
                // obtencion de cada campo de la tabla marca
                int idmarca = rs.getInt("idmarca");
                String nombmarca = rs.getString("marca");
               
                // creacion de objeto con sus atrinutos inicializados
                Marcas marca = new Marcas(idmarca,nombmarca);
             
                // le añadimos el objeto categoria al array list de categoria
             listamarca.add(marca);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listamarca;
    }
    
    
    public String obtenerNombreMarca(String criterio) {
        
        cnn = Coneccion.getConnection();
        String nombmarca = "";
        try {

            String sql = "SELECT * FROM marca where marca= " + criterio + "";

            st = cnn.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {
                // obtencion de cada campo de la tabla marca
                nombmarca = rs.getString("marca");
                return nombmarca;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "";
    }
    /**
     *  procesos de la clase proveedores
     *
     **/
    
    // Insertar proveedor
    public int insertarProveedor(Proveedores prov) {
        int resultado = 0;

        cnn = Coneccion.getConnection();

        try {
            String sql = "INSERT INTO proveedor(nombre_empresa,direccion_empresa,telefono) VALUES (?,?,?)";
            ps = cnn.prepareStatement(sql);

            ps.setString(1, prov.getNombreEmpresa());
            ps.setString(2, prov.getDireccionEmpresa());
            ps.setString(3, prov.getTelefonoEmpresa());

            resultado = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }
    
    //eliminar proveedor
    public int eliminarProveedor(Proveedores prov) {
        int resultado = 0;

        cnn = Coneccion.getConnection();

        try {
            String sql = "DELETE FROM proveedor where idproveedor=? and idproveedor<>1";
            ps = cnn.prepareStatement(sql);

            ps.setInt(1, prov.getIdProveedor());

            resultado = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }
    
    
    // actualizar proveedor
    public int modificarProveedor(Proveedores prov) {
        int resultado = 0;

        cnn = Coneccion.getConnection();

        try {
            String sql = "UPDATE proveedor SET nombre_empresa=?,direccion_empresa=?,telefono=? where idproveedor=?";
            ps = cnn.prepareStatement(sql);

            ps.setString(1, prov.getNombreEmpresa());
            ps.setString(2, prov.getDireccionEmpresa());
            ps.setString(3, prov.getTelefonoEmpresa());
            ps.setInt(4, prov.getIdProveedor());

            resultado = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }
    
    
    // OBTENER PROVEEDORES
    public ArrayList<Proveedores> obtenerProveedores(String criterio) {
        // creacion de un array list lista de objetos categorias
        ArrayList<Proveedores> listaProveedor = new ArrayList<Proveedores>();
        try {
            cnn = Coneccion.getConnection();

            String sql = "SELECT * FROM proveedor where nombre_empresa like '%"+criterio+"%'";

            st = cnn.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {
                // obtencion de cada campo de la tabla marca
                int idproveedor = rs.getInt("idproveedor");
                String nombre = rs.getString("nombre_empresa");
                String direccion = rs.getString("direccion_empresa");
                String telefono = rs.getString("telefono");
               
                // creacion de objeto con sus atrinutos inicializados
                Proveedores prov = new Proveedores(idproveedor,nombre,direccion,telefono);
             
                // le añadimos el objeto categoria al array list de categoria
             listaProveedor.add(prov);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaProveedor;
    }
   
}
