/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import db.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author guilh
 */
public class DaoBebidas {
    
    
    
    Connection conectar = Conectar.conectar();
    
   public ArrayList<String> listar(){
       
       try {
           ArrayList<String> lBe = new ArrayList<String>();
           
           String query = "SELECT nome FROM tbl_bebida";
           
           PreparedStatement st = conectar.prepareStatement(query);
           ResultSet rs = st.executeQuery();
           
           while(rs.next()){
               lBe.add(rs.getString("nome"));
           }
           st.close();
           
           return lBe;
       } catch (SQLException ex) {
            throw new RuntimeException(ex);       
       }
      
   }
   
   public ResultSet listarT(){
       
       try {
         
           
           String query = "SELECT * FROM tbl_bebida";
           
           PreparedStatement st = conectar.prepareStatement(query);
           ResultSet rs = st.executeQuery();
           
           
           
           
           return rs;
       } catch (SQLException ex) {
            throw new RuntimeException(ex);       
       }
      
   }
   
   
    public void add(String nome,String preco){
        
         String sql =  "insert into tbl_bebida (nome,preco) values(?,?)";

       
         
         try {
             PreparedStatement st = conectar.prepareStatement(sql);
           
              
             st.setString(1,nome);
             
             st.setString(2,preco);
             st.execute();

             st.close();

         }catch(SQLException ex){
               throw new RuntimeException(ex);
         }
        
    }
    
    public void excluir(int id){
        String sql = "delete from tbl_bebida where idBebidas = ?";
        
        try{
            PreparedStatement status = conectar.prepareStatement(sql);
            status.setInt(1, id);
            status.execute();
            status.close();
        }catch(Exception ex){
            throw new RuntimeException (ex);
        }   
    }
    
    
     public void update(String nome,String preco,String id){
        String sql = "update tbl_Bebida set nome = ?, preco = ? where idBebidas = ?";
        
        try{
            
            PreparedStatement status = conectar.prepareStatement(sql);
            status.setString(1,nome);
            status.setString(2,preco);
            status.setString(3,id);
         
            status.execute();
            status.close();
        }catch(Exception ex){
            throw new RuntimeException (ex);
        }
            
            
            
    }
}
