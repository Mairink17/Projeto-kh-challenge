package br.com.ProjetoKraftHeinz.beans;

import java.sql.Date;
import java.util.Objects;

public class EstoqueIngrediente {

    private Ingrediente ingrediente;

    private Estoque estoque;

    private long idLote;

    private long quantidadeEstoque;

    private Date dataValidade;

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
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

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstoqueIngrediente that = (EstoqueIngrediente) o;
        return idLote == that.idLote && quantidadeEstoque == that.quantidadeEstoque &&
                Objects.equals(ingrediente, that.ingrediente) && Objects.equals(estoque, that.estoque)
                && Objects.equals(dataValidade, that.dataValidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingrediente, estoque, idLote, quantidadeEstoque, dataValidade);
    }

    public EstoqueIngrediente() {
    }

    public EstoqueIngrediente(Ingrediente ingrediente, Estoque estoque, long idLote, long quantidadeEstoque, Date dataValidade) {
        this.ingrediente = ingrediente;
        this.estoque = estoque;
        this.idLote = idLote;
        this.quantidadeEstoque = quantidadeEstoque;
        this.dataValidade = dataValidade;
    }

    @Override
    public String toString() {
        return "EstoqueIngrediente{" +
                "ingrediente=" + ingrediente +
                ", estoque=" + estoque +
                ", idLote=" + idLote +
                ", quantidadeEstoque=" + quantidadeEstoque +
                ", dataValidade=" + dataValidade +
                '}';
    }
}
