/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author guilh
 */
public class main {
    
    
    
    public static void main(String[] args){
        Connection conectar = Conectar.conectar();
        
         String sql = "select * from tbl_endereco";
         
         try {
             PreparedStatement st = conectar.prepareStatement(sql);
              ResultSet rs = st.executeQuery();
              int id = 0;
              while(rs.next()) {
               id = rs.getRow();
              }
             System.out.println(id);
           }catch(SQLException ex){
               throw new RuntimeException(ex);
            }
         
    }  
}
