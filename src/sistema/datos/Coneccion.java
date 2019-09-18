/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

        
/**
 *
 * @author Cristhian Menjivar
 */
public class Coneccion {
   
    private static Connection conn;
    
      public static Connection getConnection(){
          try 
          { 
              Class.forName("com.mysql.jdbc.Driver");
              conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sistemallanteria", "root", "123456");
            
              
          } catch (Exception e) {
              JOptionPane.showMessageDialog(null,"Error" + e.getMessage());
              
          }
        return conn;
      }
              
      
    
}
