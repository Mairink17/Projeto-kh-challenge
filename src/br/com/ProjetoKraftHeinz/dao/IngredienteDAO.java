package br.com.ProjetoKraftHeinz.dao;


import br.com.ProjetoKraftHeinz.beans.Ingrediente;
import br.com.ProjetoKraftHeinz.jdbc.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static br.com.ProjetoKraftHeinz.constantes.TabelaSistema.*;


public class IngredienteDAO {

    private Connection conexao;

    public void cadastrar(Ingrediente ingrediente) {

        PreparedStatement stmt = null;

        try {
            Connection conexao = DbManager.getInstance().obterConexao();

            String sql = " INSERT INTO " + TABINGREDIENTE + "(ID_INGREDIENTE , DS_INGREDIENTE , " +
                    "FK_ID_FORNECEDOR, FK_ID_TIPO_INGREDIENTE  ) VALUES " +
                    "( " + SQINGREDIENTE + ".NEXTVAL, ? , ? , ?  )";
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, ingrediente.getDescricaoIngrediente());
            stmt.setLong(2,ingrediente.getFornecedor().getIdFornecedor() );
            stmt.setLong(3,ingrediente.getTipoIngrediente().getIdTipoIngrediente());

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

    public Ingrediente getConsulta(long idIngrediente){

        Ingrediente ingredienteConsulta = new Ingrediente();
        PreparedStatement stmt = null;

        ResultSet rs = null;

        try{

            conexao = DbManager.getInstance().obterConexao();

            stmt = conexao.prepareStatement("SELECT * FROM " + TABINGREDIENTE +" WHERE ID_INGREDIENTE = "
                    + idIngrediente);
            rs = stmt.executeQuery();
            while (rs.next()){
                long codigo = rs.getLong("ID_INGREDIENTE");
                String descricaoIngrediente = rs.getString("DS_INGREDIENTE");
                long idFornecedor = rs.getLong("FK_ID_FORNECEDOR");
                long idTipoIngrediente = rs.getLong("FK_ID_TIPO_INGREDIENTE");


                Ingrediente ingrediente = new Ingrediente(codigo, descricaoIngrediente , new FornecedorDAO().getConsulta(idFornecedor),
                        new TipoIngredienteDAO().getConsulta(idTipoIngrediente));
                ingredienteConsulta = ingrediente;
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

        return ingredienteConsulta;

    }
}
