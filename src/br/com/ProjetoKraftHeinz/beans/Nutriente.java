package br.com.ProjetoKraftHeinz.beans;

import java.util.Objects;

public class Nutriente {

    private long idNutriente;

    private String descricaoNutriente;

    public long getIdNutriente() {
        return idNutriente;
    }

    public void setIdNutriente(long idNutriente) {
        this.idNutriente = idNutriente;
    }

    public String getDescricaoNutriente() {
        return descricaoNutriente;
    }

    public void setDescricaoNutriente(String descricaoNutriente) {
        this.descricaoNutriente = descricaoNutriente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nutriente nutriente = (Nutriente) o;
        return idNutriente == nutriente.idNutriente && Objects.equals(descricaoNutriente, nutriente.descricaoNutriente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNutriente, descricaoNutriente);
    }

    public Nutriente() {
    }

    public Nutriente(long idNutriente, String descricaoNutriente) {
        this.idNutriente = idNutriente;
        this.descricaoNutriente = descricaoNutriente;
    }

    @Override
    public String toString() {
        return "Nutriente{" +
                "idNutriente=" + idNutriente +
                ", descricaoNutriente='" + descricaoNutriente + '\'' +
                '}';
    }
}
