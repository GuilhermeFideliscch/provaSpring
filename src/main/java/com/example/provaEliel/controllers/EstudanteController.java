package com.example.provaEliel.controllers;

import com.example.provaEliel.models.EstudanteModel;
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
    public EstudanteModel criarEstudante(@RequestBody EstudanteModel estudanteModel){
        return estudanteService.criarEstudante(estudanteModel);
    }

    @GetMapping
    public List<EstudanteModel> buscarEstudantes(){
        return estudanteService.findALL();
    }

    @GetMapping("/{id}")
    public Optional<EstudanteModel> buscarPorId(@PathVariable Long id){
        return estudanteService.findId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarEstudante(@PathVariable Long id){
        estudanteService.deletarEstudante(id);
    }

    @PutMapping("/{id}")
    public EstudanteModel atualizarAlunos(@PathVariable Long id, @RequestBody EstudanteModel estudanteModel){
        return estudanteService.atualizar(id, estudanteModel);
    }
}
