package br.com.ProjetoKraftHeinz.beans;

import java.sql.Date;
import java.util.Objects;

public class FornecedorAuditoria {

    private Fornecedor fornecedor;

    private long idAuditoria;

    private String descricaoAuditoria;

    private Date dataAuditoria;

    private boolean resultado;

    private String laudo;

    private String nomeResponsavel;

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public long getIdAuditoria() {
        return idAuditoria;
    }

    public void setIdAuditoria(long idAuditoria) {
        this.idAuditoria = idAuditoria;
    }

    public String getDescricaoAuditoria() {
        return descricaoAuditoria;
    }

    public void setDescricaoAuditoria(String descricaoAuditoria) {
        this.descricaoAuditoria = descricaoAuditoria;
    }

    public Date getDataAuditoria() {
        return dataAuditoria;
    }

    public void setDataAuditoria(Date dataAuditoria) {
        this.dataAuditoria = dataAuditoria;
    }

    public boolean isResultado() {
        return resultado;
    }

    public void setResultado(boolean resultado) {
        this.resultado = resultado;
    }

    public String getLaudo() {
        return laudo;
    }

    public void setLaudo(String laudo) {
        this.laudo = laudo;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FornecedorAuditoria that = (FornecedorAuditoria) o;
        return idAuditoria == that.idAuditoria && resultado == that.resultado && Objects.equals(fornecedor, that.fornecedor)
                && Objects.equals(descricaoAuditoria, that.descricaoAuditoria) && Objects.equals(dataAuditoria, that.dataAuditoria)
                && Objects.equals(laudo, that.laudo) && Objects.equals(nomeResponsavel, that.nomeResponsavel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fornecedor, idAuditoria, descricaoAuditoria, dataAuditoria, resultado, laudo, nomeResponsavel);
    }

    public FornecedorAuditoria() {
    }

    public FornecedorAuditoria(Fornecedor fornecedor, long idAuditoria, String descricaoAuditoria, Date dataAuditoria,
                               boolean resultado, String laudo, String nomeResponsavel) {
        this.fornecedor = fornecedor;
        this.idAuditoria = idAuditoria;
        this.descricaoAuditoria = descricaoAuditoria;
        this.dataAuditoria = dataAuditoria;
        this.resultado = resultado;
        this.laudo = laudo;
        this.nomeResponsavel = nomeResponsavel;
    }
}
