package br.com.ProjetoKraftHeinz.dao;

import br.com.ProjetoKraftHeinz.beans.EstoqueProduto;
import br.com.ProjetoKraftHeinz.jdbc.DbManager;

import java.sql.*;

import static br.com.ProjetoKraftHeinz.constantes.TabelaSistema.SQESTOQUEPROD;
import static br.com.ProjetoKraftHeinz.constantes.TabelaSistema.TABESTOQUEPROD;


public class EstoqueProdutoDAO {

    private Connection conexao;

    public void entradaEstoque(EstoqueProduto estoqueProduto) {

        PreparedStatement stmt = null;

        try {
            conexao = DbManager.getInstance().obterConexao();

            String sql = " INSERT INTO " + TABESTOQUEPROD + "(ID_LOTE , FK_PK_ID_ESTOQUE , FK_PK_ID_PRODUTO , QTD_ESTOQUE, DT_ENTRADA" +
                    ", DT_FABRICACAO ) VALUES " +
                    "( " + SQESTOQUEPROD + ".NEXTVAL, ? ,? ,? ,? ,?  )";
            stmt = conexao.prepareStatement(sql);

            stmt.setLong(1, estoqueProduto.getEstoque().getIdEstoque());
            stmt.setLong(2, estoqueProduto.getProduto().getIdProduto());

            stmt.setLong(3, estoqueProduto.getQuantidadeEstoque());
            stmt.setDate(4, estoqueProduto.getDataEntrada());
            stmt.setDate(5, estoqueProduto.getDataFabricacao());
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
}