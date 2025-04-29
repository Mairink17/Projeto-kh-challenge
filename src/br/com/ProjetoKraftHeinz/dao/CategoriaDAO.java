package br.com.ProjetoKraftHeinz.dao;

import br.com.ProjetoKraftHeinz.beans.Categoria;
import br.com.ProjetoKraftHeinz.jdbc.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static br.com.ProjetoKraftHeinz.constantes.TabelaSistema.*;

public class CategoriaDAO {

    private Connection conexao;

    public void cadastrar(Categoria categoria){

        PreparedStatement stmt = null;

        try {
            conexao = DbManager.getInstance().obterConexao();

            String sql = " INSERT INTO " + TABCATEGORIA + "(ID_CATEGORIA , DS_CATEGORIA)  VALUES " +
                    "( " + SQCATEGORIA + ".NEXTVAL , ? )";
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, categoria.getDescricaoCategoria());
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

    public List<Categoria> getListaConsulta(){

        List<Categoria> listaCategoria = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{

            conexao = DbManager.getInstance().obterConexao();

            String sql = "SELECT * FROM " + TABCATEGORIA + " ORDER BY ID_CATEGORIA ";
            stmt = conexao.prepareStatement(sql );
            rs = stmt.executeQuery();
            while (rs.next()){
                int codigo = rs.getInt("ID_CATEGORIA");
                String descricaoCategoria = rs.getString("DS_CATEGORIA");
                Categoria categoria = new Categoria(codigo, descricaoCategoria );
                listaCategoria.add(categoria);
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
        return listaCategoria;
    }

    public Categoria getConsulta(long idCategoria){

        Categoria categoriaConsulta = new Categoria();
        PreparedStatement stmt = null;

        ResultSet rs = null;

        try{
            conexao = DbManager.getInstance().obterConexao();

            stmt = conexao.prepareStatement("SELECT * FROM " + TABCATEGORIA +" WHERE ID_CATEGORIA= "
                    + idCategoria);
            rs = stmt.executeQuery();
            while (rs.next()){
                int codigo = rs.getInt("ID_CATEGORIA");
                String descricaoCategoria = rs.getString("DS_CATEGORIA");


                Categoria categoria = new Categoria(codigo, descricaoCategoria );
                categoriaConsulta= categoria;
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
        return categoriaConsulta;
    }
}

