package br.com.ProjetoKraftHeinz.beans;

import java.util.Objects;

public class Embalagem {

    private long idEmbalagem;

    private String dsEmbalagem;

    private double altura;

    private double largura;

    private double comprimento;

    private String formato;

    private String material;

    private boolean reutilizavel;

    private Fornecedor fornecedor;


    public long getIdEmbalagem() {
        return idEmbalagem;
    }

    public void setIdEmbalagem(long idEmbalagem) {
        this.idEmbalagem = idEmbalagem;
    }

    public String getDsEmbalagem() {
        return dsEmbalagem;
    }

    public void setDsEmbalagem(String dsEmbalagem) {
        this.dsEmbalagem = dsEmbalagem;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public boolean isReutilizavel() {
        return reutilizavel;
    }

    public void setReutilizavel(boolean reutilizavel) {
        this.reutilizavel = reutilizavel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Embalagem embalagem = (Embalagem) o;
        return idEmbalagem == embalagem.idEmbalagem && Double.compare(embalagem.altura, altura) == 0 && Double.compare(embalagem.largura, largura) == 0 && Double.compare(embalagem.comprimento, comprimento) == 0 && Objects.equals(dsEmbalagem, embalagem.dsEmbalagem) && Objects.equals(formato, embalagem.formato) && Objects.equals(material, embalagem.material) && Objects.equals(fornecedor, embalagem.fornecedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmbalagem, dsEmbalagem, altura, largura, comprimento, formato, material, fornecedor);
    }

    public Embalagem() {
    }

    public Embalagem(long idEmbalagem, String dsEmbalagem, double altura, double largura, double comprimento, String formato, String material) {
        this.idEmbalagem = idEmbalagem;
        this.dsEmbalagem = dsEmbalagem;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
        this.formato = formato;
        this.material = material;
    }

    public Embalagem(long idEmbalagem, String dsEmbalagem, double altura, double largura, double comprimento, String formato, String material, Fornecedor fornecedor) {
        this.idEmbalagem = idEmbalagem;
        this.dsEmbalagem = dsEmbalagem;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
        this.formato = formato;
        this.material = material;
        this.fornecedor = fornecedor;
    }

    public Embalagem(long idEmbalagem, String dsEmbalagem, double altura, double largura, double comprimento, String formato, String material, boolean reutilizavel, Fornecedor fornecedor) {
        this.idEmbalagem = idEmbalagem;
        this.dsEmbalagem = dsEmbalagem;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
        this.formato = formato;
        this.material = material;
        this.reutilizavel = reutilizavel;
        this.fornecedor = fornecedor;
    }

}
