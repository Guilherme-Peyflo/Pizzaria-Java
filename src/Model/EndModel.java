/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author guilh
 */
public class EndModel {
    String logra;
    String end;
    String bairro;
    String cidade;
    String estado;
    String num;

    public EndModel(String logra, String end, String bairro, String cidade, String estado, String num) {
        this.logra = logra;
        this.end = end;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.num = num;
    }

    public String getLogra() {
        return logra;
    }

    public void setLogra(String logra) {
        this.logra = logra;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
    
    
    
    
}
