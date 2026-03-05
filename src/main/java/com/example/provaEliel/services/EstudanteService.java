package com.example.provaEliel.services;

import com.example.provaEliel.models.EstudanteModel;
import com.example.provaEliel.repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    public EstudanteModel criarEstudante(EstudanteModel estudanteModel){
        return estudanteRepository.save(estudanteModel);
    }

    public List<EstudanteModel> findALL(){
        return estudanteRepository.findAll();
    }

    public Optional<EstudanteModel> findId(Long id){
        return estudanteRepository.findById(id);
    }

    public void deletarEstudante(Long id){
        estudanteRepository.deleteById(id);
    }

    public EstudanteModel atualizar (Long id, EstudanteModel estudanteModel){
        EstudanteModel model = estudanteRepository.findById(id).get();
        model.setNome(estudanteModel.getNome());
        model.setIdade(estudanteModel.getIdade());
        model.setEmail(estudanteModel.getEmail());

        return estudanteRepository.save(model);
    }

}
