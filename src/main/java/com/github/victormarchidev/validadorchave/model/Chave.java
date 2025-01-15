package com.github.victormarchidev.validadorchave.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Chave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigoUf;
    private String anoEmissao;
    private String mesEmissao;
    private String cnpjEmitente;
    private String modelo;
    private String serie;
    private String numero;
    private String modoEmissao;
    private String chave;

    public Chave(){}

    public Chave(String codigoUf, String anoEmissao, String mesEmissao, String cnpjEmitente, String modelo, String serie, String numero, String modoEmissao, String chave) {
        this.codigoUf = codigoUf;
        this.anoEmissao = anoEmissao;
        this.mesEmissao = mesEmissao;
        this.cnpjEmitente = cnpjEmitente;
        this.modelo = modelo;
        this.serie = serie;
        this.numero = numero;
        this.modoEmissao = modoEmissao;
        this.chave = chave;
    }

    public String getCodigoUf() {
        return codigoUf;
    }

    public void setCodigoUf(String codigoUf) {
        this.codigoUf = codigoUf;
    }

    public String getAnoEmissao() {
        return anoEmissao;
    }

    public void setAnoEmissao(String anoEmissao) {
        this.anoEmissao = anoEmissao;
    }

    public String getMesEmissao() {
        return mesEmissao;
    }

    public void setMesEmissao(String mesEmissao) {
        this.mesEmissao = mesEmissao;
    }

    public String getCnpjEmitente() {
        return cnpjEmitente;
    }

    public void setCnpjEmitente(String cnpjEmitente) {
        this.cnpjEmitente = cnpjEmitente;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getModoEmissao() {
        return modoEmissao;
    }

    public void setModoEmissao(String modoEmissao) {
        this.modoEmissao = modoEmissao;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }
}
