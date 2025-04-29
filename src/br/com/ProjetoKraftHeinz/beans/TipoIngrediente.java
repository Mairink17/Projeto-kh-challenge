package br.com.ProjetoKraftHeinz.beans;

import java.util.Objects;

public class TipoIngrediente {

    private long idTipoIngrediente;

    private String descricaoTipoIngrediente;

    public long getIdTipoIngrediente() {
        return idTipoIngrediente;
    }

    public void setIdTipoIngrediente(long idTipoIngrediente) {
        this.idTipoIngrediente = idTipoIngrediente;
    }

    public String getDescricaoTipoIngrediente() {
        return descricaoTipoIngrediente;
    }

    public void setDescricaoTipoIngrediente(String descricaoTipoIngrediente) {
        this.descricaoTipoIngrediente = descricaoTipoIngrediente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoIngrediente that = (TipoIngrediente) o;
        return idTipoIngrediente == that.idTipoIngrediente && Objects.equals(descricaoTipoIngrediente, that.descricaoTipoIngrediente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTipoIngrediente, descricaoTipoIngrediente);
    }

    public TipoIngrediente() {
    }

    public TipoIngrediente(long idTipoIngrediente, String descricaoTipoIngrediente) {
        this.idTipoIngrediente = idTipoIngrediente;
        this.descricaoTipoIngrediente = descricaoTipoIngrediente;
    }

    @Override
    public String toString() {
        return "TipoIngrediente{" +
                "idTipoIngrediente=" + idTipoIngrediente +
                ", descricaoTipoIngrediente='" + descricaoTipoIngrediente + '\'' +
                '}';
    }
}
