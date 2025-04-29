package br.com.ProjetoKraftHeinz.beans;

import java.util.Objects;

public class Ingrediente {

    private long ingrediente;

    private String descricaoIngrediente;

    private Fornecedor fornecedor;

    private TipoIngrediente tipoIngrediente;

    public long getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(long ingrediente) {
        this.ingrediente = ingrediente;
    }

    public String getDescricaoIngrediente() {
        return descricaoIngrediente;
    }

    public void setDescricaoIngrediente(String descricaoIngrediente) {
        this.descricaoIngrediente = descricaoIngrediente;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public TipoIngrediente getTipoIngrediente() {
        return tipoIngrediente;
    }

    public void setTipoIngrediente(TipoIngrediente tipoIngrediente) {
        this.tipoIngrediente = tipoIngrediente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingrediente that = (Ingrediente) o;
        return ingrediente == that.ingrediente && Objects.equals(descricaoIngrediente, that.descricaoIngrediente) && Objects.equals(fornecedor, that.fornecedor) && Objects.equals(tipoIngrediente, that.tipoIngrediente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingrediente, descricaoIngrediente, fornecedor, tipoIngrediente);
    }

    public Ingrediente() {
    }

    public Ingrediente(long ingrediente, String descricaoIngrediente, Fornecedor fornecedor, TipoIngrediente tipoIngrediente) {
        this.ingrediente = ingrediente;
        this.descricaoIngrediente = descricaoIngrediente;
        this.fornecedor = fornecedor;
        this.tipoIngrediente = tipoIngrediente;
    }
}


