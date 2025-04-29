package br.com.ProjetoKraftHeinz.beans;

import java.util.Objects;

public class Fabrica {

    private long codigo;

    private String descricaoFabrica;

    private String codigoCnpj;

    private String razaoSocial;

    private String cep;

    private String logradouro;

    private Cidade cidade;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getDescricaoFabrica() {
        return descricaoFabrica;
    }

    public void setDescricaoFabrica(String descricaoFabrica) {
        this.descricaoFabrica = descricaoFabrica;
    }

    public String getCodigoCnpj() {
        return codigoCnpj;
    }

    public void setCodigoCnpj(String codigoCnpj) {
        this.codigoCnpj = codigoCnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fabrica fabrica = (Fabrica) o;
        return codigo == fabrica.codigo && Objects.equals(descricaoFabrica, fabrica.descricaoFabrica) && Objects.equals(codigoCnpj, fabrica.codigoCnpj) && Objects.equals(razaoSocial, fabrica.razaoSocial) && Objects.equals(cep, fabrica.cep) && Objects.equals(logradouro, fabrica.logradouro) && Objects.equals(cidade, fabrica.cidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, descricaoFabrica, codigoCnpj, razaoSocial, cep, logradouro, cidade);
    }

    public Fabrica() {
    }

    public Fabrica(long codigo, String descricaoFabrica, String codigoCnpj, String razaoSocial, String cep, String logradouro) {
        this.codigo = codigo;
        this.descricaoFabrica = descricaoFabrica;
        this.codigoCnpj = codigoCnpj;
        this.razaoSocial = razaoSocial;
        this.cep = cep;
        this.logradouro = logradouro;
    }

    public Fabrica(long codigo, String descricaoFabrica, String codigoCnpj, String razaoSocial, String cep, String logradouro, Cidade cidade) {
        this.codigo = codigo;
        this.descricaoFabrica = descricaoFabrica;
        this.codigoCnpj = codigoCnpj;
        this.razaoSocial = razaoSocial;
        this.cep = cep;
        this.logradouro = logradouro;
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Fabrica{" +
                "codigo=" + codigo +
                ", descricaoFabrica='" + descricaoFabrica + '\'' +
                ", codigoCnpj='" + codigoCnpj + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", cidade=" + cidade +
                '}';
    }
}

