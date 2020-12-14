/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DaoLogin;
import View.Launch;
import View.Login;

import View.MainJScrollPane;
import javax.swing.JOptionPane;

/**
 *
 * @author guilh
 */
public class CtrlLogin {
    
    private final Login telaLogin;

    public CtrlLogin(Login telaLogin) {
        this.telaLogin = telaLogin;
    }
    
    public void realizarLogin(String nome, String senha){
        
        if (nome.equals("") || senha.equals("")){
            telaLogin.menssagem("Campos Vazios!!");
        }else{
            Dao.DaoLogin login = new DaoLogin();
            boolean resposta = login.consulta(nome, senha);
            
            if(resposta){
                
                telaLogin.dispose();
                MainJScrollPane ini = new MainJScrollPane();
                ini.nome(nome);
                System.out.println(nome);
                ini.setVisible(true);
                
                
            }else{
                telaLogin.menssagem("Login Incorreto!!");
            }
        }
    }
    
    
    
    
}
