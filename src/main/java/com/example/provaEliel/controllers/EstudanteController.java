package com.example.provaEliel.controllers;

import com.example.provaEliel.models.EstudanteModel;
import com.example.provaEliel.services.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/estudantes")
public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;

    @GetMapping
    public ResponseEntity<List<EstudanteModel>> findAll() {
        List<EstudanteModel> estudantes = estudanteService.findALL();
        return ResponseEntity.ok().body(estudantes);
    }

    @PostMapping
    public ResponseEntity<EstudanteModel> criarEstudante(@RequestBody EstudanteModel estudanteModel){

        EstudanteModel novoEstudante = estudanteService.criarEstudante(estudanteModel);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novoEstudante.getId())
                .toUri();

        return ResponseEntity.created(uri).body(novoEstudante);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<EstudanteModel>> buscarPorId(@PathVariable Long id){
        Optional<EstudanteModel> estudante = estudanteService.findId(id);
        return ResponseEntity.ok().body(estudante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEstudante(@PathVariable Long id){
        estudanteService.deletarEstudante(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudanteModel> atualizarAlunos(@PathVariable Long id, @RequestBody EstudanteModel estudanteModel){
        EstudanteModel estudanteAtualizado = estudanteService.atualizar(id, estudanteModel);
        return ResponseEntity.ok().body(estudanteAtualizado);
    }
}