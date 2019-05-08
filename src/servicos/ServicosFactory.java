/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

/**
 * @author Thiago Cury
 * @since 25/04/2014
 * @version 1.0
 */
public class ServicosFactory {
    
    private static final JogoServicos jogoServicos=new JogoServicos();
    private static final PersonagemServicos personagemServicos=new PersonagemServicos();
    
    public static JogoServicos getJogoServicos(){
        return jogoServicos;
    }//fecha método
    
    public static PersonagemServicos getPersonagemServicos(){
        return personagemServicos;
    }//fecha método

}//fecha classe
