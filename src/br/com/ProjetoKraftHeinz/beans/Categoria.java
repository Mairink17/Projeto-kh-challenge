package br.com.ProjetoKraftHeinz.beans;

import java.util.Objects;

public class Categoria {

    private long idCategoria;

    private String descricaoCategoria;

    public long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescricaoCategoria() {
        return descricaoCategoria;
    }

    public void setDescricaoCategoria(String descricaoCategoria) {
        this.descricaoCategoria = descricaoCategoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return idCategoria == categoria.idCategoria && Objects.equals(descricaoCategoria, categoria.descricaoCategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategoria, descricaoCategoria);
    }

    public Categoria() {
    }

    public Categoria(long idCategoria, String descricaoCategoria) {
        this.idCategoria = idCategoria;
        this.descricaoCategoria = descricaoCategoria;
    }


}
