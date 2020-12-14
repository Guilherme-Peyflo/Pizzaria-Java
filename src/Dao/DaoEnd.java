/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import View.CadEndereco;
import db.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author guilh
 */
public class DaoEnd {
    
    
    Connection conectar = Conectar.conectar();

    public boolean resgistrar(String logra, String end, String bairro, String cidade, String estado, String num) {
        String sql = "insert into tbl_endereco (logradouro, endereco,bairro,municipio,estado,numero) value (?,?,?,?,?,?)";
        boolean acesso = false;
        
         try {
             PreparedStatement status = conectar.prepareStatement(sql);
             
             status.setString(1,logra);
             status.setString(2,end);
             status.setString(3,bairro);
             status.setString(4,cidade);
             status.setString(5,estado);
             status.setString(6,num);

             status.execute();
             
             acesso = true;
             
             return acesso;
      
         }catch(SQLException ex){
             
         }
         return acesso;
    }
}
