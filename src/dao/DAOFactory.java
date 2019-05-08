/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


/**
 * @author Thiago Cury
 * @since 25/04/2014
 * @version 1.0
 */
public class DAOFactory {
    
    private static final JogoDAO jogoDAO = new JogoDAO();
    private static final PersonagemDAO personagemDAO = new PersonagemDAO();

    public static JogoDAO getJogoDAO(){
        return jogoDAO;
    }
    
    public static PersonagemDAO getPersonagemDAO(){
        return personagemDAO;
    }
    
    
}//fecha classe
