package br.com.ProjetoKraftHeinz.beans;

import java.util.Objects;

public class EstoqueEmbalagem {

        private Embalagem embalagem;

        private Estoque estoque;

        private long idLote;

        private long quantidadeEstoque;


    public Embalagem getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(Embalagem embalagem) {
        this.embalagem = embalagem;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstoqueEmbalagem that = (EstoqueEmbalagem) o;
        return idLote == that.idLote && quantidadeEstoque == that.quantidadeEstoque && Objects.equals(embalagem, that.embalagem) && Objects.equals(estoque, that.estoque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(embalagem, estoque, idLote, quantidadeEstoque);
    }

    public EstoqueEmbalagem() {
    }

    public EstoqueEmbalagem(Embalagem embalagem, Estoque estoque, long idLote, long quantidadeEstoque) {
        this.embalagem = embalagem;
        this.estoque = estoque;
        this.idLote = idLote;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    @Override
    public String toString() {
        return "EstoqueEmbalagem{" +
                "embalagem=" + embalagem +
                ", estoque=" + estoque +
                ", idLote=" + idLote +
                ", quantidadeEstoque=" + quantidadeEstoque +
                '}';
    }
}


