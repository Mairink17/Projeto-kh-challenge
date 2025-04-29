package br.com.ProjetoKraftHeinz.dao;

import br.com.ProjetoKraftHeinz.beans.Nutriente;
import br.com.ProjetoKraftHeinz.jdbc.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static br.com.ProjetoKraftHeinz.constantes.TabelaSistema.*;


public class NutrienteDAO {
    private Connection conexao;

    public void cadastrar(Nutriente nutriente) {

        PreparedStatement stmt = null;

        try {
            Connection conexao = DbManager.getInstance().obterConexao();

            String sql = " INSERT INTO " + TABNUTRIENTE + "(ID_NUTRIENTE , DS_NUTRIENTE  ) VALUES " +
                    "( " + SQNUTRIENTE + ".NEXTVAL, ?  )";
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, nutriente.getDescricaoNutriente());

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

    public List<Nutriente> getListaConsulta(){

        List<Nutriente> lista = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{

            conexao = DbManager.getInstance().obterConexao();

            String sql = "SELECT * FROM " + TABNUTRIENTE + " ORDER BY ID_NUTRIENTE ";
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                int codigo = rs.getInt("ID_NUTRIENTE");
                String descricaoNutriente = rs.getString("DS_NUTRIENTE");

                Nutriente nutriente = new Nutriente(codigo, descricaoNutriente );
                lista.add(nutriente);

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

    public Nutriente getConsulta(long idNutriente){

        Nutriente nutrienteConsulta = new Nutriente();
        PreparedStatement stmt = null;

        ResultSet rs = null;

        try{

            conexao = DbManager.getInstance().obterConexao();

            stmt = conexao.prepareStatement("SELECT * FROM " + TABNUTRIENTE +" WHERE ID_NUTRIENTE = "
                    + idNutriente);
            rs = stmt.executeQuery();
            while (rs.next()){
                int codigo = rs.getInt("ID_NUTRIENTE");
                String descricaoNutriente = rs.getString("DS_NUTRIENTE");


                Nutriente nutriente = new Nutriente(codigo, descricaoNutriente );
                nutrienteConsulta = nutriente;
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
        return nutrienteConsulta;
    }
}
