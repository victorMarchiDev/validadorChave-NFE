package com.github.victormarchidev.validadorchave.service;

import com.github.victormarchidev.validadorchave.model.Chave;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChaveService {

    public Map<String, String> validaChave(String chave) throws IllegalAccessException {

        if(chave.length() != 44 || chave == null){
            throw new IllegalAccessException("Chave inválido, verifique!");
        }

        String mesEmissao = verificaMes(chave);
        String modoEmissao = verificaModoEmitido(chave);
        String modeloEmissao = verificaModelo(chave);
        String ufEmissao = verificaUF(chave);

        Map<String, String> atributos = new HashMap<>();
        atributos.put("codigoUF", ufEmissao);
        atributos.put("anoEmissao", "20" + chave.substring(2, 4));
        atributos.put("mesEmissao", mesEmissao);
        atributos.put("CNPJ", chave.substring(6, 20));
        atributos.put("modelo", modeloEmissao);
        atributos.put("serie", chave.substring(22, 25));
        atributos.put("numero", chave.substring(25, 34));
        atributos.put("modoEmissao", modoEmissao);
        atributos.put("chaveUnica", chave.substring(35));

        return atributos;
    }

    public String verificaModoEmitido(String chave){
        String modoEmissao = chave.substring(34, 35);

        return switch (modoEmissao){
            case "1" -> "1 - Emissão normal";
            case "2" -> "2 - Contingência FS (Formulário de Segurança).";
            case "3" -> "3 - Contingência SCAN (Sistema de Contingência do Ambiente Nacional) – desativado.";
            case "4" -> "4 - Contingência DPEC (Declaração Prévia de Emissão em Contingência).";
            case "5" -> "5 - Contingência FS-DA (Formulário de Segurança para Impressão de DANFE).";
            case "6" -> "6 - Contingência SVC-AN (SEFAZ Virtual de Contingência - Ambiente Nacional).";
            case "7" -> "7 - Contingência SVC-RS (SEFAZ Virtual de Contingência - Rio Grande do Sul).";
            case "9" -> "9 - Emissão Offline (entrada manual no sistema da SEFAZ).";
            default -> throw new IllegalStateException();
        };
    }

    public String verificaMes(String chave) throws IllegalAccessException {
        String mes = chave.substring(4, 6);
        return switch (mes) {
            case "01" -> "Janeiro";
            case "02" -> "Fevereiro";
            case "03" -> "Março";
            case "04" -> "Abril";
            case "05" -> "Maio";
            case "06" -> "Junho";
            case "07" -> "Julho";
            case "08" -> "Agosto";
            case "09" -> "Setembro";
            case "10" -> "Outubro";
            case "11" -> "Novembro";
            case "12" -> "Dezembro";
            default -> throw new IllegalAccessException("Mês inválido na chave.");
        };
    }

    public String verificaModelo(String chave) throws IllegalAccessException {
        String modelo = chave.substring(20, 22);
        return switch (modelo){
            case "55" -> "55 - NF-e (Nota Fiscal Eletrônica)";
            case "65" -> "65 - NFC-e (Nota Fiscal de Consumidor Eletrônica)";
            case "57" -> "57 - CT-e (Conhecimento de Transporte Eletrônico)";
            case "67" -> "67 - CT-e OS (Conhecimento de Transporte Eletrônico para Outros Serviços)";
            case "58" -> "58 - MDF-e (Manifesto Eletrônico de Documentos Fiscais)";
            case "59" -> "59 - SAT (Sistema Autenticador e Transmissor de Cupons Fiscais Eletrônicos)";
            case "66" -> "66 - NF3e (Nota Fiscal Eletrônica de Energia Elétrica)";
            case "63" -> "63 - BP-e (Bilhete de Passagem Eletrônico) ";
            default -> throw new IllegalStateException("Unexpected value: " + modelo);
        };
    }

    public String verificaUF(String chave) throws IllegalAccessException{
        String uf = chave.substring(0,2);
        return switch (uf){
            case "12" -> "12 - Acre";
            case "27" -> "27 - Alagoas";
            case "13" -> "13 - Amazonas";
            case "16" -> "16 - Amapá";
            case "29" -> "29 - Bahia";
            case "23" -> "23 - Ceará";
            case "53" -> "53 - Distrito Federal";
            case "32" -> "32 - Espírito Santo";
            case "52" -> "52 - Goiás";
            case "21" -> "21 - Maranhão";
            case "31" -> "31 - Minas Gerais";
            case "50" -> "50 - Mato Grosso do Sul";
            case "51" -> "51 - Mato Grosso";
            case "15" -> "15 - Pará";
            case "25" -> "25 - Paraíba";
            case "26" -> "26 - Pernambuco";
            case "22" -> "22 - Piauí";
            case "41" -> "41 - Paraná";
            case "33" -> "33 - Rio de Janeiro";
            case "24" -> "24 - Rio Grande do Norte";
            case "11" -> "11 - Rondônia";
            case "14" -> "14 - Roraima";
            case "43" -> "43 - Rio Grande do Sul";
            case "42" -> "42 - Santa Catarina";
            case "28" -> "28 - Sergipe";
            case "35" -> "35 - São Paulo";
            case "17" -> "17 - Tocantins";
            default -> throw new IllegalStateException("Unexpected value: " + uf);
        };
    }

}
