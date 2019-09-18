package sistema.datos;

import sistema.pojos.Dventas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego Enrique Arevalo
 */
public class fventas {

    private Coneccion mysql = new Coneccion();
    private Connection cn = mysql.getConnection();
    ResultSet rs = null;    // resultado en arrays
    private String sSQL = "";
    public Integer totalregistros;
    DecimalFormat formato = new DecimalFormat("0.00"); // para que aparescan solo 2 decimales a los montos
    
    // calculo de total de ventas de una fecha
    public String calculoTotalVenta(String fecha){
        
         sSQL = "select SUM(Monto) as total from ventas where fecha= '" + fecha + "'";

        String totalVenta = "";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                totalVenta = rs.getString("total");
            }

            double total = Double.parseDouble(totalVenta);
            totalVenta= formato.format(total);
            
            return totalVenta;
        } catch (Exception e) {
            System.out.println("error al obtener el monto total");
            return "";
        }

    }
    
    // para total con 2 parametros
    public String calculoTotalVenta(String fecha1, String fecha2){
        
         sSQL = "select SUM(Monto) as total from ventas where fecha between '" + fecha1 + "' and '"+ fecha2 +"'";

        String totalVenta = "";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                totalVenta = rs.getString("total");
            }

            double total = Double.parseDouble(totalVenta);
            totalVenta= formato.format(total);
            return totalVenta;
        } catch (Exception e) {
            System.out.println("error al obtener el monto total");
            return "";
        }

    }

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Fecha", "Monto", "Tipo venta", "Tipo Pago"};

        String[] registro = new String[5];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select * from ventas where tipo_venta like '%" + buscar + "%' order by idventa desc";
        //sSQL="select * from usuarios";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idventa");
                registro[1] = rs.getString("fecha");
                registro[2] = rs.getString("Monto");
                registro[3] = rs.getString("tipo_venta");
                registro[4] = rs.getString("tipo_pago");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }
    public boolean editar (Dventas dts){
       sSQL="update ventas set fecha=?,monto=?,tipo_venta=?,tipo_pago=?"+
               " where idventa=?";
           
       
       try {
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setDate(1, (java.sql.Date) dts.getFecha());
           pst.setDouble(2, dts.getMonto());
           pst.setString(3, dts.getTipo_venta());
           pst.setString(4, dts.getTipo_pago());
        
           pst.setInt(5, dts.getId());
           
           int n=pst.executeUpdate();
           
           if (n!=0){
               return true;
           }
           else {
               return false;
           }
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   }
    public int insertarVenta(Dventas dts){
        int ultimaventa=0;
       sSQL="insert into ventas (fecha,monto,tipo_venta,tipo_pago)" +
               "values (?,?,?,?)";
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           String fecha = String.valueOf(dts.getFecha());
           pst.setString(1, fecha);
           pst.setDouble(2, dts.getMonto());
           pst.setString(3, dts.getTipo_venta());
           pst.setString(4, dts.getTipo_pago());
     
           pst.executeUpdate();
           
           pst.close();
            pst = this.cn.prepareStatement("Select max(idventa) as ultimo from ventas");

            rs = pst.executeQuery(); // ejecuta ultimo

            while (rs.next()) {
                // si lo encuentra manda true
                String id = rs.getString("ultimo");
                ultimaventa = Integer.parseInt(id);

            }
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
          
       }
       return ultimaventa;
        }
    public boolean eliminar (Dventas dts){
       sSQL="delete from ventas where idventa=?";
       
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           
           pst.setInt(1, dts.getId());
           
           int n=pst.executeUpdate();
           
           if (n!=0){
               return true;
           }
           else {
               return false;
           }
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   }
    

}
