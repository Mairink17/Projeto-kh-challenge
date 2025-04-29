package br.com.ProjetoKraftHeinz.beans;


import java.sql.Date;
import java.util.Objects;

public class Fornecedor {

    private long idFornecedor;

    private String nomeFornecedor;

    private String cnpj;

    private String telefone;

    private String nomeContato;

    private String logradouro;

    private Date dataInicio;

    private Date dataFim;

    private Cidade cidade;

    public long getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
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
        Fornecedor that = (Fornecedor) o;
        return idFornecedor == that.idFornecedor && Objects.equals(nomeFornecedor, that.nomeFornecedor) && Objects.equals(cnpj, that.cnpj) && Objects.equals(telefone, that.telefone) && Objects.equals(nomeContato, that.nomeContato) && Objects.equals(logradouro, that.logradouro) && Objects.equals(dataInicio, that.dataInicio) && Objects.equals(dataFim, that.dataFim) && Objects.equals(cidade, that.cidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFornecedor, nomeFornecedor, cnpj, telefone, nomeContato, logradouro, dataInicio, dataFim, cidade);
    }

    public String listarConsulta() {
        return "Fornecedor{" +
                "idFornecedor=" + idFornecedor +
                ", nomeFornecedor='" + nomeFornecedor + '\'' +
                ", cnpj='" + cnpj +
                '}';
    }

    public Fornecedor() {
    }


    public Fornecedor(long idFornecedor, String nomeFornecedor, String cnpj, String telefone, String nomeContato, String logradouro, Date dataInicio) {
        this.idFornecedor = idFornecedor;
        this.nomeFornecedor = nomeFornecedor;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.nomeContato = nomeContato;
        this.logradouro = logradouro;
        this.dataInicio = dataInicio;
    }

    public Fornecedor(long idFornecedor, String nomeFornecedor, String cnpj, String telefone, String nomeContato, String logradouro, Date dataInicio, Date dataFim) {
        this.idFornecedor = idFornecedor;
        this.nomeFornecedor = nomeFornecedor;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.nomeContato = nomeContato;
        this.logradouro = logradouro;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Fornecedor(long idFornecedor, String nomeFornecedor, String cnpj) {
        this.idFornecedor = idFornecedor;
        this.nomeFornecedor = nomeFornecedor;
        this.cnpj = cnpj;
    }

    public Fornecedor(long idFornecedor, String nomeFornecedor, String cnpj, String telefone, String nomeContato, String logradouro, Date dataInicio, Cidade cidade) {
        this.idFornecedor = idFornecedor;
        this.nomeFornecedor = nomeFornecedor;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.nomeContato = nomeContato;
        this.logradouro = logradouro;
        this.dataInicio = dataInicio;
        this.cidade = cidade;
    }

    public Fornecedor(long idFornecedor, String nomeFornecedor, String cnpj, String telefone, String nomeContato, String logradouro, Date dataInicio, Date dataFim, Cidade cidade) {
        this.idFornecedor = idFornecedor;
        this.nomeFornecedor = nomeFornecedor;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.nomeContato = nomeContato;
        this.logradouro = logradouro;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.cidade = cidade;
    }
}
