package br.com.ProjetoKraftHeinz.beans;

import java.util.Objects;

public class Estoque {

    private long idEstoque;

    private String descricaoEstoque;

    private char tipoEstoque;

    private long fkFabrica;

    public long getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(long idEstoque) {
        this.idEstoque = idEstoque;
    }

    public String getDescricaoEstoque() {
        return descricaoEstoque;
    }

    public void setDescricaoEstoque(String descricaoEstoque) {
        this.descricaoEstoque = descricaoEstoque;
    }

    public char getTipoEstoque() {
        return tipoEstoque;
    }

    public void setTipoEstoque(char tipoEstoque) {
        this.tipoEstoque = tipoEstoque;
    }

    public long getFkFabrica() {
        return fkFabrica;
    }

    public void setFkFabrica(long fkFabrica) {
        this.fkFabrica = fkFabrica;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estoque estoque = (Estoque) o;
        return idEstoque == estoque.idEstoque && tipoEstoque == estoque.tipoEstoque && fkFabrica == estoque.fkFabrica && Objects.equals(descricaoEstoque, estoque.descricaoEstoque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstoque, descricaoEstoque, tipoEstoque, fkFabrica);
    }

    public Estoque() {
    }

    public Estoque(long idEstoque, String descricaoEstoque, char tipoEstoque, long fkFabrica) {
        this.idEstoque = idEstoque;
        this.descricaoEstoque = descricaoEstoque;
        this.tipoEstoque = tipoEstoque;
        this.fkFabrica = fkFabrica;
    }

}
