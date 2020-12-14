/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DaoEnd;
import Model.EndModel;
import View.CadEndereco;
import View.Cadastro;

/**
 *
 * @author guilh
 */
public class CtrlEnd {
    
    
    private EndModel end;

    public CtrlEnd(EndModel end,CadEndereco tela) {
        this.end = end;
    }
    
    public void registrarEnd(String logra, String end, String bairro, String cidade, String estado, String num,CadEndereco tela){
        
        if (estado.length() > 2){
            tela.menssagem("Use a Sigla do Estado!");
        }
            Dao.DaoEnd regEnd = new DaoEnd();
            boolean resposta = regEnd.resgistrar(logra, end, bairro, cidade,  estado, num);
            if(resposta){
                
                tela.dispose();
                new Cadastro().setVisible(true);
            }else{
                tela.menssagem("Erro ao Cadastrar o endereço!!\n Tente novamente");
            }
        
    }
}
