package br.com.ProjetoKraftHeinz.dao;

import br.com.ProjetoKraftHeinz.beans.FornecedorAuditoria;
import br.com.ProjetoKraftHeinz.jdbc.DbManager;
import br.com.ProjetoKraftHeinz.utils.ConverteData;
import br.com.ProjetoKraftHeinz.utils.Formatacao;

import java.sql.*;
import java.text.ParseException;

import static br.com.ProjetoKraftHeinz.constantes.TabelaSistema.SQFORNAUDIT;
import static br.com.ProjetoKraftHeinz.constantes.TabelaSistema.TABFORNAUDIT;

public class FornecedorAuditoriaDAO {

    private Connection conexao;


    public void lancarAuditoria(FornecedorAuditoria fornecedorAuditoria) {

        PreparedStatement stmt = null;

        try {
            conexao = DbManager.getInstance().obterConexao();

            String sql = " INSERT INTO " + TABFORNAUDIT + "(ID_AUDITORIA , DS_AUDITORIA , DT_AUDITORIA , LG_RESULTADO, TX_LAUDO" +
                    ", NM_RESPONSAVEL , FK_ID_FORNECEDOR) VALUES " +
                    "( " + SQFORNAUDIT + ".NEXTVAL, ? ,? ,? ,? ,? , ? )";
            stmt = conexao.prepareStatement(sql);

            stmt.setString(1, fornecedorAuditoria.getDescricaoAuditoria());
            stmt.setDate(2, fornecedorAuditoria.getDataAuditoria());
            stmt.setBoolean(3, fornecedorAuditoria.isResultado());
            stmt.setString(4, fornecedorAuditoria.getLaudo());
            stmt.setString(5, fornecedorAuditoria.getNomeResponsavel());
            stmt.setLong(6, fornecedorAuditoria.getFornecedor().getIdFornecedor());

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



    public String getRelatorioAuditoria(int tipoOrdenacao,int dataFiltro){

        String relatorio = "";
        int tamanhoFornecedor = 0;
        int tamanhoAuditoria = 0;
        int tamanhoCidade = 0;
        int tamanhoEstado = 0;
        int tamanhoPais = 0;
        int tamanhoResponsavel = 0;
        int tamanhoTracos = 85;

        PreparedStatement stmt = null;
        ResultSet rs = null;
        int passada = 0;
        String quantidadeTraco = "";
        int tamanhoCabecalho = 0;

        //banco oracle da Fiap utilizando apenas ano com 2 digitos
        if(String.valueOf(dataFiltro).length() > 2){
            dataFiltro = Integer.parseInt(String.valueOf(dataFiltro).substring(2, 4));
        }


        try{

            conexao = DbManager.getInstance().obterConexao();

            String sql = " SELECT DS_FORNECEDOR,(SELECT MAX(LENGTH(DS_FORNECEDOR)) FROM T_FORNECEDOR ) AS TAM_FORNECEDOR " +
                " ,TX_CNPJ,DT_INICIO,DS_CIDADE,(SELECT MAX(LENGTH(DS_CIDADE)) FROM T_CIDADE ) " +
            " AS TAM_CIDADE,DS_ESTADO,(SELECT MAX(LENGTH(DS_ESTADO)) FROM T_ESTADO ) AS TAM_ESTADO, " +
            " DS_PAIS,(SELECT MAX(LENGTH(DS_PAIS)) FROM T_PAIS ) AS TAM_PAIS, " +
            " DS_AUDITORIA,(SELECT MAX(LENGTH(DS_AUDITORIA)) FROM T_FORN_AUDITORIA ) AS TAM_AUDIT, " +
             "       DT_AUDITORIA, " +
            " NM_RESPONSAVEL,(SELECT MAX(LENGTH(NM_RESPONSAVEL)) FROM T_FORN_AUDITORIA ) AS TAM_RESPONSA, " +
            " CASE WHEN LG_RESULTADO=1 THEN 'APROVADO' ELSE 'REPROVADO' END AS RESULTADO " +
            "  FROM T_FORN_AUDITORIA " +
            " INNER JOIN T_FORNECEDOR ON FK_ID_FORNECEDOR=ID_FORNECEDOR " +
            " INNER JOIN T_CIDADE ON FK_ID_CIDADE = ID_CIDADE " +
            " INNER JOIN T_ESTADO ON FK_ID_ESTADO=ID_ESTADO " +
            " INNER JOIN T_PAIS ON FK_ID_PAIS=ID_PAIS " ;
            if (tipoOrdenacao == 0){
               sql += " WHERE TO_CHAR(DT_AUDITORIA,'YY') = '" + dataFiltro + "' " ;
            }
            sql += " ORDER BY LG_RESULTADO,DT_AUDITORIA " ;


            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();


            while (rs.next()){

                if (passada == 0){
                    tamanhoFornecedor =  rs.getInt("TAM_FORNECEDOR");
                    tamanhoFornecedor = tamanhoFornecedor + 4;
                    tamanhoCidade = rs.getInt("TAM_CIDADE");
                    tamanhoCidade = tamanhoCidade + 4;
                    tamanhoEstado = rs.getInt("TAM_ESTADO");
                    tamanhoEstado = tamanhoEstado + 4 ;
                    tamanhoPais = rs.getInt("TAM_PAIS");
                    tamanhoPais = tamanhoPais + 4 ;
                    tamanhoResponsavel = rs.getInt("TAM_RESPONSA");
                    tamanhoResponsavel = tamanhoResponsavel + 4 ;
                    tamanhoAuditoria = rs.getInt("TAM_AUDIT");
                    tamanhoAuditoria = tamanhoAuditoria + 4 ;

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
                    relatorio += quantidadeTraco +   " Relatório Auditoria " + quantidadeTraco;
                    relatorio += ("\n");
                    relatorio +=  String.format("%-" + tamanhoFornecedor + "s", "Fornecedor") +  String.format("%-22s", "Cnpj")  +
                              String.format("%-15s", "Data Início") +
                    String.format("%-" + tamanhoCidade + "s", "Cidade") + String.format("%-" + tamanhoEstado + "s", "Estado") +
                            String.format("%-" + tamanhoPais + "s", "País") + String.format("%-" + tamanhoAuditoria + "s", "Descrição Auditoria") +
                            String.format("%-17s", "Data Auditoria") +
                            String.format("%-" + tamanhoResponsavel + "s", "Responsável") +
                            String.format("%-12s", "Resultado")  ;
                    relatorio += ("\n");
                }

                passada++;
                String nomeFornecedor = rs.getString("DS_FORNECEDOR");
                String cnpj = rs.getString("TX_CNPJ");
                Date dataInicio =  rs.getDate("DT_INICIO");
                String cidade = rs.getString("DS_CIDADE");
                String estado = rs.getString("DS_ESTADO");
                String pais = rs.getString("DS_PAIS");
                String auditoria = rs.getString("DS_AUDITORIA");
                Date dataAuditoria =  rs.getDate("DT_AUDITORIA");
                String responsavel = rs.getString("NM_RESPONSAVEL");
                String resultado = rs.getString("RESULTADO");


                relatorio +=  String.format("%-" + tamanhoFornecedor + "s", nomeFornecedor) +  String.format("%-22s", Formatacao.formataCnpj(cnpj) )  +
                        String.format("%-15s", ConverteData.convertFromJAVADateToSQLDate(dataInicio) ) +
                        String.format("%-" + tamanhoCidade + "s", cidade) + String.format("%-" + tamanhoEstado + "s", estado) +
                        String.format("%-" + tamanhoPais + "s", pais) + String.format("%-" + tamanhoAuditoria + "s", auditoria) +
                        String.format("%-17s", ConverteData.convertFromJAVADateToSQLDate(dataAuditoria) ) +
                        String.format("%-" + tamanhoResponsavel + "s", responsavel) +
                        String.format("%-12s", resultado)  ;
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
