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
public class DaoBorda {
    
    
    
    Connection conectar = Conectar.conectar();
    
   public ArrayList<String> listar(){
       
       try {
           ArrayList<String> lBo = new ArrayList<String>();
           
           String query = "SELECT tipo_borda FROM tbl_bordas";
           
           PreparedStatement st = conectar.prepareStatement(query);
           ResultSet rs = st.executeQuery();
           
           while(rs.next()){
               lBo.add(rs.getString("tipo_borda"));
           }
           st.close();
           
           return lBo;
       } catch (SQLException ex) {
            throw new RuntimeException(ex);       
       }
      
   }
   
   
   public ResultSet listarT(){
       
       try {
         
           
           String query = "SELECT * FROM tbl_bordas";
           
           PreparedStatement st = conectar.prepareStatement(query);
           ResultSet rs = st.executeQuery();
           return rs;
       } catch (SQLException ex) {
            throw new RuntimeException(ex);       
       }
      
   }
   
   
   public void add(String nome,String preco){
        
         String sql =  "insert into tbl_bordas (tipo_borda,preco) values(?,?)";

       
         
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
        String sql = "delete from tbl_bordas where idBorda = ?";
        
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
        
         String sql =  "update tbl_bordas set tipo_borda = ?, preco = ? where idBorda = ?";

       
         
         try {
             PreparedStatement st = conectar.prepareStatement(sql); 
         
             st.setString(1,nome);
             st.setString(2,preco);
             st.setString(3,id);
             st.execute();

             st.close();

         }catch(SQLException ex){
               throw new RuntimeException(ex);
         }
        
    }
}
