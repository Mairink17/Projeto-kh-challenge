package br.com.ProjetoKraftHeinz.dao;

import br.com.ProjetoKraftHeinz.beans.EstoqueEmbalagem;
import br.com.ProjetoKraftHeinz.jdbc.DbManager;

import java.sql.*;

import static br.com.ProjetoKraftHeinz.constantes.TabelaSistema.TABESTOQUEEMB;

public class EstoqueEmbalagemDAO {

    private Connection conexao;

    public void entradaEstoque(EstoqueEmbalagem estoqueEmbalagem) {

        PreparedStatement stmt = null;

        try {
            conexao = DbManager.getInstance().obterConexao();

            String sql = " INSERT INTO " + TABESTOQUEEMB + "(FK_PK_ID_ESTOQUE , FK_PK_ID_EMBALAGEM , QT_ESTOQUE ) VALUES " +
                    "( ? , ? , ? )";
            stmt = conexao.prepareStatement(sql);

            stmt.setLong(1, estoqueEmbalagem.getEstoque().getIdEstoque());
            stmt.setLong(2, estoqueEmbalagem.getEmbalagem().getIdEmbalagem());
            stmt.setLong(3, estoqueEmbalagem.getQuantidadeEstoque());

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