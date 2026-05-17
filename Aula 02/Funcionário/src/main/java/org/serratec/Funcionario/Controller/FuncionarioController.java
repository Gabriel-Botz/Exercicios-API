package org.serratec.Funcionario.Controller;

import org.serratec.Funcionario.Domain.Funcionario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {

    static List<Funcionario> listaFuncionario = new ArrayList<>();

    static {
        listaFuncionario.add(new Funcionario(12341L, "João", "Vendedor"));
        listaFuncionario.add(new Funcionario(12342L, "Pedro", "Vendedor"));
        listaFuncionario.add(new Funcionario(12343L, "Marcelo", "Vendedor"));
        listaFuncionario.add(new Funcionario(12344L, "Julia", "Estoquista"));
        listaFuncionario.add(new Funcionario(12345L, "Paulo", "Estoquista"));
        listaFuncionario.add(new Funcionario(12346L, "Marcos", "Gerente"));
        listaFuncionario.add(new Funcionario(12347L, "Eduarda", "Proprietário"));
    }

    @GetMapping("/listarFuncionario")
    public List<Funcionario> listarFuncionario(){
        return listaFuncionario;
    }

    @GetMapping("buscarPorId/{id}")
    public Funcionario buscarPorId(@PathVariable Long id){
        for (int i = 0; i < listaFuncionario.size(); i++){
            if (listaFuncionario.get(i).getId().equals(id))
                return listaFuncionario.get(i);
        }
        return null;
    }

    @GetMapping("buscarPorCargo")
    public List<Funcionario> buscarPorCargo (@RequestParam String cargo){

        List<Funcionario> encontrados = new ArrayList<>();

        for (int i = 0; i < listaFuncionario.size(); i++){
            if (listaFuncionario.get(i).getCargo().equalsIgnoreCase(cargo)) {
                encontrados.add(listaFuncionario.get(i));
            }
        }
        return encontrados;
    }




}
