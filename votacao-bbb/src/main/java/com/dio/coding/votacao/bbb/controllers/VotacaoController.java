package com.dio.coding.votacao.bbb.controllers;

import com.dio.coding.votacao.bbb.model.ParticipanteModel;
import com.dio.coding.votacao.bbb.services.VotacaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/votacao")
@AllArgsConstructor
public class VotacaoController {

    private final VotacaoService service;

    @PostMapping
    public ResponseEntity<String> votar(@RequestBody ParticipanteModel participante){
        service.adicionalEventos(participante);
        return ResponseEntity.ok("Voto computado!");
    }
}
