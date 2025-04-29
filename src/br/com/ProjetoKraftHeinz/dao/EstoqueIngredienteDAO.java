package br.com.ProjetoKraftHeinz.dao;

import br.com.ProjetoKraftHeinz.beans.EstoqueIngrediente;
import br.com.ProjetoKraftHeinz.jdbc.DbManager;

import java.sql.*;

import static br.com.ProjetoKraftHeinz.constantes.TabelaSistema.SQESTOQUEINGR;
import static br.com.ProjetoKraftHeinz.constantes.TabelaSistema.TABESTOQUEINGR;

public class EstoqueIngredienteDAO {

    private Connection conexao;

    public void entradaEstoque(EstoqueIngrediente estoqueIngrediente) {

        PreparedStatement stmt = null;

        try {
            conexao = DbManager.getInstance().obterConexao();

            String sql = " INSERT INTO " + TABESTOQUEINGR + "(ID_ESTOQUE_INGREDIENTE , QT_ESTOQUE , DT_VALIDADE , " +
                    "FK_PK_ID_ESTOQUE, FK_PK_ID_INGREDIENTE ) VALUES " +
                    "( " + SQESTOQUEINGR + ".NEXTVAL, ? ,? ,? ,?  )";
            stmt = conexao.prepareStatement(sql);

            stmt.setLong(1, estoqueIngrediente.getQuantidadeEstoque());
            stmt.setDate(2, estoqueIngrediente.getDataValidade());
            stmt.setLong(3, estoqueIngrediente.getIngrediente().getIngrediente());
            stmt.setLong(4, estoqueIngrediente.getEstoque().getIdEstoque());

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