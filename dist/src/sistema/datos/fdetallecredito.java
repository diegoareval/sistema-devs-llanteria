package sistema.datos;

import java.sql.Connection;
import sistema.pojos.DdetalleCredito;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego Arevalo Avelar
 */
public class fdetallecredito {

    Connection cn = Coneccion.getConnection();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID Detalle Credito", "Id Credito", "Pago", "Fecha"};

        String[] registro = new String[4];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select * from detalle_credito where idcredito = " + buscar + " order by idcredito desc";
        //sSQL="select * from usuarios";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("iddetalle_credito");
                registro[1] = rs.getString("idcredito");
                registro[2] = rs.getString("pago");
                registro[3] = rs.getString("fecha");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean editar(DdetalleCredito dts) {
        sSQL = "update detalle_credito set pago=?,fecha=?"
                + " where iddetalle_credito=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setDouble(1, dts.getPago());
            pst.setDate(2, (Date) dts.getFecha());
            pst.setInt(3, dts.getIddetallecredito());

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

    public boolean eliminar(DdetalleCredito dts) {
        sSQL = "delete from detalle_credito where iddetalle_credito=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIddetallecredito());

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

    public boolean insertar(DdetalleCredito dts) {
        sSQL = "insert into detalle_credito (idcredito,pago,fecha)"
                + "values (?,?,?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdcredito());
            pst.setDouble(2, dts.getPago());
            pst.setDate(3, (Date) dts.getFecha());

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
    
    public static void main(String[] args) {
        fdetallecredito deta = new fdetallecredito();
        deta.mostrar("5");
    }
}
