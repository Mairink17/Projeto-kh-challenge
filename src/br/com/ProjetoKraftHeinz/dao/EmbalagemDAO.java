package br.com.ProjetoKraftHeinz.dao;

import br.com.ProjetoKraftHeinz.beans.Embalagem;
import br.com.ProjetoKraftHeinz.beans.Fornecedor;
import br.com.ProjetoKraftHeinz.jdbc.DbManager;
import br.com.ProjetoKraftHeinz.utils.ConverteData;
import br.com.ProjetoKraftHeinz.utils.Formatacao;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static br.com.ProjetoKraftHeinz.constantes.TabelaSistema.*;


public class EmbalagemDAO {

    private Connection conexao;

    public void cadastrar(Embalagem embalagem) {

        PreparedStatement stmt = null;

        try {
            Connection conexao = DbManager.getInstance().obterConexao();

            String sql = " INSERT INTO " + TABEMBALAGEM + "(ID_EMBALAGEM , DS_EMBALAGEM , NR_ALTURA , NR_LARGURA ,NR_COMPRIMENTO" +
                    " ,DS_FORMATO, TX_MATERIAL , LG_REUTILIZAVEL, FK_ID_FORNECEDOR ) VALUES " +
                    "( " + SQEMBALAGEM + ".NEXTVAL, ? , ? , ? , ?, ? , ? , ? , ? )";
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, embalagem.getDsEmbalagem());
            stmt.setDouble(2,embalagem.getAltura() );
            stmt.setDouble(3, embalagem.getLargura());
            stmt.setDouble(4,embalagem.getComprimento());
            stmt.setString(5, embalagem.getFormato());
            stmt.setString(6,embalagem.getMaterial());
            stmt.setBoolean(7,embalagem.isReutilizavel());
            stmt.setLong(8,embalagem.getFornecedor().getIdFornecedor());

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

    public List<Embalagem> getListaConsulta(){

        List<Embalagem> listaEmbalagem = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{

            conexao = DbManager.getInstance().obterConexao();

            String sql = "SELECT * FROM " + TABEMBALAGEM + " ORDER BY ID_EMBALAGEM ";
            stmt = conexao.prepareStatement(sql );
            rs = stmt.executeQuery();

            while (rs.next()){
                int codigo = rs.getInt("ID_EMBALAGEM");
                String descricaoEmbalagem = rs.getString("DS_EMBALAGEM");
                double altura = rs.getDouble("NR_ALTURA");
                double largura = rs.getDouble("NR_LARGURA");
                double comprimento = rs.getDouble("NR_COMPRIMENTO");
                String formato = rs.getString("DS_FORMATO");
                String material = rs.getString("TX_MATERIAL");
                long idFornecedor = rs.getLong("FK_ID_FORNECEDOR");

                //Fornecedor fornecedor = new FornecedorDAO().getConsulta(idFornecedor);
                Embalagem embalagem = new Embalagem(codigo, descricaoEmbalagem ,altura,largura,comprimento,formato,material);
                listaEmbalagem.add(embalagem);
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
        return listaEmbalagem;
    }



    public Embalagem getConsulta(long idEmbalagem){

        Embalagem embalagemConsulta = new Embalagem();
        PreparedStatement stmt = null;

        ResultSet rs = null;

        try{
            conexao = DbManager.getInstance().obterConexao();

            stmt = conexao.prepareStatement("SELECT * FROM " + TABEMBALAGEM +" WHERE ID_EMBALAGEM= "
                    + idEmbalagem);
            rs = stmt.executeQuery();
            while (rs.next()){
                int codigo = rs.getInt("ID_EMBALAGEM");
                String descricaoEmbalagem = rs.getString("DS_EMBALAGEM");
                double altura = rs.getDouble("NR_ALTURA");
                double largura = rs.getDouble("NR_LARGURA");
                double comprimento = rs.getDouble("NR_COMPRIMENTO");
                String descricaoFormato = rs.getString("DS_FORMATO");
                String descricaoMaterial = rs.getString("TX_MATERIAL");
                long idFornecedor = rs.getLong("FK_ID_FORNECEDOR");

                //Fornecedor fornecedor = new FornecedorDAO().getConsulta(idFornecedor);

                Embalagem embalagem = new Embalagem(codigo, descricaoEmbalagem ,altura,largura,comprimento,
                        descricaoFormato,descricaoMaterial);
                embalagemConsulta= embalagem;
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
        return embalagemConsulta;
    }

    public String getRelatorioNaoReutilizavel(){

        String relatorio = "";
        int tamanhoFornecedor = 0;
        int tamanhoCidade = 0;
        int tamanhoEstado = 0;
        int tamanhoPais = 0;
        int tamanhoEmbalagem = 0;
        int tamanhoFormato = 0;
        int tamanhoMaterial = 0;
        int tamanhoTracos = 85;

        PreparedStatement stmt = null;
        ResultSet rs = null;
        int passada = 0;
        String quantidadeTraco = "";
        int tamanhoCabecalho = 0;

        try{

            conexao = DbManager.getInstance().obterConexao();

            String sql = " SELECT DS_EMBALAGEM,(SELECT MAX(LENGTH(DS_EMBALAGEM)) FROM T_EMBALAGEM ) AS TAM_EMBALAGEM, " +
                    " DS_FORMATO,(SELECT MAX(LENGTH(DS_FORMATO)) FROM T_EMBALAGEM ) AS TAM_FORMA, TX_MATERIAL , " +
                    " (SELECT MAX(LENGTH(TX_MATERIAL)) FROM T_EMBALAGEM ) AS TAM_MATERIAL, " +
                   " CASE WHEN LG_REUTILIZAVEL=1 THEN 'REUTILIZAVEL' ELSE 'NÃO REUTILIZAVEL' END AS REUTILIZA, " +
                    " DS_FORNECEDOR,(SELECT MAX(LENGTH(DS_FORNECEDOR)) FROM T_FORNECEDOR ) AS TAM_FORN " +
                    " ,TX_CNPJ,DT_INICIO,DS_CIDADE,(SELECT MAX(LENGTH(DS_CIDADE)) FROM T_CIDADE ) " +
                    " AS TAM_CIDADE,DS_ESTADO,(SELECT MAX(LENGTH(DS_ESTADO)) FROM T_ESTADO ) AS TAM_ESTADO, " +
                    " DS_PAIS,(SELECT MAX(LENGTH(DS_PAIS)) FROM T_PAIS ) AS TAM_PAIS " +
                    " FROM T_EMBALAGEM " +
                    " INNER JOIN T_FORNECEDOR ON FK_ID_FORNECEDOR=ID_FORNECEDOR " +
                    " INNER JOIN T_CIDADE ON FK_ID_CIDADE = ID_CIDADE " +
                    " INNER JOIN T_ESTADO ON FK_ID_ESTADO=ID_ESTADO " +
                    " INNER JOIN T_PAIS ON FK_ID_PAIS=ID_PAIS " +
                    " WHERE LG_REUTILIZAVEL = 0 "  ;

            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();


            while (rs.next()){

                if (passada == 0){
                    tamanhoFornecedor =  rs.getInt("TAM_FORN");
                    tamanhoFornecedor = tamanhoFornecedor + 4;
                    tamanhoCidade = rs.getInt("TAM_CIDADE");
                    tamanhoCidade = tamanhoCidade + 4;
                    tamanhoEstado = rs.getInt("TAM_ESTADO");
                    tamanhoEstado = tamanhoEstado + 4 ;
                    tamanhoPais = rs.getInt("TAM_PAIS");
                    tamanhoPais = tamanhoPais + 4 ;


                    tamanhoEmbalagem = rs.getInt("TAM_EMBALAGEM");
                    tamanhoEmbalagem = tamanhoEmbalagem + 4 ;
                    tamanhoFormato = rs.getInt("TAM_FORMA");
                    tamanhoFormato = tamanhoFormato + 4 ;
                    tamanhoMaterial = rs.getInt("TAM_MATERIAL");
                    tamanhoMaterial = tamanhoMaterial + 4 ;

                    relatorio += ("\n");
                    tamanhoCabecalho = (" Relatório Auditoria ").length();
                    quantidadeTraco = "";
                    for(int i = 0; i <= (tamanhoTracos + (tamanhoCabecalho / 2 )) ; i++) {
                        quantidadeTraco += "=";
                    }
                    relatorio += quantidadeTraco + quantidadeTraco;

                    quantidadeTraco = "";
                    for(int i = 0; i <= tamanhoTracos; i++) {
                        quantidadeTraco += "=";
                    }

                    relatorio += ("\n");
                    relatorio += quantidadeTraco +   " Relatório de embalagens não reutilizáveis " + quantidadeTraco;
                    relatorio += ("\n");
                    relatorio +=   String.format("%-" + tamanhoEmbalagem + "s", "Embalagem") +
                            String.format("%-" + tamanhoFormato + "s", "Formato") + String.format("%-" + tamanhoMaterial + "s", "Material") +
                            String.format("%-20s", "Reutiliza ?") + String.format("%-" + tamanhoFornecedor + "s", "Fornecedor") +
                            String.format("%-22s", "Cnpj")  + String.format("%-15s", "Data Início") +
                            String.format("%-" + tamanhoCidade + "s", "Cidade") + String.format("%-" + tamanhoEstado + "s", "Estado") +
                            String.format("%-" + tamanhoPais + "s", "País")  ;
                    relatorio += ("\n");
                }

                passada++;
                String nomeFornecedor = rs.getString("DS_FORNECEDOR");
                String cnpj = rs.getString("TX_CNPJ");
                Date dataInicio =  rs.getDate("DT_INICIO");
                String cidade = rs.getString("DS_CIDADE");
                String estado = rs.getString("DS_ESTADO");
                String pais = rs.getString("DS_PAIS");
                String embalagem = rs.getString("DS_EMBALAGEM");
                String formato = rs.getString("DS_FORMATO");
                String material = rs.getString("TX_MATERIAL");
                String reutiliza = rs.getString("REUTILIZA");




                relatorio +=  String.format("%-" + tamanhoEmbalagem + "s", embalagem) +
                        String.format("%-" + tamanhoFormato + "s", formato) + String.format("%-" + tamanhoMaterial + "s", material) +
                        String.format("%-20s", reutiliza) +
                        String.format("%-" + tamanhoFornecedor + "s", nomeFornecedor) +  String.format("%-22s", Formatacao.formataCnpj(cnpj) )  +
                        String.format("%-15s", ConverteData.convertFromJAVADateToSQLDate(dataInicio) ) +
                        String.format("%-" + tamanhoCidade + "s", cidade) + String.format("%-" + tamanhoEstado + "s", estado) +
                        String.format("%-" + tamanhoPais + "s", pais)  ;
                relatorio += ("\n");


            }
            quantidadeTraco = "";
            tamanhoCabecalho = tamanhoCabecalho - " Final do relatório ".length();
            for(int i = 0; i <= (tamanhoTracos + ( tamanhoCabecalho  / 2) + 1 ); i++) {
                quantidadeTraco += "=";
            }
            if (passada > 0){
                relatorio +=  quantidadeTraco +  " Final do relatório " + quantidadeTraco;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally{
            try{
                stmt.close();
                rs.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return relatorio;
    }


}