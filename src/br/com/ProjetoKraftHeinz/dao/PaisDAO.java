package br.com.ProjetoKraftHeinz.dao;

import br.com.ProjetoKraftHeinz.beans.Pais;
import br.com.ProjetoKraftHeinz.jdbc.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static br.com.ProjetoKraftHeinz.constantes.TabelaSistema.*;

public class PaisDAO {

    private Connection conexao;

    public void cadastrar(Pais pais) {

        PreparedStatement stmt = null;

        try {
            conexao = DbManager.getInstance().obterConexao();

            String sql = " INSERT INTO " + TABPAIS + "(ID_PAIS , DS_PAIS , DS_CONTINENTE ) VALUES " +
                    "( " + SQPAIS + ".NEXTVAL, ? , ? )";
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, pais.getDescricaoPais());
            stmt.setString(2, pais.getDescricaoContinente());


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


    public Pais getConsulta(long idPais){

        Pais paisConsulta = new Pais();
        PreparedStatement stmt = null;

        ResultSet rs = null;

        try{
            conexao = DbManager.getInstance().obterConexao();

            stmt = conexao.prepareStatement("SELECT * FROM " + TABPAIS +" WHERE ID_PAIS= "
                    + idPais);
            rs = stmt.executeQuery();

            while (rs.next()){
                int codigo = rs.getInt("ID_PAIS");
                String descricaoPais = rs.getString("DS_PAIS");
                String descricaoContinente = rs.getString("DS_CONTINENTE");


                Pais pais = new Pais(codigo, descricaoPais,descricaoContinente );
                paisConsulta  = pais;
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
        return paisConsulta;
    }
}
