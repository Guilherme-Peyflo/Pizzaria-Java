/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import View.Pedidos;
import java.sql.PreparedStatement;
import db.Conectar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author guilh
 */
public class DaoLoginAdmin {
    
     Connection conectar = Conectar.conectar();
     String id;

    public boolean consulta(String nome, String senha) {
       
        String sql = "select nome, senha, idAdmin from tbl_admin where nome = ? and senha = ?";
        boolean acesso = false;
        
         try {
             PreparedStatement status = conectar.prepareStatement(sql);
             
             status.setString(1,nome);
             status.setString(2,senha);
             
             ResultSet rs;
             rs = status.executeQuery();
             
             
             if(rs.next()){
                 acesso = true;
             }
             
             status.close();
             
             
             return acesso;
             
         } catch (SQLException ex) {
             Logger.getLogger(DaoLoginAdmin.class.getName()).log(Level.SEVERE, null, ex);
         }
         return acesso;
      
    }
    
}
 