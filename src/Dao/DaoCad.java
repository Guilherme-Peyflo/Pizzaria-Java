/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.ResultSetMetaData;
import db.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


/**
 *
 * @author guilh
 */
public class DaoCad {
    
      Connection conectar = Conectar.conectar();
    
    public boolean registrar(Model.CadastroModel cad){
        
         String sqluser =  "insert into tbl_usuario (nome,senha,cpf,email,telefone,fk_endereco) values(?,?,?,?,?,?)";
         boolean acesso;
         String sql = "select * from tbl_endereco";
         
        System.out.println("chegou ate os status");
         try {
             PreparedStatement status = conectar.prepareStatement(sqluser);
             PreparedStatement st = conectar.prepareStatement(sql);
             ResultSet rs =  st.executeQuery();  
              int id = 0;
              while(rs.next()) {
               id = rs.getRow();
              }
             status.setString(1,cad.getNome());
             System.out.println("chegou ate os status 1");
             status.setString(2,cad.getSenha());
             System.out.println("chegou ate os status 2");
             status.setString(3,cad.getCpf());
             System.out.println("chegou ate os status 3");
             status.setString(4,cad.getEmail());
             System.out.println("chegou ate os status 4");
             status.setString(5,cad.getTelefone());
             System.out.println("chegou ate os status 5");
             status.setInt(6, id);
             System.out.println("chegou ate os status 6");
            

             status.execute();
             System.out.println("foi pro banco");
             
             acesso = true;
             System.out.println("True");
             status.close();
             System.out.println("Fechou status");
             return acesso;
          
      
         }catch(SQLException ex){
               throw new RuntimeException(ex);
         }
        
    }
}
