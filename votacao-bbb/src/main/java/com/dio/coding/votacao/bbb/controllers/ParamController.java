package com.dio.coding.votacao.bbb.controllers;

import com.dio.coding.votacao.bbb.model.ParamModel;
import com.dio.coding.votacao.bbb.repository.ParamRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/params")
public class ParamController {

    private final ParamRepository repository;

    public ParamController(ParamRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/salvar")
    public ResponseEntity<ParamModel> salvar(@RequestBody ParamModel param){
        ParamModel entity = repository.save(param);
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/consultar")
    public ResponseEntity<ParamModel> consulta(@RequestParam String chave){
        Optional<ParamModel> objParametro = repository.findById(chave);
        if(objParametro.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(objParametro.get());
    }
}
