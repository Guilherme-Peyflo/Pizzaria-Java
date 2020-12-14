/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Gabriel
 */
public class PedidoModel {
         String   pizza;
         String   borda;
         String   bebida;
         String   npiz;
         String   nbebi;
         int   preco;

    public PedidoModel(String pizza, String borda, String bebida, String npiz, String nbebi, int preco) {
        this.pizza = pizza;
        this.borda = borda;
        this.bebida = bebida;
        this.npiz = npiz;
        this.nbebi = nbebi;
        this.preco = preco;
    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public String getBorda() {
        return borda;
    }

    public void setBorda(String borda) {
        this.borda = borda;
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    public String getNpiz() {
        return npiz;
    }

    public void setNpiz(String npiz) {
        this.npiz = npiz;
    }

    public String getNbebi() {
        return nbebi;
    }

    public void setNbebi(String nbebi) {
        this.nbebi = nbebi;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }
    
    
}
