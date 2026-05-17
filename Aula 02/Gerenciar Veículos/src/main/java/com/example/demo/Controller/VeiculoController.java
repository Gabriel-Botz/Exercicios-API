package com.example.demo.Controller;

import com.example.demo.Domain.Veiculo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    static List<Veiculo> listaVeiculo = new ArrayList<>();

    static {
        listaVeiculo.add(new Veiculo(12345L, "Toyota", "Corolla"));
        listaVeiculo.add(new Veiculo(12346L, "Fiat", "Uno"));
        listaVeiculo.add(new Veiculo(12347L, "Honda", "Civic"));
    }

    @GetMapping("/veiculos")
    public List<Veiculo> listarVeiculos(){
        return listaVeiculo;
    }

    @GetMapping("/veiculos/{id}")
    public Veiculo buscarPorId(@PathVariable Long id){
        for (int i = 0; i < listaVeiculo.size(); i++){
          if (listaVeiculo.get(i).getId().equals(id)){
            return listaVeiculo.get(i);
          }
        }
        return null;
    }

    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo criarVeiculo(@RequestBody Veiculo veiculo){
        listaVeiculo.add(veiculo);
        return veiculo;
    }

    @PutMapping("/alterar/{id}")
    public Veiculo alterarVeiculoPorId(@PathVariable Long id, @RequestBody Veiculo veiculoAtualizado){
        for (int i = 0; i < listaVeiculo.size(); i++){
            if (listaVeiculo.get(i).getId().equals(id)){
                listaVeiculo.set(i, veiculoAtualizado);
                return veiculoAtualizado;
            }
        }
        return null;
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarVeiculo(@PathVariable Long id){
        for (int i = 0; i < listaVeiculo.size(); i++){
            if (listaVeiculo.get(i).getId().equals(id)){
                listaVeiculo.remove(i);
                return "Veículo deletado com sucesso!";
            }
        }
        return "Veículo não encontrado.";
    }

    @GetMapping("/buscar")
    public List<Veiculo> buscarPorMarca(@RequestParam String marca){

        List<Veiculo> encontrados = new ArrayList<>();

        for (Veiculo veiculo : listaVeiculo){

            if (veiculo.getMarca().equalsIgnoreCase(marca)){
                encontrados.add(veiculo);
            }

        }

        return encontrados;
    }
}
