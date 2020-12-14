/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.PedidoModel;
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
public class DaoPedidos {
    
    static String idN;

    public static String getIdN() {
        return idN;
    }

    public static void setIdN(String idN) {
        DaoPedidos.idN = idN;
    }
    
    
    Connection conectar = Conectar.conectar();
    
    public void add(PedidoModel pedido,String id){
        
        String sql = "insert into tbl_produtosPedidos (pizza,borda,bebida,npiz,nbebi,preco,fk_usuario) values(?,?,?,?,?,?,?)";
        DaoPedidos.setIdN(id);
       
        System.out.println(id);
        try{
           
            PreparedStatement status = conectar.prepareStatement(sql);
           
            status.setString(1,pedido.getPizza());
            status.setString(2,pedido.getBorda());
            status.setString(3,pedido.getBebida());
            status.setString(4,pedido.getNpiz());
            status.setString(5,pedido.getNbebi());
            status.setInt(6,pedido.getPreco()); 
            status.setString(7,id);

            status.execute();
            status.close();
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
   
   
    
   
    
   public ResultSet listar(String id){
        
        String sql = "Select pizza,borda,bebida,npiz,nbebi,hora,preco from tbl_produtosPedidos where fk_usuario = ?";
         
        try{
         PreparedStatement status = conectar.prepareStatement(sql);
             
             status.setString(1,DaoPedidos.getIdN());
             ResultSet rs;
             rs = status.executeQuery();
             return rs;
       
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
        
    }
   
   
   
    public ResultSet listarTodos(){
        
        String sql = "Select * from tbl_produtosPedidos";
         
        try{
         PreparedStatement status = conectar.prepareStatement(sql);
             
             
             ResultSet rs;
             rs = status.executeQuery();
             return rs;
       
        }catch(SQLException erro){
            throw new RuntimeException(erro);
        }
        
    }
   
   
   
   
}
