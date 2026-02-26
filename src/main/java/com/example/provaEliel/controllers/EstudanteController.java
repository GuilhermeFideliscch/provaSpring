package com.example.provaEliel.controllers;

import com.example.provaEliel.models.Estudante;
import com.example.provaEliel.services.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/estudantes")
public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;

    @PostMapping
    public Estudante criarEstudante(@RequestBody Estudante estudante){
        return estudanteService.criarEstudante(estudante);
    }

    @GetMapping
    public List<Estudante> buscarEstudantes(){
        return estudanteService.findALL();
    }

    @GetMapping("/{id}")
    public Optional<Estudante> buscarPorId(@PathVariable Long id){
        return estudanteService.findId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarEstudante(@PathVariable Long id){
        estudanteService.deletarEstudante(id);
    }
}
