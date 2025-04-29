package br.com.ProjetoKraftHeinz.dao;

import br.com.ProjetoKraftHeinz.beans.Fabrica;
import br.com.ProjetoKraftHeinz.jdbc.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static br.com.ProjetoKraftHeinz.constantes.TabelaSistema.SQFABRICA;
import static br.com.ProjetoKraftHeinz.constantes.TabelaSistema.TABFABRICA;

public class FabricaDAO {

    private Connection conexao ;

    public void cadastrarFabrica(Fabrica fabrica) {

        PreparedStatement stmt = null;

        try {
            conexao = DbManager.getInstance().obterConexao();

            String sql = " INSERT INTO " + TABFABRICA + "(ID_FABRICA, DS_FABRICA, TX_CNPJ, TX_RAZAO_SOCIAL, TX_CEP," +
                    "TX_LOGRADOURO, FK_ID_CIDADE ) VALUES ( " + SQFABRICA + ".NEXTVAL, ? , ? , ? , ? , ? , ? )";
            stmt = conexao.prepareStatement(sql);

            long idCidade = fabrica.getCidade().getCodigo();

            stmt.setString(1 , fabrica.getDescricaoFabrica());
            stmt.setString(2 , fabrica.getCodigoCnpj());
            stmt.setString(3 , fabrica.getRazaoSocial());
            stmt.setString(4 , fabrica.getCep());
            stmt.setString(5 , fabrica.getLogradouro());
            stmt.setLong(6  , idCidade );

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                stmt.close();
                conexao.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }




    }

}
