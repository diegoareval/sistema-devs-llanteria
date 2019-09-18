/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistema.datos.Coneccion;
import sistema.pojos.Dinventario;
/**
 *
 * @author Diego Enrique Arevalo
 */
public class finventario {
    private Connection cn = Coneccion.getConnection();
    private String sSQL = "";  
    public Integer totalregistros;
    
   
     public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"ID Producto","Medida","Nombre","Inventario","Precio Compra","Precio Sugerido","Marca"};
       
       String [] registro =new String [7];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
     // sSQL="select idproducto,medida,nombre,inventario,precio_compra,precio_sugerido from productos where nombre like '%"+ buscar + "%' order by idproducto";
       sSQL="select p.idproducto,p.medida,p.nombre,p.inventario,p.precio_compra,p.precio_sugerido,m.marca from productos p inner join marca m on p.idmarca=m.idmarca where p.nombre like '%"+ buscar + "%' order by p.idproducto";
       //sSQL="select * from usuarios";
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("idproducto");
               registro [1]=rs.getString("medida");
               registro [2]=rs.getString("nombre");
               registro [3]=rs.getString("inventario");
               registro [4]=rs.getString("precio_compra");
               registro [5]=rs.getString("precio_sugerido");
               registro [6]=rs.getString("marca");
              
               totalregistros=totalregistros+1;
               modelo.addRow(registro);
               
           }
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
    
   } 
     public boolean editar (Dinventario dts){
       sSQL="update productos set inventario=inventario+? where idproducto=?";
           
       
       try {
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setInt(1, dts.getStock());
           pst.setInt(2, dts.getId());
       
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
     
     public int disminuirInventario(int idProducto, double cantidad){
         int resultado=0;
       sSQL="update productos set inventario = case when  (?>= inventario)  then 0 else inventario - ?  end  where idproducto=?";
           
       
       try {
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setDouble(1, cantidad);
           pst.setDouble(2, cantidad);
           pst.setInt(3, idProducto);
       
           resultado=pst.executeUpdate();
           
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
       }
       return resultado;
   }
     
  public boolean insertar (Dinventario dts){
       sSQL="insert into usuarios (nombre,stock,precio_compra,precio_real)" +
               "values (?,?,?,?)";
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setString(1, dts.getNombre());
           pst.setInt(2, dts.getStock());
           pst.setDouble(3, dts.getPreciocompra());
           pst.setDouble(4, dts.getPrecioreal());
     
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
