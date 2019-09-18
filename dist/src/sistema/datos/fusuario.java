
package sistema.datos;
import sistema.pojos.Dusuario;
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
public class fusuario {
    private Connection cn = Coneccion.getConnection();
    private String sSQL = "";  
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"ID","Usuario","Contraseña","Tipo Usuario"};
       
       String [] registro =new String [4];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select * from usuarios where usuario like '%"+ buscar + "%' order by idusuario desc";
       //sSQL="select * from usuarios";
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("idusuario");
               registro [1]=rs.getString("usuario");
               registro [2]=rs.getString("contraseña");
               registro [3]=rs.getString("tipo_usuario");
              
               
               totalregistros=totalregistros+1;
               modelo.addRow(registro);
               
           }
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
    
   } 
    public boolean insertar (Dusuario dts){
       sSQL="insert into usuarios (usuario,contraseña,tipo_usuario)" +
               "values (?,?,?)";
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setString(1, dts.getUsuario());
           pst.setString(2, dts.getContra());
           pst.setString(3, dts.getTipo());
     
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
    public boolean editar (Dusuario dts){
       sSQL="update usuarios set usuario=?,contraseña=?,tipo_usuario=?"+
               " where idusuario=?";
           
       
       try {
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setString(1, dts.getUsuario());
           pst.setString(2, dts.getContra());
           pst.setString(3, dts.getTipo());
        
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
  
public boolean eliminar (Dusuario dts){
       sSQL="delete from usuarios where idusuario=?";
       
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
    public DefaultTableModel login(String login,String password) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Usuario", "Contraseña", "Tipo Usuario"};

        String[] registro = new String[4];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select * from usuarios where usuario='"
                + login + "' and contraseña='" + password + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idusuario");
                registro[1] = rs.getString("usuario");
                registro[2] = rs.getString("contraseña");
                registro[3] = rs.getString("tipo_usuario");
                
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }
     
}
