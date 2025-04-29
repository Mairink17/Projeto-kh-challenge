package br.com.ProjetoKraftHeinz.dao;

import br.com.ProjetoKraftHeinz.beans.ComposicaoNutricional;
import br.com.ProjetoKraftHeinz.beans.Nutriente;
import br.com.ProjetoKraftHeinz.jdbc.DbManager;
import java.sql.*;
import static br.com.ProjetoKraftHeinz.constantes.TabelaSistema.*;


public class ComposicaoNutricionalDAO {


    private Connection conexao;

    public void cadastrar(ComposicaoNutricional composicaoNutricional) {

        PreparedStatement stmt = null;
        int nResposta = 0;

        try {
            conexao = DbManager.getInstance().obterConexao();

            String sql = " INSERT INTO " + TABCOMPNUTRI + "(ID_COMPOSICAO , NR_PESO_COMP,NR_PERCENTUAL_DIARIO, FK_ID_PRODUTO, FK_ID_NUTRIENTE, FK_ID_PESO  ) VALUES " +
                    "( " + SQCOMPNUTRI + ".NEXTVAL, ? , ? , ? , ? , ? )";
            stmt = conexao.prepareStatement(sql);

            stmt.setDouble(1, composicaoNutricional.getPeso());
            stmt.setDouble(2, composicaoNutricional.getPercentualDiario());
            stmt.setLong(3, composicaoNutricional.getProduto().getIdProduto());
            stmt.setLong(4, composicaoNutricional.getNutriente().getIdNutriente());
            stmt.setLong(5, composicaoNutricional.getTipoPeso().getIdTipoPeso());

            nResposta = stmt.executeUpdate();
            if (nResposta == 1){
                System.out.println("Composição inserida com sucesso...");
            }

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


    public String getRelatorioComposicao(Nutriente nutriente){

        String relatorio = "";
        int tamanhoProduto = 0;
        int tamanhoMarca = 0;
        int tamanhoNutriente = 0;
        int tamanhoPeso = 0;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int passada = 0;
        String quantidadeTraco = "";
        int tamanhoCabecalho = 0;


        try{

            conexao = DbManager.getInstance().obterConexao();

            String sql = "SELECT NM_PRODUTO,(SELECT MAX(LENGTH(NM_PRODUTO)) FROM T_PRODUTO) AS TAM_PRODUTO, " +
                    " DS_MARCA,(SELECT MAX(LENGTH(DS_MARCA)) FROM T_PRODUTO)AS TAM_MARCA,QT_PORCAO_COMPOSICAO AS PORCAO," +
                    "VL_ENERGETICO_PORCAO AS VALOR_ENERGETICO,NR_PESO_COMP,NR_PERCENTUAL_DIARIO, " +
                    " DS_NUTRIENTE,(SELECT MAX(LENGTH(DS_NUTRIENTE)) FROM T_NUTRIENTE)AS TAM_NUTRI, PESO.DS_PESO AS PESO_NUTRIENTE," +
                    "(SELECT MAX(LENGTH(DS_PESO)) FROM T_TIPO_PESO) AS TAM_PESO FROM T_PRODUTO PRD " +
            " INNER JOIN T_COMPOSICAO_NUTRI NUTRI ON NUTRI.FK_ID_PRODUTO=PRD.ID_PRODUTO " +
            " INNER JOIN T_NUTRIENTE NUTRI2 ON NUTRI.FK_ID_NUTRIENTE=NUTRI2.ID_NUTRIENTE " +
            " INNER JOIN T_TIPO_PESO PESO2 ON PRD.FK_ID_PESO = PESO2.ID_PESO " +
            " INNER JOIN T_TIPO_PESO PESO ON NUTRI.FK_ID_PESO = PESO.ID_PESO " +
                    "WHERE ID_NUTRIENTE="  + nutriente.getIdNutriente()  +
                    "ORDER BY NR_PESO_COMP DESC ";

            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();


            while (rs.next()){

                if (passada == 0){
                    tamanhoProduto =  rs.getInt("TAM_PRODUTO");
                    tamanhoProduto = tamanhoProduto + 4;
                    tamanhoMarca = rs.getInt("TAM_MARCA");
                    tamanhoMarca = tamanhoMarca + 4;
                    tamanhoNutriente = rs.getInt("TAM_NUTRI"); ;
                    tamanhoNutriente = tamanhoNutriente + 4 ;
                    tamanhoPeso = rs.getInt("TAM_PESO"); ;
                    tamanhoPeso = tamanhoPeso + 4 ;

                    relatorio += ("\n");
                    tamanhoCabecalho = (" Relatório Avaliação Nutricional (" + nutriente.getDescricaoNutriente()+") ").length();
                    quantidadeTraco = "";
                    for(int i = 0; i <= (60 + (tamanhoCabecalho / 2 )) ; i++) {
                        quantidadeTraco += "=";
                    }
                    relatorio += quantidadeTraco + quantidadeTraco;

                    quantidadeTraco = "";
                    for(int i = 0; i <= 60; i++) {
                        quantidadeTraco += "=";
                    }

                    relatorio += ("\n");
                    relatorio += quantidadeTraco +   " Relatório Avaliação Nutricional (" + nutriente.getDescricaoNutriente()+") " + quantidadeTraco;
                    relatorio += ("\n");
                    relatorio +=  String.format("%-" + tamanhoProduto + "s", "Nome Produto") + String.format("%-" + tamanhoMarca + "s", "Marca")
                            + String.format("%-10s", "Porção") +
                            String.format("%-20s", "Valor Energético")    + String.format("%-" + tamanhoNutriente + "s", "Nutriente")  +
                            String.format("%-10s", "Peso")  +
                            String.format("%-" + tamanhoPeso + "s", "Tipo peso")  + String.format("%-10s", "% VD");
                    relatorio += ("\n");
                }

                passada++;
                String nomeProduto = rs.getString("NM_PRODUTO");
                String marca = rs.getString("DS_MARCA");
                Integer quantidadePorcao =  rs.getInt("PORCAO");
                Integer valorEnergetico = rs.getInt("VALOR_ENERGETICO");
                String descricaoNutriente = rs.getString("DS_NUTRIENTE");
                double pesoComposicao = rs.getDouble("NR_PESO_COMP");
                double percentualDiario = rs.getDouble("NR_PERCENTUAL_DIARIO");
                String pesoNutriente = rs.getString("PESO_NUTRIENTE");

                relatorio += String.format("%-" + tamanhoProduto + "s", nomeProduto) + String.format("%-" + tamanhoMarca + "s", marca)
                        + String.format("%-10s", quantidadePorcao)
                        + String.format("%-20s", valorEnergetico)    + String.format("%-" + tamanhoNutriente + "s", descricaoNutriente)  +
                        String.format("%-10s", pesoComposicao)    +
                     String.format("%-" + tamanhoPeso + "s", pesoNutriente)  + String.format("%-10s", percentualDiario);
                relatorio += ("\n");


            }
            quantidadeTraco = "";
            tamanhoCabecalho = tamanhoCabecalho - " Final do relatório ".length();
            for(int i = 0; i <= (60 + ( tamanhoCabecalho  / 2) + 1 ); i++) {
                quantidadeTraco += "=";
            }
            if (passada > 0){
                relatorio +=  quantidadeTraco +  " Final do relatório " + quantidadeTraco;
            }else{
                relatorio += "Nutriente: " +  nutriente.getDescricaoNutriente() + " não possui cadastro em" +
                        " nenhum composição, favor verificar...";
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
        return relatorio;
    }

}
