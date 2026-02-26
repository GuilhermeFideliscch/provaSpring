package com.example.provaEliel.services;

import com.example.provaEliel.models.Estudante;
import com.example.provaEliel.repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    public Estudante criarEstudante(Estudante estudante){
        return estudanteRepository.save(estudante);
    }

    public List<Estudante> findALL(){
        return estudanteRepository.findAll();
    }

    public Optional<Estudante> findId(Long id){
        return estudanteRepository.findById(id);
    }

    public void deletarEstudante(Long id){
        estudanteRepository.deleteById(id);
    }
}
