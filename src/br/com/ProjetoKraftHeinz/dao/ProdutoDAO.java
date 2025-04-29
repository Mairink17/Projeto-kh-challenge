package br.com.ProjetoKraftHeinz.dao;


import br.com.ProjetoKraftHeinz.beans.Categoria;
import br.com.ProjetoKraftHeinz.beans.Embalagem;
import br.com.ProjetoKraftHeinz.beans.Produto;
import br.com.ProjetoKraftHeinz.beans.TipoPeso;
import br.com.ProjetoKraftHeinz.jdbc.DbManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static br.com.ProjetoKraftHeinz.constantes.TabelaSistema.*;

public class ProdutoDAO {

    private Connection conexao;

    public void cadastrar(Produto produto){

        PreparedStatement stmt = null;
        int nResposta = 0;

        try {
            conexao = DbManager.getInstance().obterConexao();

            String sql = " INSERT INTO " + TABPRODUTO + "(ID_PRODUTO , NM_PRODUTO , NR_CUSTO , NR_PRECO, QT_VALIDADE_DIAS" +
                    ",NR_PESO, QT_PORCAO_COMPOSICAO, VL_ENERGETICO_PORCAO, DS_PRODUTO, DS_MARCA, FK_ID_PESO," +
                    "FK_ID_CATEGORIA ,FK_ID_EMBALAGEM ) VALUES " +
                    "( " + SQPRODUTO + ".NEXTVAL, ? ,? ,? ,? ,? , ? , ?, ?, ?, ?, ?, ? )";
            stmt = conexao.prepareStatement(sql);

            long idTipoPeso = produto.getTipoPeso().getIdTipoPeso();
            long idCategoria = produto.getCategoria().getIdCategoria();
            long idEmbalagem = produto.getEmbalagem().getIdEmbalagem();

            stmt.setString(1, produto.getNomeProduto());
            stmt.setDouble(2, produto.getValorCusto());
            stmt.setDouble(3, produto.getValorVenda());
            stmt.setInt(4, produto.getValidadeDias());
            stmt.setDouble(5, produto.getPeso());
            stmt.setInt(6, produto.getQuantidadePorcao());
            stmt.setInt(7, produto.getValorEnergetico());
            stmt.setString(8, produto.getDescricaoProduto());
            stmt.setString(9, produto.getDescricaoMarca());
            stmt.setLong(10, idTipoPeso);
            stmt.setLong(11, idCategoria );
            stmt.setLong(12, idEmbalagem);


            nResposta = stmt.executeUpdate();

            if (nResposta == 1){
                System.out.println("Produto inserido com sucesso...");
            }

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public List<Produto> getListaConsulta(){

        List<Produto> listaProduto = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{

            conexao = DbManager.getInstance().obterConexao();

            String sql = "SELECT * FROM " + TABPRODUTO + " ORDER BY ID_PRODUTO ";
            stmt = conexao.prepareStatement(sql );
            rs = stmt.executeQuery();
            while (rs.next()){
                int codigo = rs.getInt("ID_PRODUTO");
                String nomeProduto = rs.getString("NM_PRODUTO");
                String descricaoProduto = rs.getString("DS_PRODUTO");
                double valorCusto = rs.getDouble("NR_CUSTO");
                double valorPreco = rs.getDouble("NR_PRECO");
                int validadeDias = rs.getInt("QT_VALIDADE_DIAS");
                double peso = rs.getDouble("NR_PESO");
                int quantidadePorcao = rs.getInt("QT_PORCAO_COMPOSICAO");
                int valorEnergetico = rs.getInt("VL_ENERGETICO_PORCAO");
                String marca = rs.getString("DS_MARCA");

                long idCategoria = rs.getLong("FK_ID_CATEGORIA");
                long idEmbalagem = rs.getLong("FK_ID_EMBALAGEM");
                long idPeso = rs.getLong("FK_ID_PESO");



                Embalagem embalagem = new EmbalagemDAO().getConsulta(idEmbalagem);

                Categoria categoria = new CategoriaDAO().getConsulta(idCategoria);

                TipoPeso tipoPeso = new TipoPesoDAO().getConsulta(idPeso);


                Produto produto = new Produto(codigo, nomeProduto , valorCusto, valorPreco, validadeDias,
                        peso,quantidadePorcao,valorEnergetico,descricaoProduto ,marca ,tipoPeso,categoria,embalagem);
                listaProduto.add(produto);
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
        return listaProduto;
    }

    public Produto getConsulta(long idProduto){

        Produto produtoConsulta = new Produto();
        PreparedStatement stmt = null;

        ResultSet rs = null;

        try{

            conexao = DbManager.getInstance().obterConexao();

            stmt = conexao.prepareStatement("SELECT * FROM " + TABPRODUTO +" WHERE ID_PRODUTO = "
                    + idProduto);
            rs = stmt.executeQuery();

            while (rs.next()){
                int codigo = rs.getInt("ID_PRODUTO");
                String nomeProduto = rs.getString("NM_PRODUTO");

                String descricaoProduto = rs.getString("DS_PRODUTO");
                double valorCusto = rs.getDouble("NR_CUSTO");
                double valorPreco = rs.getDouble("NR_PRECO");
                int validadeDias = rs.getInt("QT_VALIDADE_DIAS");
                double peso = rs.getDouble("NR_PESO");
                int quantidadePorcao = rs.getInt("QT_PORCAO_COMPOSICAO");
                int valorEnergetico = rs.getInt("VL_ENERGETICO_PORCAO");
                String marca = rs.getString("DS_MARCA");
                long idCategoria = rs.getLong("FK_ID_CATEGORIA");
                long idEmbalagem = rs.getLong("FK_ID_EMBALAGEM");
                long idPeso = rs.getLong("FK_ID_PESO");

                Embalagem embalagem = new EmbalagemDAO().getConsulta(idEmbalagem);

                Categoria categoria = new CategoriaDAO().getConsulta(idCategoria);

                TipoPeso tipoPeso = new TipoPesoDAO().getConsulta(idPeso);


                Produto produto = new Produto(codigo, nomeProduto , valorCusto, valorPreco, validadeDias,
                        peso,quantidadePorcao,valorEnergetico,descricaoProduto ,marca , tipoPeso
                        ,categoria,embalagem);

                produtoConsulta = produto;
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

        return produtoConsulta;

    }

}

