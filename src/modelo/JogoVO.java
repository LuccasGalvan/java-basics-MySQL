/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 * @author Thiago Cury
 * @since 25/04/2014
 * @version 1.0
 */
public class JogoVO {
    
    private long idJogo;
    private String nome;
    private String empresa;

    public JogoVO() {
    }

    public long getIdJogo() {
        return idJogo;
    }

    public void setIdJogo (long idJogo) {
        this.idJogo = idJogo;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmpresa() {
        return empresa;
    }
    
    public void setEmpresa (String empresa) {
        this.empresa = empresa;
    }

    /* toString() editado para ser mostrado exatamente dessa maneira na JComboBox
    em GuiCadEpisodio */
    @Override
    public String toString() {
        return nome +" - "+ empresa;
    }
}//fecha classe
