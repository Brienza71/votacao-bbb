package com.dio.coding.votacao.bbb.controllers;

import com.dio.coding.votacao.bbb.model.ParamModel;
import com.dio.coding.votacao.bbb.model.ParticipanteModel;
import com.dio.coding.votacao.bbb.repository.ParamRepository;
import com.dio.coding.votacao.bbb.repository.ParticipanteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/participante")
public class ParticipanteController {

    private final ParticipanteRepository repository;

    public ParticipanteController(ParticipanteRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/salvar")
    public ResponseEntity<ParticipanteModel> salvar(@RequestBody ParticipanteModel participante) {
        ParticipanteModel entity = repository.save(participante);
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/consultar")
    public ResponseEntity<ParticipanteModel> consulta(@RequestParam String id){
        Optional<ParticipanteModel> obj = repository.findById(id);
        if(obj.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(obj.get());
    }
}
