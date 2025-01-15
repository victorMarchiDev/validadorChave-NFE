package com.github.victormarchidev.validadorchave.controller;

import com.github.victormarchidev.validadorchave.service.ChaveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ChaveController {

    private final ChaveService service;

    public ChaveController(ChaveService service) {
        this.service = service;
    }

    @GetMapping("/validar")
    public ResponseEntity<Map<String, String>> validar(@RequestParam String chave){
        try {
            Map<String, String> response = service.validaChave(chave);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException | IllegalAccessException e){
            return ResponseEntity.badRequest().body(Map.of());
        }
    }

    @GetMapping("/consulta")
    public ResponseEntity<?> consultarChave(@RequestParam String chave) {
            if (chave.length() != 44 || !chave.matches("\\d+")) {
                return ResponseEntity.badRequest().body(Map.of(
                        "valid", false,
                        "message", "Chave inválida. Deve conter 44 dígitos numéricos."
                ));
            }

            String consultaLink = "https://www.nfe.fazenda.gov.br/portal/consultaRecaptcha.aspx?tipoConsulta=resumo&tipoConteudo=7PhJ+gAVw2g=";

            return ResponseEntity.ok(Map.of(
                    "valid", true,
                    "message", "Chave validada com sucesso.",
                    "consultaLink", consultaLink
            ));
        }


}
