/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.DaoCad;
import Model.CadastroModel;
import View.Cadastro;
import View.Launch;


/**
 *
 * @author guilh
 */
public class CtrlCadastro {
    
    private CadastroModel cadastro;

   public void permitido(CadastroModel cad, Cadastro tela){
       
        
        if (cad.getNome().equals("") || cad.getSenha().equals("") || cad.getCpf().equals("") || 
                cad.getEmail().equals("") || cad.getTelefone().equals("")){
            
            
            tela.menssagem("Campos Vazios!!");
        }else{
            if (cad.getCpf().length() < 11 || cad.getCpf().length() > 11){
                   tela.menssagem("CPF Inválido!");
            }
            if (cad.getTelefone().length() < 9 || cad.getTelefone().length() > 9){
                   tela.menssagem("Número de telefone Inválido. O número deve conter 9 digitos");
            }
             Dao.DaoCad registro = new DaoCad();
            boolean resposta = registro.registrar(cad);
            
            if(resposta){
                tela.menssagem("Cadastrado com Sucesso");
                tela.dispose();
                new Launch().setVisible(true);
            }else{
                 tela.menssagem("Erro ao Cadastrar!\n Tente novamente");
                 tela.dispose();
                 new Launch().setVisible(true);
            }
            
        }
       
       
     
   }
    
    
    
    
    
}
