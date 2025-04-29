package br.com.ProjetoKraftHeinz.beans;

import java.sql.Date;
import java.util.Objects;

public class EstoqueProduto {

    private Produto produto;

    private Estoque estoque;

    private long idLote;

    private long quantidadeEstoque;

    private Date dataEntrada;

    private Date dataSaida;

    private Date dataFabricacao;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public long getIdLote() {
        return idLote;
    }

    public void setIdLote(long idLote) {
        this.idLote = idLote;
    }

    public long getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(long quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstoqueProduto that = (EstoqueProduto) o;
        return idLote == that.idLote && Double.compare(that.quantidadeEstoque, quantidadeEstoque) == 0 && Objects.equals(produto, that.produto) && Objects.equals(dataEntrada, that.dataEntrada) && Objects.equals(dataSaida, that.dataSaida) && Objects.equals(dataFabricacao, that.dataFabricacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produto, idLote, quantidadeEstoque, dataEntrada, dataSaida, dataFabricacao);
    }

    public EstoqueProduto() {
    }

    public EstoqueProduto(Produto produto, Estoque estoque, long idLote, long quantidadeEstoque, Date dataEntrada, Date dataFabricacao) {
        this.produto = produto;
        this.estoque = estoque;
        this.idLote = idLote;
        this.quantidadeEstoque = quantidadeEstoque;
        this.dataEntrada = dataEntrada;
        this.dataFabricacao = dataFabricacao;
    }

    //saida estoque


    public EstoqueProduto(Produto produto, Estoque estoque, long idLote, long quantidadeEstoque, Date dataSaida) {
        this.produto = produto;
        this.estoque = estoque;
        this.idLote = idLote;
        this.quantidadeEstoque = quantidadeEstoque;
        this.dataSaida = dataSaida;

    }

    @Override
    public String toString() {
        return "EstoqueProduto{" +
                "produto=" + produto +
                ", estoque=" + estoque +
                ", idLote=" + idLote +
                ", quantidadeEstoque=" + quantidadeEstoque +
                ", dataEntrada=" + dataEntrada +
                ", dataSaida=" + dataSaida +
                ", dataFabricacao=" + dataFabricacao +
                '}';
    }
}
