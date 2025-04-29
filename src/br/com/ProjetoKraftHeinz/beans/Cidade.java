package br.com.ProjetoKraftHeinz.beans;

import java.util.Objects;

public class Cidade {

    private long codigo;

    private String descricaoCidade;

    private String codigoIbge;

    private Estado estado;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getDescricaoCidade() {
        return descricaoCidade;
    }

    public void setDescricaoCidade(String descricaoCidade) {
        this.descricaoCidade = descricaoCidade;
    }

    public String getCodigoIbge() {
        return codigoIbge;
    }

    public void setCodigoIbge(String codigoIbge) {
        this.codigoIbge = codigoIbge;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return codigo == cidade.codigo && Objects.equals(descricaoCidade, cidade.descricaoCidade) && Objects.equals(codigoIbge, cidade.codigoIbge) && Objects.equals(estado, cidade.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, descricaoCidade, codigoIbge, estado);
    }

    public Cidade() {
    }

    public Cidade(long codigo, String descricaoCidade) {
        this.codigo = codigo;
        this.descricaoCidade = descricaoCidade;
    }

    public Cidade(long codigo, String descricaoCidade, String codigoIbge, Estado estado) {
        this.codigo = codigo;
        this.descricaoCidade = descricaoCidade;
        this.codigoIbge = codigoIbge;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "codigo=" + codigo +
                ", descricaoCidade='" + descricaoCidade + '\'' +
                ", codigoIbge='" + codigoIbge + '\'' +
                ", estado=" + estado +
                '}';
    }
}
