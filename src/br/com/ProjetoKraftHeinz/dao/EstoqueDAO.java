package br.com.ProjetoKraftHeinz.dao;

import br.com.ProjetoKraftHeinz.beans.Estoque;
import br.com.ProjetoKraftHeinz.jdbc.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static br.com.ProjetoKraftHeinz.constantes.TabelaSistema.*;

public class EstoqueDAO {

    private Connection conexao;

    public void cadastrar(Estoque estoque){

        PreparedStatement stmt = null;

        try {
            conexao = DbManager.getInstance().obterConexao();

            String sql = " INSERT INTO " + TABESTOQUE + "(ID_ESTOQUE , DS_ESTOQUE , TP_ESTOQUE , FK_ID_FABRICA ) VALUES " +
                    "( " + SQESTOQUE + ".NEXTVAL, ? , ? , ? )";
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, estoque.getDescricaoEstoque());
            stmt.setString(2,  String.valueOf(estoque.getTipoEstoque()));
            stmt.setLong(3, estoque.getFkFabrica());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public Estoque getConsulta(long idEstoque){

        Estoque estoqueConsulta = new Estoque();
        PreparedStatement stmt = null;

        ResultSet rs = null;

        try{

            conexao = DbManager.getInstance().obterConexao();

            stmt = conexao.prepareStatement("SELECT * FROM " + TABESTOQUE +" WHERE ID_ESTOQUE = "
                    + idEstoque);
            rs = stmt.executeQuery();
            while (rs.next()){
                long codigo = rs.getLong("ID_ESTOQUE");
                String descricaoEstoque = rs.getString("DS_ESTOQUE");
                String tipoEstoque = rs.getString("TP_ESTOQUE");
                long idFabrica = rs.getLong("FK_ID_FABRICA");


                Estoque estoque = new Estoque(codigo, descricaoEstoque , tipoEstoque.charAt(0), idFabrica);
                estoqueConsulta = estoque;
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

        return estoqueConsulta;

    }


}

