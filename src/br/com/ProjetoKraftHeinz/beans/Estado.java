package br.com.ProjetoKraftHeinz.beans;

import java.util.Objects;

public class Estado {

    private long codigo;

    private String descricaoEstado;

    private String sigla;

    private String codigoIbge ;

    private Pais pais;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getDescricaoEstado() {
        return descricaoEstado;
    }

    public void setDescricaoEstado(String descricaoEstado) {
        this.descricaoEstado = descricaoEstado;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getCodigoIbge() {
        return codigoIbge;
    }

    public void setCodigoIbge(String codigoIbge) {
        this.codigoIbge = codigoIbge;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return codigo == estado.codigo && Objects.equals(descricaoEstado, estado.descricaoEstado) && Objects.equals(sigla, estado.sigla) && Objects.equals(codigoIbge, estado.codigoIbge) && Objects.equals(pais, estado.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, descricaoEstado, sigla, codigoIbge, pais);
    }

    public Estado() {
    }

    public Estado(long codigo, String descricaoEstado, String sigla, String codigoIbge, Pais pais) {
        this.codigo = codigo;
        this.descricaoEstado = descricaoEstado;
        this.sigla = sigla;
        this.codigoIbge = codigoIbge;
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "codigo=" + codigo +
                ", descricaoEstado='" + descricaoEstado + '\'' +
                ", sigla='" + sigla + '\'' +
                ", codigoIbge='" + codigoIbge + '\'' +
                ", pais=" + pais +
                '}';
    }
}
