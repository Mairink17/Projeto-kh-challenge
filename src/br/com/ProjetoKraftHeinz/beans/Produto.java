package br.com.ProjetoKraftHeinz.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Produto {

    private long idProduto;

    private String nomeProduto;

    private double valorCusto;

    private double valorVenda;

    private int validadeDias;

    private double peso;

    private int quantidadePorcao;

    private int valorEnergetico;

    private String descricaoProduto;

    private String descricaoMarca;

    private TipoPeso tipoPeso;

    private Categoria categoria;

    private Embalagem embalagem;

    private List<ComposicaoNutricional> composicaoNutricional = new ArrayList<>();

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(double valorCusto) {
        this.valorCusto = valorCusto;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public int getValidadeDias() {
        return validadeDias;
    }

    public void setValidadeDias(int validadeDias) {
        this.validadeDias = validadeDias;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getQuantidadePorcao() {
        return quantidadePorcao;
    }

    public void setQuantidadePorcao(int quantidadePorcao) {
        this.quantidadePorcao = quantidadePorcao;
    }

    public int getValorEnergetico() {
        return valorEnergetico;
    }

    public void setValorEnergetico(int valorEnergetico) {
        this.valorEnergetico = valorEnergetico;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getDescricaoMarca() {
        return descricaoMarca;
    }

    public void setDescricaoMarca(String descricaoMarca) {
        this.descricaoMarca = descricaoMarca;
    }

    public TipoPeso getTipoPeso() {
        return tipoPeso;
    }

    public void setTipoPeso(TipoPeso tipoPeso) {
        this.tipoPeso = tipoPeso;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Embalagem getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(Embalagem embalagem) {
        this.embalagem = embalagem;
    }

    public List<ComposicaoNutricional> getComposicaoNutricional() {
        return composicaoNutricional;
    }

    public void setComposicaoNutricional(List<ComposicaoNutricional> composicaoNutricional) {
        this.composicaoNutricional = composicaoNutricional;
    }

    public Produto() {
    }

    public Produto(long idProduto, String nomeProduto, double valorCusto, double valorVenda, int validadeDias,
                   double peso, int quantidadePorcao, int valorEnergetico, String descricaoProduto,
                   String descricaoMarca, TipoPeso tipoPeso, Categoria categoria, Embalagem embalagem) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.valorCusto = valorCusto;
        this.valorVenda = valorVenda;
        this.validadeDias = validadeDias;
        this.peso = peso;
        this.quantidadePorcao = quantidadePorcao;
        this.valorEnergetico = valorEnergetico;
        this.descricaoProduto = descricaoProduto;
        this.descricaoMarca = descricaoMarca;
        this.tipoPeso = tipoPeso;
        this.categoria = categoria;
        this.embalagem = embalagem;
    }

    public Produto(long idProduto, String nomeProduto) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
    }

    public Produto(long idProduto, String nomeProduto, double valorCusto, double valorVenda, int validadeDias, double peso, int quantidadePorcao, int valorEnergetico, String descricaoProduto, String descricaoMarca) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.valorCusto = valorCusto;
        this.valorVenda = valorVenda;
        this.validadeDias = validadeDias;
        this.peso = peso;
        this.quantidadePorcao = quantidadePorcao;
        this.valorEnergetico = valorEnergetico;
        this.descricaoProduto = descricaoProduto;
        this.descricaoMarca = descricaoMarca;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "idProduto=" + idProduto +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", valorCusto=" + valorCusto +
                ", valorVenda=" + valorVenda +
                ", validadeDias=" + validadeDias +
                ", peso=" + peso +
                ", quantidadePorcao=" + quantidadePorcao +
                ", valorEnergetico=" + valorEnergetico +
                ", descricaoProduto='" + descricaoProduto + '\'' +
                ", descricaoMarca='" + descricaoMarca + '\'' +
                ", tipoPeso=" + tipoPeso +
                ", categoria=" + categoria +
                ", embalagem=" + embalagem +
                ", composicaoNutricional=" + composicaoNutricional +
                '}';
    }
}
