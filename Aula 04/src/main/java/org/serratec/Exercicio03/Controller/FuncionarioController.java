package org.serratec.Exercicio03.Controller;


import org.serratec.Exercicio03.Domain.Funcionario;
import org.serratec.Exercicio03.Repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {

   @Autowired
    private FuncionarioRepository funcionarioRepository;

   @GetMapping
    public List<Funcionario> listar(){
       return funcionarioRepository.findAll();
   }

   @GetMapping("/{id}")
   public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id){
       Optional<Funcionario> funcionario = funcionarioRepository.findById(id);

       if (funcionario.isPresent()){
           return ResponseEntity.ok(funcionario.get());
       }
       return ResponseEntity.notFound().build();
   }

   @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario inserir(@RequestBody Funcionario funcionario){
       return funcionarioRepository.save(funcionario);
   }

   @PutMapping("/{id}")
    public ResponseEntity<Funcionario> editar(@RequestBody Funcionario funcionario, @PathVariable Long id){
       if (!funcionarioRepository.existsById(id)){
           return ResponseEntity.notFound().build();
       }
       funcionario.setId(id);
       funcionario = funcionarioRepository.save(funcionario);
       return ResponseEntity.ok(funcionario);
   }

   @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
       if (!funcionarioRepository.existsById(id)){
           return ResponseEntity.notFound().build();
       }

       funcionarioRepository.deleteById(id);
       return ResponseEntity.noContent().build();
   }
}




