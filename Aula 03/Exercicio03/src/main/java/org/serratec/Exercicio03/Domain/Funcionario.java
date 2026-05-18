package org.serratec.Exercicio03.Domain;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

public class Funcionario {

    private Long id;
    private String nome;
    private String cargo;
    private BigDecimal salario;

    public Funcionario(String cargo, Long id, String nome, BigDecimal salario) {
        this.cargo = cargo;
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public Funcionario() {
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}
