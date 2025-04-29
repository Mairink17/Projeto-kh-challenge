package br.com.ProjetoKraftHeinz.view;

import br.com.ProjetoKraftHeinz.beans.*;
import br.com.ProjetoKraftHeinz.dao.*;
import br.com.ProjetoKraftHeinz.utils.EntradaDados;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class SistemaMonitoramento {

    public static void main(String[] args) {

        String[] opcoesSistema = {"Cadastrar Novo Produto", "Inserir Composição Nutricial em Produto",
                "Gerar Relatórios Insight", "Inserir Fornecedor","Sair"};

        int nValorOpcao = 1;
        int nValorRelatorio = 1;

        while (nValorOpcao != 4 && nValorOpcao != -1){

            nValorOpcao = EntradaDados.opcoes("Selecione a opção desejada: ",
                    "Projeto Monitoramento Kraft Heinz",
                    opcoesSistema);

            if (nValorOpcao == 0){

                try{

                    String nomeProduto = EntradaDados.texto("Digite o nome do Produto");
                    String descricaoProduto = "";
                    descricaoProduto = EntradaDados.texto("Digite a descrição do Produto");
                    while (descricaoProduto.length() > 400){
                        descricaoProduto = EntradaDados.texto("O limite de caracteres da descrição do Produto é de 400 , favor ajustar");
                    }
                    String marca = EntradaDados.texto("Digite a marca do produto");

                    double valorCusto = EntradaDados.valor("Digite o valor de custo do Produto");
                    double valorVenda = EntradaDados.valor("Digite o valor de venda do Produto");
                    int diasValidade = EntradaDados.inteiro("Digite a quantidade em dias da validade");
                    double peso = EntradaDados.valor("Digite o peso do Produto");

                    List<TipoPeso> listaPeso = new TipoPesoDAO().getListaConsulta();
                    List<String> pegaListaPeso = new ArrayList<>();
                    List<Integer> opcaoEscolhaPeso = new ArrayList<>();

                    for(TipoPeso item : listaPeso) {
                        pegaListaPeso.add( item.getDescricaoTipoPeso());
                        opcaoEscolhaPeso.add((int) item.getIdTipoPeso());
                    }
                    String[] opcoesTipoPeso = pegaListaPeso.toArray(new String[0]);
                    int nValorTipoPeso = -1;
                    while (nValorTipoPeso == -1){
                        nValorTipoPeso = EntradaDados.opcoes("Selecione o tipo do peso do produto (* obrigatório): " ,
                                "Projeto Monitoramento Kraft Heinz" ,opcoesTipoPeso);

                    }

                    List<Categoria> listaCategoria = new CategoriaDAO().getListaConsulta();
                    List<String> pegaListaCategoria = new ArrayList<>();
                    List<Integer> opcaoEscolhaCategoria = new ArrayList<>();

                    for(Categoria item : listaCategoria) {
                        pegaListaCategoria.add( item.getDescricaoCategoria());
                        opcaoEscolhaCategoria.add((int) item.getIdCategoria());
                    }
                    String[] listaEscolhaCategoria = pegaListaCategoria.toArray(new String[0]);
                    int nValorCategoria = -1;
                    while (nValorCategoria == -1){

                        nValorCategoria = EntradaDados.opcoes("Selecione o tipo da Categoria do Produto (* obrigatório): " ,
                                "Projeto Monitoramento Kraft Heinz",listaEscolhaCategoria);
                    }

                    List<Embalagem> listaEmbalagem = new EmbalagemDAO().getListaConsulta();
                    List<String> pegaListaEmbalagem = new ArrayList<>();
                    List<Integer> opcaoEscolhaEmbalagem = new ArrayList<>();

                    for(Embalagem item : listaEmbalagem) {
                        pegaListaEmbalagem.add( item.getDsEmbalagem());
                        opcaoEscolhaEmbalagem.add((int) item.getIdEmbalagem());
                    }
                    String[] listaEscolhaEmbalagem = pegaListaEmbalagem.toArray(new String[0]);
                    int nValorEmbalagem = -1;
                    while (nValorEmbalagem == -1){
                        nValorEmbalagem = EntradaDados.opcoes("Selecione a embalagem do produto (* obrigatório): ",
                                "Projeto Monitoramento Kraft Heinz" ,
                                listaEscolhaEmbalagem);
                    }
                    int quantidadePorcao = EntradaDados.inteiro("Digite a quantidade da porção do Produto");
                    int valorEnergetico = EntradaDados.inteiro("Digite o valor energético do Produto");

                    Embalagem embalagem = new EmbalagemDAO().getConsulta(opcaoEscolhaEmbalagem.get(nValorEmbalagem));
                    TipoPeso tipoPeso =  new TipoPesoDAO().getConsulta(opcaoEscolhaPeso.get(nValorTipoPeso));
                    Categoria categoriaInsert = new CategoriaDAO().getConsulta(opcaoEscolhaCategoria.get(nValorCategoria));

                    Produto produto = new Produto(1L, nomeProduto,valorCusto, valorVenda, diasValidade, peso,
                            quantidadePorcao,valorEnergetico,descricaoProduto,marca,tipoPeso,
                            categoriaInsert,
                            embalagem);
                    ProdutoDAO produtoDAO = new ProdutoDAO();
                    produtoDAO.cadastrar(produto);


                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("Ocorreu um erro durante cadastro, favor verificar log acima");

                }

            }else if (nValorOpcao == 1){
                try{
                    List<Produto> listaProduto = new ProdutoDAO().getListaConsulta();
                    List<String> pegaListaProduto = new ArrayList<>();
                    List<Integer> opcaoEscolhaProduto = new ArrayList<>();

                    for(Produto item : listaProduto) {
                        pegaListaProduto.add( item.getNomeProduto());
                        opcaoEscolhaProduto.add((int) item.getIdProduto());
                    }
                    String[] listaEscolhaProduto = pegaListaProduto.toArray(new String[0]);
                    int nValoProduto = -2;
                    while (nValoProduto == -2){
                        nValoProduto = EntradaDados.opcoes("Selecione produto (* obrigatório): ",
                                "Projeto Monitoramento Kraft Heinz",
                                listaEscolhaProduto  );

                    }
                    if (nValoProduto != -1){
                        List<Nutriente> listaNutriente = new NutrienteDAO().getListaConsulta();
                        List<String> pegaListaNutri = new ArrayList<>();
                        List<Integer> opcaoEscolhaNutriente = new ArrayList<>();
                        for(Nutriente item : listaNutriente) {
                            pegaListaNutri.add( item.getDescricaoNutriente());
                            opcaoEscolhaNutriente.add((int) item.getIdNutriente());
                        }
                        String[] opcoesNutriente2 = pegaListaNutri.toArray(new String[0]);
                        int nValorNutriente = -1;
                        while (nValorNutriente == -1) {
                            nValorNutriente = EntradaDados.opcoes("Selecione o relatório de conferência: ",
                                    "Projeto Monitoramento Kraft Heinz" ,
                                    opcoesNutriente2);
                        }
                        double pesoComposicao = EntradaDados.valor("Digite o peso da composição nutricional");

                        List<TipoPeso> listaPeso = new TipoPesoDAO().getListaConsulta();
                        List<String> pegaListaPeso = new ArrayList<>();
                        List<Integer> opcaoEscolhaPeso = new ArrayList<>();

                        for(TipoPeso item : listaPeso) {
                            pegaListaPeso.add( item.getDescricaoTipoPeso());
                            opcaoEscolhaPeso.add((int) item.getIdTipoPeso());
                        }
                        String[] opcoesTipoPeso = pegaListaPeso.toArray(new String[0]);
                        int nValorTipoPeso = -1;
                        while (nValorTipoPeso == -1){
                            nValorTipoPeso = EntradaDados.opcoes("Selecione o tipo do peso do produto (* obrigatório): ",
                                    "Projeto Monitoramento Kraft Heinz",opcoesTipoPeso);

                        }
                        double percentualDiario = EntradaDados.valor("Digite o % VD do nutriente");

                        Produto produtoId = new ProdutoDAO().getConsulta(opcaoEscolhaProduto.get(nValoProduto));
                        Nutriente nutrienteId = new NutrienteDAO().getConsulta(opcaoEscolhaNutriente.get(nValorNutriente));
                        TipoPeso pesoId = new TipoPesoDAO().getConsulta(opcaoEscolhaPeso.get(nValorTipoPeso));
                        ComposicaoNutricional composicaoNutricional = new ComposicaoNutricional(1L,pesoComposicao, percentualDiario,
                                        produtoId
                                ,nutrienteId ,
                                pesoId );
                        ComposicaoNutricionalDAO composicaoNutricionalDAO = new ComposicaoNutricionalDAO();
                        composicaoNutricionalDAO.cadastrar(composicaoNutricional);
                    }

                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("Ocorreu um erro durante cadastro, favor verificar log acima");
                }



            }else if (nValorOpcao == 2){
                String[] escolhaRelatorio = {"Composição Nutricional", "Fornecedor x Auditoria", "Fornecedor x Embalagem","Voltar"};

                    nValorRelatorio = EntradaDados.opcoes("Selecione o relatório de conferência: "  ,
                            "Projeto Monitoramento Kraft Heinz",escolhaRelatorio);

                    if (nValorRelatorio == 0){

                        List<Nutriente> listaNutriente = new NutrienteDAO().getListaConsulta();
                        List<String> pegaLista = new ArrayList<>();
                        List<Integer> opcaoEscolhaNutriente = new ArrayList<>();
                         for(Nutriente item : listaNutriente) {
                            pegaLista.add( item.getDescricaoNutriente());
                            opcaoEscolhaNutriente.add((int) item.getIdNutriente());
                        }
                        String[] opcoesNutriente = pegaLista.toArray(new String[0]);
                        int nValorNutriente = EntradaDados.opcoes("Selecione o relatório de conferência: "
                                ,"Projeto Monitoramento Kraft Heinz" ,
                                opcoesNutriente);

                        if (nValorNutriente != -1) {
                            System.out.println(new ComposicaoNutricionalDAO().getRelatorioComposicao(new NutrienteDAO()
                                    .getConsulta(opcaoEscolhaNutriente.get(nValorNutriente))));
                        }else{
                            System.out.println("Relatório cancelado pelo usuário...");
                        }

                }else if (nValorRelatorio == 1) {
                        String[] escolhaRelatorioAuditoria = {"Filtrar por Ano", "Ordenação Simples", "Voltar"};

                        int nValorRelatorioAuditoria = EntradaDados.opcoes("Selecione o relatório de Fornecedor x Auditoria: ",
                                "Projeto Monitoramento Kraft Heinz",
                                escolhaRelatorioAuditoria);

                        if (nValorRelatorioAuditoria == 0) {
                            try {
                                int ano = EntradaDados.inteiro("Digite o valor do ano a ser filtrado:");
                                System.out.println(new FornecedorAuditoriaDAO().getRelatorioAuditoria(0, ano));

                            } catch (NumberFormatException e){
                                e.printStackTrace();
                                System.out.println("Favor inserir um número válido referente ao ano à ser filtrado...");
                            }catch (Exception e) {
                                e.printStackTrace();

                            }
                        } else if (nValorRelatorioAuditoria == 1) {
                            System.out.println(new FornecedorAuditoriaDAO().getRelatorioAuditoria(2,0));

                        } else {
                            System.out.println("Geração do relatório cancelada...");
                        }
                    }else if(nValorRelatorio == 2){
                        try{
                            System.out.println(new EmbalagemDAO().getRelatorioNaoReutilizavel());

                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
            }else if (nValorOpcao == 3 ){
                try{
                    String nomeFornecedor = EntradaDados.texto("Digite o nome do Fornecedor a ser cadastrado:");
                    String cnpj = EntradaDados.texto("Digite o CNPJ");
                    String mensagemCnpj = "";
                    while (cnpj.length() != 14 || !(cnpj.matches("[0-9]+"))){
                        if (!(cnpj.matches("[0-9]+"))){
                            mensagemCnpj += "CNPJ deve conter apenas números." ;
                        }
                        if (cnpj.length() != 14) {
                            mensagemCnpj += " CNPJ deve possuir 14 números.";
                        }
                        cnpj = EntradaDados.texto(mensagemCnpj + " Favor digitar novamente");
                        mensagemCnpj = "";
                    }

                    String telefone = EntradaDados.texto("Digite o número de telefone");
                    String contato = EntradaDados.texto("Digite o nome do contato do cliente");
                    String logradouro = EntradaDados.texto("Digite o logradouro do cliente");
                    int ano = EntradaDados.inteiro("Digite o ano de início do contrato do cliente:");
                    int mes = EntradaDados.inteiro("Digite o mês de início do contrato do cliente:");
                    int dia = EntradaDados.inteiro("Digite o dia de início do contrato do cliente:");

                    List<Cidade> listaCidade = new CidadeDAO().getListaConsulta();
                    List<String> pegaListaCidade = new ArrayList<>();
                    List<Integer> opcaoEscolhaCidade = new ArrayList<>();
                    for(Cidade item : listaCidade) {
                        pegaListaCidade.add( item.getDescricaoCidade());
                        opcaoEscolhaCidade.add((int) item.getCodigo());
                    }
                    String[] opcoesNutriente = pegaListaCidade.toArray(new String[0]);
                    int nValorNutriente = EntradaDados.opcoes("Selecione a cidade do Fornecedor "
                            ,"Projeto Monitoramento Kraft Heinz" ,
                            opcoesNutriente);

                    java.sql.Date dataHora = new Date(ano,mes -1 ,dia);
                    Fornecedor fornecedor = new Fornecedor(1L, nomeFornecedor, cnpj, telefone,contato,
                            logradouro,dataHora,new CidadeDAO().getConsulta(5));
                    FornecedorDAO fornecedorDAO = new FornecedorDAO();
                    fornecedorDAO.cadastrar(fornecedor);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Sistema Finalizado...");
    }
}
