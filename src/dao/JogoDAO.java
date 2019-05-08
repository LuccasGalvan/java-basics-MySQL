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
import persistencia.ConexaoBanco;

/**
 * @author Thiago Cury
 * @since 25/04/2014
 * @version 1.0
 */
public class JogoDAO {

    //Método cadastrar
    /**
     * @author Thiago Cury
     * @since 25/04/2014
     * @version 1.0
     */
    public void cadastrarJogo(JogoVO jVO) throws SQLException {
        //Buscando uma conexão com o Banco de Dados
        Connection con = ConexaoBanco.getConexao();
        /*Criando obj. capaz de executar instruções
         SQL no banco de dados*/
        Statement stat = con.createStatement();

        try {
            //String que receberá instrução SQL
            String sql;

            sql = "insert into jogo(idjogo, nome, empresa)"
                    + "values(null,'" + jVO.getNome() + "','" + jVO.getEmpresa() + "')";

            stat.execute(sql);

        } catch (SQLException se) {
            throw new SQLException("Erro ao inserir dados no Banco de Dados " + se.getMessage());
        } finally {
            stat.close();
            con.close();
        }//fecha finally
    }//efcha método

    //Método buscar
    /**
     * @author Thiago Cury
     * @since 25/04/2014
     * @version 1.0
     */
    public ArrayList<JogoVO> buscarJogos() throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;
            sql = "select * from jogo";
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<JogoVO> jogos = new ArrayList<>();

            /* Enquanto houver uma próxima linha no 
             banco de dados o while roda */
            while (rs.next()) {
                //Criando um novo obj. ProdutoVO
                JogoVO jVO = new JogoVO();

                /* Mapeando a tabela do banco para objeto
                 chamado pVO */
                jVO.setIdJogo(rs.getLong("idjogo"));
                jVO.setNome(rs.getString("nome"));
                jVO.setEmpresa(rs.getString("empresa"));
                jogos.add(jVO);
            }//Fecha while

            //Retornando o ArrayList com todos objetos
            return jogos;

        } catch (SQLException se) {
            throw new SQLException("Erro ao buscar dados do Banco! " + se.getMessage());
        } finally {
            stat.close();
            con.close();
        }//fecha finally
    }//fecha método
    
    public void deletarJogo(long idJogo) throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        
        try {
            
            String sql = "delete from jogo where idjogo = " +idJogo;
            stat.execute(sql);
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao excluir jogo! "+e.getMessage());
        } finally {
            stat.close();
            con.close();
        }//fecha finally
    }//fecha método
    
    public ArrayList<JogoVO> filtrar(String pesquisa, String filtro) throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql = "select * from jogo ";
            
            if (filtro.equalsIgnoreCase("Nome")) {
                sql += "where nome like '%"+pesquisa+"%'";
            } else if(filtro.equalsIgnoreCase("Código")) {
                sql += "where idjogo like '%"+pesquisa+"%'";
            } else if(filtro.equalsIgnoreCase("Empresa")) {
                sql += "where empresa like '%"+pesquisa+"%'";
            }
                
            /* Executando o SQL  e armazenando
             o ResultSet em um objeto do tipo
             ResultSet chamado rs */
            ResultSet rs = stat.executeQuery(sql);

            /* Criando ArrayList para armazenar 
             objetos do tipo produto */
            ArrayList<JogoVO> prod = new ArrayList<>();

            /* Enquanto houver uma próxima linha no 
             banco de dados o while roda */
            while (rs.next()) {
                //Criando um novo obj. JogoVO
                JogoVO j = new JogoVO();

                /* Mapeando a tabela do banco para objeto
                 chamado jVO */
                j.setIdJogo(rs.getLong("idjogo"));
                j.setNome(rs.getString("nome"));
                j.setEmpresa(rs.getString("empresa"));

                /* Inserindo o objeto pVO no ArrayList */
                prod.add(j);
            }//fecha while

            //Retornando o ArrayList com todos objetos
            return prod;

        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar jogos! " + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }//fecha finally
    }//fecha método

}//fecha classe
