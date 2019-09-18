
package sistema.datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistema.pojos.Dcliente;

/**
 *
 * @author Diego Enrique Arevalo
 */
public class fcliente {
     Connection cn = Coneccion.getConnection();
    private String sSQL = "";  
    public Integer totalregistros;
    
     // obtener todos los clientes para combobox
    public ArrayList<Dcliente> obtenerClienteCombo() {
        // creacion de un array list lista de objetos productos
        ArrayList<Dcliente> listaCliente = new ArrayList<Dcliente>();
        try {
            cn = Coneccion.getConnection();

            String sql = "SELECT * FROM clientes order by nombre";

            Statement st= cn.createStatement();

            ResultSet rs= st.executeQuery(sql);
           
            while (rs.next()) {
                // obtencion de cada campo de la tabla producto
                int idCliente = rs.getInt("idcliente");
                String nombre = rs.getString("nombre");
                String Apellido = rs.getString("apellido");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
            
                // creacion de objeto con sus atrinutos inicializados
             Dcliente objCliente = new Dcliente();
             objCliente.setId(idCliente);
             objCliente.setNombre(nombre);
             objCliente.setApellido(Apellido);
             objCliente.setDireccion(direccion);
             objCliente.setTelefono(telefono);
             
                // le añadimos el objeto producto al array list de productos
             listaCliente.add(objCliente);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listaCliente;
    }
    
     public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"Código","Nombre","Apellido","Direccción","Teléfono"};
       
       String [] registro =new String [5];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select * from clientes where idcliente like '%"+ buscar + "%' or nombre like '%"+ buscar + "%' order by idcliente desc";
       //sSQL="select * from usuarios";
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("idcliente");
               registro [1]=rs.getString("nombre");
               registro [2]=rs.getString("apellido");
               registro [3]=rs.getString("direccion");
               registro [4]=rs.getString("telefono");
              
               
               totalregistros=totalregistros+1;
               modelo.addRow(registro);
               
           }
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
    
   } 
      public boolean editar (Dcliente dts){
       sSQL="update clientes set nombre=?,apellido=?,direccion=?,telefono=?"+
               " where idcliente=?";
           
       
       try {
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setString(1, dts.getNombre());
           pst.setString(2, dts.getApellido());
           pst.setString(3, dts.getDireccion());
           pst.setString(4, dts.getTelefono());
        
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
  
     //ingresar registro de clientes
     public boolean insertar (Dcliente dts){
       sSQL="insert into clientes (nombre,apellido,direccion,telefono)" +
               "values (?,?,?,?)";
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setString(1, dts.getNombre());
           pst.setString(2, dts.getApellido());
           pst.setString(3, dts.getDireccion());
           pst.setString(4, dts.getTelefono());
     
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
   
     public boolean eliminar (Dcliente dts){
       sSQL="delete from clientes where idcliente=?";
       
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
