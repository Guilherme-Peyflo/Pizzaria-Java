/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import db.Conectar;
import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guilh
 */
public class DaoPizza {
    
   Connection conectar = Conectar.conectar();
    
   public ArrayList<String> listar(){
       
       try {
           ArrayList<String> lPizzas = new ArrayList<String>();
           
           String query = "SELECT recheio_pizza FROM tbl_pizza";
           
           PreparedStatement st = conectar.prepareStatement(query);
           ResultSet rs = st.executeQuery();
           
           while(rs.next()){
               lPizzas.add(rs.getString("recheio_pizza"));
           }
           st.close();
           
           return lPizzas;
       } catch (SQLException ex) {
            throw new RuntimeException(ex);       
       }
       
   }
       public ResultSet listarT(){
       
       try {
           ArrayList<String> lPizzas = new ArrayList<String>();
           
           String query = "SELECT idPizza,recheio_pizza,preco,descricao_pizza  FROM tbl_pizza";
           
           PreparedStatement st = conectar.prepareStatement(query);
           ResultSet rs = st.executeQuery();
           
           return rs;
       } catch (SQLException ex) {
            throw new RuntimeException(ex);       
       }
      
   }
       
       
       public void add(String nome,String preco,String desc){
        
         String sql =  "insert into tbl_pizza (recheio_pizza,preco,descricao_pizza) values(?,?,?)";
         boolean acesso;
       
         
         try {
             PreparedStatement st = conectar.prepareStatement(sql);
             st.setString(1,nome);
             
             st.setString(2,preco);
         
             st.setString(3,desc);

             st.execute();

             st.close();

         }catch(SQLException ex){
               throw new RuntimeException(ex);
         }
        
    }
       
       
       public void update(String nome,String preco,String desc,String id){
        String sql = "update tbl_pizza set recheio_pizza = ?, preco = ?, descricao_pizza = ? where idPizza = ?";
        
        try{
            
            PreparedStatement status = conectar.prepareStatement(sql);
            status.setString(1,nome);
            status.setString(2,preco);
            status.setString(3,desc);
            status.setString(4,id);
         
            status.execute();
            status.close();
        }catch(Exception ex){
            throw new RuntimeException (ex);
        }   
    }
       
       public void excluir(int id){
        String sql = "delete from tbl_pizza where idPizza = ?";
        
        try{
            PreparedStatement status = conectar.prepareStatement(sql);
            status.setInt(1, id);
            status.execute();
            status.close();
        }catch(Exception ex){
            throw new RuntimeException (ex);
        }   
    }
 }
