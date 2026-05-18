package org.serratec.Exercicio03.Controller;


import org.serratec.Exercicio03.Domain.Funcionario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/funcionario")
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

}
