package sistema.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import sistema.pojos.productosMasVendidos;

/**
 *
 * @author cristhian
 */
public class productosVendidos {

    //instancia de coneccion nula
    Connection cnn = null;

    Statement st = null;  // para ejecutar..
    ResultSet rs = null;    // resultado en arrays
    PreparedStatement ps = null; // para usar parametros

    // insertar productos vendidos
    public int insertarProductosMasVendido(productosMasVendidos product, String fecha) {
        int resultado = 0;

        cnn = Coneccion.getConnection();

        try {
            /**
             * Primero preguntaremos si en la tabla cantidad vendida existe un
             * registro del dia,mes,año de el producto "x" Si resulta que si
             * existe: Vamos a Actualizar las cantidades y se le sumara la
             * cantidad que se esta vendiendo Si resulta qye no existe: Vamos a
             * insertar una nueva fila con todos los atributos necesarios;
             * Tabla: idproducto, cantidad, dia,mes,año.
             *
             */


            System.out.println("fecha ; " + fecha);

            String sSQL = "";

            if (verificarExistencia(String.valueOf(product.getIdProducto()), fecha)) {
                System.out.println("Actualizar producto ; ");
                
               sSQL = "update masvendidos set cantidad=cantidad + ? where idproducto=? and fecha=?";
               PreparedStatement pst=cnn.prepareStatement(sSQL);
               pst.setDouble(1, product.getCantidad());
               pst.setInt(2, product.getIdProducto());
               pst.setString(3, fecha);
               
               return pst.executeUpdate();
           
            } else {
                System.out.println("insertar producto ; ");
                sSQL = "insert into masvendidos(cantidad,idproducto,fecha) value (?,?,?)";
               PreparedStatement pst=cnn.prepareStatement(sSQL);
               pst.setDouble(1, product.getCantidad());
               pst.setInt(2, product.getIdProducto());
               pst.setString(3, fecha);
               
               return pst.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }

    // VERIFICAR SI EL PRODUCTO YA ESTA REGISTRADO EN LA TABLA DEL AÑO MES Y DIA.
    public boolean verificarExistencia(String idProducto, String fecha) {

        try {
            cnn = Coneccion.getConnection();

            String sql = "SELECT * FROM masvendidos where idproducto='" + idProducto + "' "
                    + "and fecha='" + fecha + "'";

            st = cnn.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {
                // obtencion de cada campo de la tabla masvendidos
                int id = rs.getInt("idproducto");

                if (id == (Integer.parseInt(idProducto))) {
                    return true;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        //prueva
//        productosVendidos obj = new productosVendidos();
//        productosMasVendidos obj2 = new productosMasVendidos();
//        
//        obj2.setIdProducto(6);
//        obj2.setCantidad(6);
//        obj.insertarProductosMasVendido(obj2);
//        
//        obj2.setIdProducto(7);
//        obj2.setCantidad(7);
//        obj.insertarProductosMasVendido(obj2);
//        
//        obj2.setIdProducto(8);
//        obj2.setCantidad(8);
//        obj.insertarProductosMasVendido(obj2);

    }
}
