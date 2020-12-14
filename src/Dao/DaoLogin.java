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
public class DaoLogin {
    
     Connection conectar = Conectar.conectar();
     String id;

    public boolean consulta(String nome, String senha) {
       
        String sql = "select nome, senha, idUsuario from tbl_usuario where nome = ? and senha = ?";
        boolean acesso = false;
        
         try {
             PreparedStatement status = conectar.prepareStatement(sql);
             
             status.setString(1,nome);
             status.setString(2,senha);
             
             ResultSet rs;
             rs = status.executeQuery();
             
             
             if(rs.next()){
                 
                 id = rs.getString("idUsuario"); 
                 acesso = true;
             }
             
             status.close();
             
             
             return acesso;
             
         } catch (SQLException ex) {
             Logger.getLogger(DaoLogin.class.getName()).log(Level.SEVERE, null, ex);
         }
         return acesso;
      
    }
    
    public String nome(String nome) {
       
        String sql = "select idUsuario from tbl_usuario where nome = ?";
        boolean acesso = false;
        
         try {
             PreparedStatement status = conectar.prepareStatement(sql);
             
             status.setString(1,nome);
             ResultSet rs;
             rs = status.executeQuery();
             
             
             if(rs.next()){
                 id = rs.getString("idUsuario"); 
                 System.out.println(id);
             }
             
             status.close();
             
             return id;
             
         } catch (SQLException ex) {
             Logger.getLogger(DaoLogin.class.getName()).log(Level.SEVERE, null, ex);
         }
       return id;
      
    }
    
}
 