/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dao.DAOFactory;
import dao.PersonagemDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.PersonagemVO;

/**
 * @author Thiago Cury
 * @since 25/04/2014
 * @version 1.0
 */
public class PersonagemServicos {
    
    public void cadastrarPersonagem(PersonagemVO pVO) throws SQLException{
        PersonagemDAO pDAO = DAOFactory.getPersonagemDAO();
        pDAO.cadastrarPersonagem(pVO);
    }//fecha método
    
    public ArrayList<PersonagemVO> buscarPersonagens() throws SQLException {
        PersonagemDAO pDAO = DAOFactory.getPersonagemDAO();
        return pDAO.buscarPersonagens();
    }//fecha método
    
    public void deletarPersonagem(long idPersonagem) throws SQLException {
        PersonagemDAO pDAO = DAOFactory.getPersonagemDAO();
        pDAO.deletarPersonagem(idPersonagem);
    }//fecha método
    
    public ArrayList<PersonagemVO> filtrar(String pesquisa, String filtro) throws SQLException {
        PersonagemDAO pDAO = DAOFactory.getPersonagemDAO();
        return pDAO.filtrar(pesquisa, filtro);
    }//fecha método
    
  }//fecha classe
