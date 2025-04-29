package br.com.ProjetoKraftHeinz.beans;

import java.util.Objects;

public class TipoPeso {

    private long idTipoPeso;

    private String descricaoTipoPeso;

    public long getIdTipoPeso() {
        return idTipoPeso;
    }

    public void setIdTipoPeso(long idTipoPeso) {
        this.idTipoPeso = idTipoPeso;
    }

    public String getDescricaoTipoPeso() {
        return descricaoTipoPeso;
    }

    public void setDescricaoTipoPeso(String descricaoTipoPeso) {
        this.descricaoTipoPeso = descricaoTipoPeso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoPeso tipoPeso = (TipoPeso) o;
        return idTipoPeso == tipoPeso.idTipoPeso && Objects.equals(descricaoTipoPeso, tipoPeso.descricaoTipoPeso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTipoPeso, descricaoTipoPeso);
    }

    public TipoPeso() {
    }

    public TipoPeso(long idTipoPeso, String descricaoTipoPeso) {
        this.idTipoPeso = idTipoPeso;
        this.descricaoTipoPeso = descricaoTipoPeso;
    }

    @Override
    public String toString() {
        return "TipoPeso{" +
                "idTipoPeso=" + idTipoPeso +
                ", descricaoTipoPeso='" + descricaoTipoPeso + '\'' +
                '}';
    }
}
