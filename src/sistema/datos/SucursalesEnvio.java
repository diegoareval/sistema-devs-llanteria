
package sistema.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistema.pojos.Envios;
import sistema.pojos.Sucursales;
import sistema.pojos.detalleEnvio;

/**
 *
 * @author cristhiam
 */

// esta clase tiene metodos de sucursales, envios a sucursales y detalle de envio
public class SucursalesEnvio {
    Connection cnn = null;
    Statement st = null;  // para ejecutar..
    ResultSet rs = null;    // resultado en arrays
    PreparedStatement ps = null; // para usar parametros
    
    // metodos a bases de datos
    // Insertar sucursales
    public int insertarSucursal(Sucursales sucursal) {
        int resultado = 0;

        cnn = Coneccion.getConnection();

        try {
            String sql = "INSERT INTO sucursales(direccionSucursal, telefonoSucursal)"
                    + " VALUES (?,?)";
            ps = cnn.prepareStatement(sql);

            ps.setString(1, sucursal.getDireccion());
            ps.setString(2, sucursal.getTelefono());
            resultado = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }
    
    //eliminar sucursal
    public int eliminarSucursal(Sucursales sucursal) {
        int resultado = 0;

        cnn = Coneccion.getConnection();

        try {
            String sql = "DELETE FROM sucursales where idSucursal=?";
            ps = cnn.prepareStatement(sql);

            ps.setInt(1, sucursal.getIdSucursal());

            resultado = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }
    
    
    // actualizar sucursal
    public int modificarCalidad(Sucursales sucursal) {
        int resultado = 0;

        cnn = Coneccion.getConnection();

        try {
            String sql = "UPDATE Sucursales SET direccionSucursal=?, telefonoSucursal=? where idSucursal=?";
            ps = cnn.prepareStatement(sql);

            ps.setString(1, sucursal.getDireccion());
            ps.setString(2, sucursal.getTelefono());
            ps.setInt(3, sucursal.getIdSucursal());

            resultado = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }
    
    
    // OBTENER sucursal
    public ArrayList<Sucursales> obtenerSucursal(String criterio) {
        // creacion de un array list lista de objetos sucursal
        ArrayList<Sucursales> lista = new ArrayList<Sucursales>();
        try {
            cnn = Coneccion.getConnection();

            String sql = "SELECT * FROM sucursales where direccionSucursal like '%"+criterio+"%' ";

            st = cnn.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {
                // obtencion de cada campo de la tabla producto
                int idSucursal = rs.getInt("idSucursal");
                String direccion = rs.getString("direccionSucursal");
                String telefono = rs.getString("telefonoSucursal");
               
                // creacion de objeto con sus atrinutos inicializados
                Sucursales obj= new Sucursales(idSucursal,direccion,telefono);
             
                // le añadimos el objeto calidad al array list de calidad
             lista.add(obj);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
    
    // Insertar sucursales
    public int insertarEnvioSucursal(Envios envio) {
        int ultimoEnvio = 0;

        cnn = Coneccion.getConnection();

        try {
            String sql = "INSERT INTO enviossucursale(fechaEnvio, idSucursal) "
                    + "VALUES (?,?)";
            ps = cnn.prepareStatement(sql);

            ps.setString(1, envio.getFechaEnvio());
            ps.setInt(2, envio.getIdSucursal());
            ps.executeUpdate();
            
             ps.close();
            ps = this.cnn.prepareStatement("Select max(idEnvio) as ultimo from enviossucursale");

            rs = ps.executeQuery(); // ejecuta ultimo

            while (rs.next()) {
                // si lo encuentra manda true
                String id = rs.getString("ultimo");
                ultimoEnvio = Integer.parseInt(id);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ultimoEnvio;
    }
    
    //eliminar sucursal
    public int eliminarEnvio(Envios envio) {
        int resultado = 0;

        cnn = Coneccion.getConnection();

        try {
            String sql = "DELETE FROM enviossucursale where idEnvio=?";
            ps = cnn.prepareStatement(sql);

            ps.setInt(1, envio.getIdEnvio());

            resultado = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }
    
    
    // actualizar calidad
    public int modificarEnvio(Envios envio) {
        int resultado = 0;

        cnn = Coneccion.getConnection();

        try {
            String sql = "UPDATE enviossucursale SET fechaEnvio=?, idSucursal=? where idEnvio=?";
            ps = cnn.prepareStatement(sql);

            ps.setString(1, envio.getFechaEnvio());
            ps.setInt(2, envio.getIdSucursal());
            ps.setInt(3, envio.getIdEnvio());

            resultado = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }
    
    
    // OBTENER envio
    public DefaultTableModel obtenerEnvio(String fecha){
       DefaultTableModel modelo;
       cnn = Coneccion.getConnection();

       String [] titulos = {"Código","Sucursal","Fecha de Envio","Teléfono"};
       
       String [] registro =new String [4];
       
       modelo = new DefaultTableModel(null,titulos);
       
       try {
            
            String sql = "SELECT * FROM sucursales,enviossucursale WHERE "
                    + "sucursales.idSucursal=enviossucursale.idSucursal "
                    + "and enviossucursale.fechaEnvio like '%"+fecha+"%' ";

            st = cnn.createStatement();
            rs = st.executeQuery(sql);
            
           while(rs.next()){
               registro [0]=rs.getString("idEnvio");
               registro [1]=rs.getString("direccionSucursal");
               registro [2]=rs.getString("fechaEnvio");
               registro [3]=rs.getString("telefonoSucursal");
              
              
               modelo.addRow(registro);
               
           }
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
    
   } 
    
    // Insertar sucursales
    public int insertarDetalleEnvio(detalleEnvio envio) {
        int resultado = 0;

        cnn = Coneccion.getConnection();

        try {
            String sql = "INSERT INTO detalleenviosucursal(idproducto, cantidadEnviada,idEnvio) "
                    + "VALUES (?,?,?)";
            ps = cnn.prepareStatement(sql);

            ps.setInt(1, envio.getIdProducto());
            ps.setDouble(2, envio.getCantidadEnviado());
            ps.setInt(3, envio.getIdEnvio());
            resultado = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }
    
    //eliminar sucursal
    public int eliminarEnvio(detalleEnvio envio) {
        int resultado = 0;

        cnn = Coneccion.getConnection();

        try {
            String sql = "DELETE FROM detalleenviosucursal where idDetalleEnvio=?";
            ps = cnn.prepareStatement(sql);

            ps.setInt(1, envio.getIdDetalleEnvio());

            resultado = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }
    
    
    // actualizar calidad
    public int modificarEnvio(detalleEnvio envio) {
        int resultado = 0;

        cnn = Coneccion.getConnection();

        try {
            String sql = "UPDATE detalleenviosucursal SET idProducto=?, cantidadEnviada=? where idDetalleEnvio=?";
            ps = cnn.prepareStatement(sql);

            ps.setInt(1, envio.getIdProducto());
            ps.setDouble(2, envio.getCantidadEnviado());
            ps.setInt(3, envio.getIdDetalleEnvio());

            resultado = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }
    
    
    // OBTENER detalle envio
    public DefaultTableModel obtenerDetalleEnvio(String criterio){
       DefaultTableModel modelo;
       cnn = Coneccion.getConnection();

       String [] titulos = {"ID detalle","ID envio","Productos","Cantidad Enviada"};
       
       String [] registro =new String [4];
       
       modelo = new DefaultTableModel(null,titulos);
        try {
            String sql = "SELECT * FROM enviossucursale,detalleenviosucursal,productos "
                    + "WHERE enviossucursale.idEnvio=detalleenviosucursal.idEnvio and "
                    + "detalleenviosucursal.idproducto=productos.idproducto and "
                    + "enviossucursale.idEnvio= '"+criterio+"' ";
                  
            st = cnn.createStatement();
            rs = st.executeQuery(sql);

             while(rs.next()){
               registro [0]=rs.getString("idDetalleEnvio");
               registro [1]=rs.getString("idEnvio");
               registro [2]=rs.getString("nombre");
               registro [3]=rs.getString("cantidadEnviada");
              
               modelo.addRow(registro);
           }
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return modelo;
    }
    
    
    public static void main(String[] args) {
        SucursalesEnvio obj = new SucursalesEnvio();
        obj.obtenerEnvio("2018-10-09");
    }
}
