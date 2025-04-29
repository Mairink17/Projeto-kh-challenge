package br.com.ProjetoKraftHeinz.beans;

import java.util.Objects;

public class Pais {

    private long codigo;

    private String descricaoPais;

    private String descricaoContinente;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getDescricaoPais() {
        return descricaoPais;
    }

    public void setDescricaoPais(String descricaoPais) {
        this.descricaoPais = descricaoPais;
    }

    public String getDescricaoContinente() {
        return descricaoContinente;
    }

    public void setDescricaoContinente(String descricaoContinente) {
        this.descricaoContinente = descricaoContinente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return codigo == pais.codigo && Objects.equals(descricaoPais, pais.descricaoPais) && Objects.equals(descricaoContinente, pais.descricaoContinente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, descricaoPais, descricaoContinente);
    }

    public Pais() {
    }

    public Pais(long codigo, String descricaoPais, String descricaoContinente) {
        this.codigo = codigo;
        this.descricaoPais = descricaoPais;
        this.descricaoContinente = descricaoContinente;
    }
}
