
package sistema.datos;
import sistema.pojos.Dcredito;
import java.sql.Connection;
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
public class fcredito {
    
    Connection cn = Coneccion.getConnection();
    private String sSQL = "";  
    
    public Integer totalregistros;
    
     public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"ID Crédito","Nombre Cliente","Monto","Fecha","N° Venta"};
       
       String [] registro =new String [5];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="SELECT * FROM creditos,clientes where clientes.idcliente=creditos.idcliente and clientes.nombre like '%"+ buscar + "%' order by creditos.idcredito desc";
       //sSQL="select * from usuarios";
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               
               registro [0]=rs.getString("idcredito");
               registro [1]=rs.getString("nombre");
               registro [2]=rs.getString("monto");
               registro [3]=rs.getString("fecha");
               registro [4]=rs.getString("idventa");
              
               
               totalregistros=totalregistros+1;
               modelo.addRow(registro);
               
           }
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
    
   } 
     
      public boolean editar (Dcredito dts){
       sSQL="update creditos set monto=?,fecha=?"+
               " where idcredito=?";
           
       try {
           PreparedStatement pst=cn.prepareStatement(sSQL);
           
           pst.setFloat(1, dts.getMonto());
           pst.setDate(2, (Date) dts.getFecha());
           pst.setInt(3, dts.getIdcredito());
           
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
       public boolean eliminar (Dcredito dts){
       sSQL="delete from creditos where idcredito=?";
       
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           
           pst.setInt(1, dts.getIdcredito());
           
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
      public boolean insertar (Dcredito dts){
       sSQL="insert into creditos (idcliente,idventa,monto,fecha)" +
               "values (?,?,?,?)";
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setInt(1, dts.getIdcliente());
           pst.setInt(2, dts.getIdventa());
           pst.setFloat(3, dts.getMonto());
           pst.setDate(4, (Date) dts.getFecha());
     
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
