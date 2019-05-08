/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dao.DAOFactory;
import dao.JogoDAO;
import dao.PersonagemDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.JogoVO;
import modelo.PersonagemVO;

/**
 * @author Thiago Cury
 * @since 25/04/2014
 * @version 1.0
 */
public class JogoServicos {

    //Metodo cadastrar
    public void cadastrarJogo (JogoVO jVO) throws SQLException {
        JogoDAO jDAO = DAOFactory.getJogoDAO();
        jDAO.cadastrarJogo(jVO);
    }//fecha método

    //Método buscar
    public ArrayList<JogoVO> buscarJogos() throws SQLException {
        JogoDAO jDAO = DAOFactory.getJogoDAO();
        return jDAO.buscarJogos();
    }//fecha método
    
    public void deletarJogo(long idJogo) throws SQLException {
        JogoDAO jDAO = DAOFactory.getJogoDAO();
        jDAO.deletarJogo(idJogo);
    }//fecha método
    
    public ArrayList<JogoVO> filtrar(String pesquisa, String filtro) throws SQLException {
        JogoDAO jDAO = DAOFactory.getJogoDAO();
        return jDAO.filtrar(pesquisa, filtro);
    }//fecha método
    
}//fecha classe
