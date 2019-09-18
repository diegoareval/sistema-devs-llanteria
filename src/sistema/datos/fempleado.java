/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.datos;
import sistema.pojos.Dempleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego Enrique Arevalo Avelar
 */
public class fempleado {
    private Coneccion mysql = new Coneccion();
    private Connection cn = mysql.getConnection();
    private String sSQL = "";  
    public Integer totalregistros;
    
     public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"ID","Nombre","Apellido","Direccion","Telefono","Cargo","Salario","Comision"};
       
       String [] registro =new String [8];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select * from empleados where nombre like '%"+ buscar + "%' order by idempleado desc";
       //sSQL="select * from usuarios";
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("idempleado");
               registro [1]=rs.getString("nombre");
               registro [2]=rs.getString("apellido");
               registro [3]=rs.getString("direccion");
               registro [4]=rs.getString("telefono");
               registro [5]=rs.getString("cargo");
               registro [6]=rs.getString("salario_devengado");
               registro [7]=rs.getString("comision");
              
               
               totalregistros=totalregistros+1;
               modelo.addRow(registro);
               
           }
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
    
   } 
     public boolean insertar (Dempleado dts){
       sSQL="insert into empleados (nombre,apellido,direccion,telefono,cargo,salario_devengado,comision)" +
               "values (?,?,?,?,?,?,?)";
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setString(1, dts.getNombre());
           pst.setString(2, dts.getApellido());
           pst.setString(3, dts.getDireccion());
           pst.setString(4, dts.getTelefono());
           pst.setString(5, dts.getCargo());
           pst.setFloat(6, dts.getSalario());
            pst.setFloat(7, dts.getComision());
     
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
      public boolean editar (Dempleado dts){
       sSQL="update empleados set nombre=?,apellido=?,direccion=?,telefono=?,cargo=?,salario_devengado=?,comision=?"+
               " where idempleado=?";
           
       
       try {
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setString(1, dts.getNombre());
           pst.setString(2, dts.getApellido());
           pst.setString(3, dts.getDireccion());
           pst.setString(4, dts.getTelefono());
           pst.setString(5, dts.getCargo());
           pst.setFloat(6, dts.getSalario());
           pst.setFloat(7, dts.getComision());
        
           pst.setInt(8, dts.getId());
           
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
  //funcion eliminar registro de empleados
     public boolean eliminar (Dempleado dts){
       sSQL="delete from empleados where idempleado=?";
       
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
