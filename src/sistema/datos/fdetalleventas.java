package sistema.datos;

import sistema.pojos.Ddetalle_ventas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego Enrique Arevalo
 */
public class fdetalleventas {

    private Coneccion mysql = new Coneccion();
    private Connection cn = mysql.getConnection();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID Detalle ", "ID Producto", "Id venta", "Cantidad", "Importe"};

        String[] registro = new String[5];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select * from detalle_ventas where idventa like '%" + buscar + "%' order by iddetalle_ventas desc";
      
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("iddetalle_ventas");
                registro[1] = rs.getString("idproducto");
                registro[2] = rs.getString("idventa");
                registro[3] = rs.getString("cantidad");
                registro[4] = rs.getString("importe");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean editar(Ddetalle_ventas dts) {
        sSQL = "update detalle_ventas set idproducto=?,idventa=?,cantidad=?,importe=?"
                + " where iddetalle_ventas=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdproducto());
            pst.setInt(2, dts.getIdventa());
            pst.setInt(3, dts.getCantidad());
            pst.setDouble(4, dts.getImporte());

            pst.setInt(5, dts.getIddetalle());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public void insertarDetalle(Ddetalle_ventas dts) {
        sSQL = "insert into detalle_ventas (idproducto,idventa,cantidad,importe)"
                + "values (?,?,?,?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdproducto());
            pst.setInt(2, dts.getIdventa());
            pst.setInt(3, dts.getCantidad());
            pst.setDouble(4, dts.getImporte());

            int n = pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);

        }
    }
    
    public static void main(String[] args) {
//        fdetalleventas obj = new fdetalleventas();
//        Ddetalle_ventas objdetalle = new Ddetalle_ventas();
//        objdetalle.setIdventa(8);
//        objdetalle.setIdproducto(1);
//        objdetalle.setCantidad(20);
//        objdetalle.setImporte(200);
//        
//        obj.insertarDetalle(objdetalle);
//        objdetalle.setIdproducto(2);
//        objdetalle.setCantidad(2);
//         obj.insertarDetalle(objdetalle);
//         objdetalle.setIdproducto(3);
//        objdetalle.setCantidad(10);
//          obj.insertarDetalle(objdetalle);
    }

}
