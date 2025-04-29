package br.com.ProjetoKraftHeinz.beans;

import java.util.Objects;

public class ComposicaoNutricional {

    private long idComposicao;

    private double peso;

    private double percentualDiario;

    private Produto produto;

    private Nutriente nutriente;

    private TipoPeso tipoPeso;

    public long getIdComposicao() {
        return idComposicao;
    }

    public void setIdComposicao(long idComposicao) {
        this.idComposicao = idComposicao;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPercentualDiario() {
        return percentualDiario;
    }

    public void setPercentualDiario(double percentualDiario) {
        this.percentualDiario = percentualDiario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Nutriente getNutriente() {
        return nutriente;
    }

    public void setNutriente(Nutriente nutriente) {
        this.nutriente = nutriente;
    }

    public TipoPeso getTipoPeso() {
        return tipoPeso;
    }

    public void setTipoPeso(TipoPeso tipoPeso) {
        this.tipoPeso = tipoPeso;
    }

    public ComposicaoNutricional() {
    }

    public ComposicaoNutricional(long idComposicao, double peso, double percentualDiario, Produto produto, Nutriente nutriente, TipoPeso tipoPeso) {
        this.idComposicao = idComposicao;
        this.peso = peso;
        this.percentualDiario = percentualDiario;
        this.produto = produto;
        this.nutriente = nutriente;
        this.tipoPeso = tipoPeso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComposicaoNutricional that = (ComposicaoNutricional) o;
        return idComposicao == that.idComposicao && Double.compare(that.peso, peso) == 0 && Double.compare(that.percentualDiario, percentualDiario) == 0 && Objects.equals(produto, that.produto) && Objects.equals(nutriente, that.nutriente) && Objects.equals(tipoPeso, that.tipoPeso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idComposicao, peso, percentualDiario, produto, nutriente, tipoPeso);
    }

    @Override
    public String toString() {
        return "ComposicaoNutricional{" +
                "idComposicao=" + idComposicao +
                ", peso=" + peso +
                ", percentualDiario=" + percentualDiario +
                ", produto=" + produto +
                ", nutriente=" + nutriente +
                ", tipoPeso=" + tipoPeso +
                '}';
    }
}
