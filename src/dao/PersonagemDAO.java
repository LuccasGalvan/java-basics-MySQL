/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.JogoVO;
import modelo.PersonagemVO;
import persistencia.ConexaoBanco;

/**
 * @author Thiago Cury
 * @since 25/04/2014
 * @version 1.0
 */
public class PersonagemDAO {
    
    public void cadastrarPersonagem(PersonagemVO pVO) throws SQLException{
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        try {
            String sql;
            
            /* Nesse insert note que vamos buscar a coluna idseriado (chave estrangeira) 
               a partir do objeto eVo.getSeriaod().getIdSeriado() */
            sql = "insert into personagem(idpersonagem, nome, classe, idjogo)"
                   +"values(null, '"+pVO.getNome()+"', '"+pVO.getClasse()+"', "+pVO.getJogo().getIdJogo()+")";
                      
            stat.execute(sql);
            
        } catch (SQLException se) {
            throw  new SQLException("Erro ao cadastrar personagem! "+se.getMessage());
        } finally{
            con.close();
            stat.close();
        }//fecha finally
    }//fecha método cadastrarEpisodio
    
    public ArrayList<PersonagemVO> buscarPersonagens() throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;
            sql = "select * from personagem";
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<PersonagemVO> personagens = new ArrayList<>();

            /* Enquanto houver uma próxima linha no 
             banco de dados o while roda */
            while (rs.next()) {
                //Criando um novo obj. ProdutoVO
                PersonagemVO pVO = new PersonagemVO();

                /* Mapeando a tabela do banco para objeto
                 chamado pVO */
                pVO.setIdPersonagem(rs.getLong("idpersonagem"));
                pVO.setNome(rs.getString("nome"));
                pVO.setClasse(rs.getString("classe"));
                
                personagens.add(pVO);
            }//Fecha while

            //Retornando o ArrayList com todos objetos
            return personagens;

        } catch (SQLException se) {
            throw new SQLException("Erro ao buscar dados do Banco! " + se.getMessage());
        } finally {
            stat.close();
            con.close();
        }//fecha finally
    }//fecha método
    
    public void deletarPersonagem(long idPersonagem) throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        
        try {
            
            String sql = "delete from personagem where idpersonagem = " +idPersonagem;
            stat.execute(sql);
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao excluir personagem! "+e.getMessage());
        } finally {
            stat.close();
            con.close();
        }//fecha finally
    }//fecha método
    
    public ArrayList<PersonagemVO> filtrar(String pesquisa, String filtro) throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql = "select * from personagem ";
            
            if (filtro.equalsIgnoreCase("Nome")) {
                sql += "where nome like '%"+pesquisa+"%'";
            } else if(filtro.equalsIgnoreCase("Código")) {
                sql += "where idpersonagem like '%"+pesquisa+"%'";
            } else if(filtro.equalsIgnoreCase("Classe")) {
                sql += "where classe like '%"+pesquisa+"%'";
            }
                
            /* Executando o SQL  e armazenando
             o ResultSet em um objeto do tipo
             ResultSet chamado rs */
            ResultSet rs = stat.executeQuery(sql);

            /* Criando ArrayList para armazenar 
             objetos do tipo produto */
            ArrayList<PersonagemVO> prod = new ArrayList<>();

            /* Enquanto houver uma próxima linha no 
             banco de dados o while roda */
            while (rs.next()) {
                //Criando um novo obj. ProdutoVO
                PersonagemVO p = new PersonagemVO();

                /* Mapeando a tabela do banco para objeto
                 chamado pVO */
                p.setIdPersonagem(rs.getLong("idpersonagem"));
                p.setNome(rs.getString("nome"));
                p.setClasse(rs.getString("classe"));

                /* Inserindo o objeto pVO no ArrayList */
                prod.add(p);
            }//fecha while

            //Retornando o ArrayList com todos objetos
            return prod;

        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar personagens! " + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }//fecha finally
    }//fecha método
    
}//fecha classe
