package br.com.ProjetoKraftHeinz.dao;

import br.com.ProjetoKraftHeinz.beans.TipoPeso;
import br.com.ProjetoKraftHeinz.jdbc.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static br.com.ProjetoKraftHeinz.constantes.TabelaSistema.*;


public class TipoPesoDAO {

    private Connection conexao;

    public void cadastrar(TipoPeso tipoPeso) {

        PreparedStatement stmt = null;

        try {
            Connection conexao = DbManager.getInstance().obterConexao();

            String sql = " INSERT INTO " + TABTIPOPESO + "(ID_PESO , DS_PESO  ) VALUES " +
                    "( " + SQTIPOPESO + ".NEXTVAL, ?  )";
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, tipoPeso.getDescricaoTipoPeso());

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

    public List<TipoPeso> getListaConsulta(){

        List<TipoPeso> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{

            conexao = DbManager.getInstance().obterConexao();

            String sql = "SELECT * FROM " + TABTIPOPESO + " ORDER BY ID_PESO ";
            stmt = conexao.prepareStatement(sql );
            rs = stmt.executeQuery();
            while (rs.next()){
                int codigo = rs.getInt("ID_PESO");
                String descricaoTipoPeso = rs.getString("DS_PESO");
                TipoPeso tipoPeso = new TipoPeso(codigo, descricaoTipoPeso );
                lista.add(tipoPeso);
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
        return lista;
    }

    public TipoPeso getConsulta(long idPeso){

        TipoPeso tipoPesoConsulta = new TipoPeso();
        PreparedStatement stmt = null;

        ResultSet rs = null;

        try{

            conexao = DbManager.getInstance().obterConexao();

            stmt = conexao.prepareStatement("SELECT * FROM " + TABTIPOPESO +" WHERE ID_PESO= "
                    + idPeso);
            rs = stmt.executeQuery();
            while (rs.next()){
                int codigo = rs.getInt("ID_PESO");
                String descricaoTipoPeso = rs.getString("DS_PESO");


                TipoPeso tipoPeso = new TipoPeso(codigo, descricaoTipoPeso );
                tipoPesoConsulta = tipoPeso;
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
        return tipoPesoConsulta;
    }
}
