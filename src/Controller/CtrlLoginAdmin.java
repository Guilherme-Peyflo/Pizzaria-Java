/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DaoLogin;
import Dao.DaoLoginAdmin;
import View.Launch;
import View.Login;
import View.LoginAdmin;

import View.MainJScrollPane;
import View.TelaAdmin;
import javax.swing.JOptionPane;

/**
 *
 * @author guilh
 */
public class CtrlLoginAdmin {
    
    private final LoginAdmin telaLogin;

    public CtrlLoginAdmin(LoginAdmin telaLogin) {
        this.telaLogin = telaLogin;
    }
    
    public void realizarLogin(String nome, String senha){
        
        if (nome.equals("") || senha.equals("")){
            telaLogin.menssagem("Campos Vazios!!");
        }else{
            Dao.DaoLoginAdmin login = new DaoLoginAdmin();
            boolean resposta = login.consulta(nome, senha);
            
            if(resposta){
                
                telaLogin.dispose();
                TelaAdmin ini = new TelaAdmin();
                ini.setVisible(true);
                
                
            }else{
                telaLogin.menssagem("Login Incorreto!!");
            }
        }
    }
    
    
    
    
}
