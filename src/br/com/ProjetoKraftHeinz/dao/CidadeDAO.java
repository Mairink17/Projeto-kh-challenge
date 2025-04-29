package br.com.ProjetoKraftHeinz.dao;

import br.com.ProjetoKraftHeinz.beans.Cidade;
import br.com.ProjetoKraftHeinz.jdbc.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static br.com.ProjetoKraftHeinz.constantes.TabelaSistema.*;

public class CidadeDAO  {

    private Connection conexao;

    public void cadastrar(Cidade cidade){

        PreparedStatement stmt = null;

        try {
            conexao = DbManager.getInstance().obterConexao();

            String sql = " INSERT INTO " + TABCIDADE + "(ID_CIDADE , DS_CIDADE , CD_IBGE , FK_ID_ESTADO ) VALUES " +
                    "( " + SQCIDADE + ".NEXTVAL, ? , ? , ? )";
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, cidade.getDescricaoCidade());
            stmt.setString(2, cidade.getCodigoIbge());
            stmt.setLong(3, cidade.getEstado().getCodigo());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public List<Cidade> getListaConsulta(){

        List<Cidade> listaCidade = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{

            conexao = DbManager.getInstance().obterConexao();

            String sql = "SELECT * FROM " + TABCIDADE + " ORDER BY ID_CIDADE ";
            stmt = conexao.prepareStatement(sql );
            rs = stmt.executeQuery();
            while (rs.next()){
                int codigo = rs.getInt("ID_CIDADE");
                String descricaoCidade = rs.getString("DS_CIDADE");
                Cidade cidade = new Cidade(codigo, descricaoCidade );
                listaCidade.add(cidade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try{
                stmt.close();
                rs.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaCidade;
    }


    public Cidade getConsulta(long idCidade){

        Cidade cidadeConsulta = new Cidade();
        PreparedStatement stmt = null;

        ResultSet rs = null;

        try{
            conexao = DbManager.getInstance().obterConexao();
            stmt = conexao.prepareStatement("SELECT * FROM " + TABCIDADE +" WHERE ID_CIDADE = "
                    + idCidade);
            rs = stmt.executeQuery();
            while (rs.next()){
                int codigo = rs.getInt("ID_CIDADE");
                String descricaoCidade = rs.getString("DS_CIDADE");
                String codIBGE = rs.getString("CD_IBGE");
                long idEstado = rs.getLong("FK_ID_ESTADO");

                Cidade cidade = new Cidade(codigo, descricaoCidade , codIBGE , new EstadoDAO().getConsulta(idEstado));
                cidadeConsulta = cidade;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try{
                stmt.close();
                rs.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cidadeConsulta;
    }
}
