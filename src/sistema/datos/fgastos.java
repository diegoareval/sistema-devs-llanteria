
package sistema.datos;
import sistema.pojos.Dgastos;
import java.sql.Connection;
import java.sql.Date;
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
public class fgastos {
    Connection cn = Coneccion.getConnection();
    private String sSQL = "";  
    public Integer totalregistros;
     DecimalFormat formato = new DecimalFormat("0.00"); // para que aparescan solo 2 decimales a los montos
    
    // calcula total de gastos al dia
    public String calculoTotalGasto(String fecha){
        
         sSQL = "select SUM(total) as total from gastos where fecha= '" + fecha + "'";

        String totalGasto = "";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                totalGasto = rs.getString("total");

            }

            double total = Double.parseDouble(totalGasto);
            totalGasto= formato.format(total);
            return totalGasto;
            
        } catch (Exception e) {
            System.out.println("error al obtener el monto total de gasto");
            return "";
        }

    }
    
    // calcula el total de gastos estre 2 fechas
     public String calculoTotalGastoRango(String fecha1, String fecha2){
        
         sSQL = "select SUM(total) as total from gastos where fecha between '" + fecha1 + "' and '" + fecha2 + "'";

        String totalGasto = "";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                totalGasto = rs.getString("total");

            }
            double total = Double.parseDouble(totalGasto);
            totalGasto= formato.format(total);
            return totalGasto;
            
        } catch (Exception e) {
            System.out.println("error al obtener el monto total de gasto entre fechas");
            return "";
        }

   }
    
    //Metodo que permite mostrar los datos en la tabla
     public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"ID Gastos","Tipo Gastos","Total Gastos","Fecha"};
       
       String [] registro =new String [4];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       if(buscar.isEmpty()){
          sSQL="select * from gastos order by idgasto desc"; 
       } else{
          sSQL="select * from gastos where fecha= '"+ buscar + "' order by idgasto desc";
       }
      
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("idgasto");
               registro [1]=rs.getString("tipo_gasto");
               registro [2]=rs.getString("total");
               registro [3]=rs.getString("fecha");
              
               
               totalregistros=totalregistros+1;
               modelo.addRow(registro);
               
           }
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
    
   } //funcion que permite modificar los registros de la BD
     public boolean editar (Dgastos dts){
       sSQL="update gastos set tipo_gasto=?,total=?,fecha=?"+
               " where idgasto=?";
           
       
       try {
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setString(1, dts.getTipo_gasto());
           pst.setDouble(2, dts.getTotal());
           pst.setDate(3, (Date) dts.getFecha());
        
           pst.setInt(4, dts.getId());
           
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
  
     //FUNCION que permite eliminar registros de la tabla gastos
     public boolean eliminar (Dgastos dts){
       sSQL="delete from gastos where idgasto=?";
       
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
     //metodo que permite insertar registros en la Base de Datos
     public boolean insertar (Dgastos dts){
       sSQL="insert into gastos (tipo_gasto,total,fecha)" +
               "values (?,?,?)";
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setString(1, dts.getTipo_gasto());
           pst.setDouble(2, dts.getTotal());
           pst.setDate(3, (Date) dts.getFecha());
     
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
