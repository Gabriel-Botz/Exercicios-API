package org.serratec.Exercicio03.Controller;

import jakarta.validation.Valid;
import org.serratec.Exercicio03.Domain.Departamento;
import org.serratec.Exercicio03.Repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @GetMapping
    public List<Departamento> listar(){
        return departamentoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> buscarPorId(@PathVariable Long id){
        Optional<Departamento> departamento = departamentoRepository.findById(id);
        if (departamento.isPresent()){
            return ResponseEntity.ok(departamento.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Departamento criar (@RequestBody @Valid Departamento departamento){
        return departamentoRepository.save(departamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departamento> editar(@RequestBody @Valid Departamento departamento, @PathVariable Long id){
        if (!departamentoRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        departamento.setId(id);
        departamento = departamentoRepository.save(departamento);
        return ResponseEntity.ok(departamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        if (!departamentoRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        departamentoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
