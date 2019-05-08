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
public class PersonagemVO {
    
    private long idPersonagem;
    private String nome;
    private String classe;
    
    //associação entre as classes
    private JogoVO jogo;

    public PersonagemVO() {
    }

    public PersonagemVO(long idPersonagem, String nome, String classe, JogoVO jogo) {
        this.idPersonagem = idPersonagem;
        this.nome = nome;
        this.classe = classe;
        this.jogo = jogo;
    }

    public long getIdPersonagem() {
        return idPersonagem;
    }

    public void setIdPersonagem(long idPersonagem) {
        this.idPersonagem = idPersonagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse (String classe) {
        this.classe = classe;
    }

    public JogoVO getJogo() {
        return jogo;
    }

    public void setJogo(JogoVO jogo) {
        this.jogo = jogo;
    }

    @Override
    public String toString() {
        return "EpisodioVO{" + "idEpisodio=" + idPersonagem + ", nome=" + nome + ", classe=" + classe + ", jogo=" + jogo + '}';
    }
    
    
    
}//fecha classe