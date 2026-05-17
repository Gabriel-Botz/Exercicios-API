package org.serratec.Funcionario.Domain;

public class Funcionario {

    private Long id;
    private String nome;
    private String cargo;

    public Funcionario(String cargo, Long id, String nome) {
        this.cargo = cargo;
        this.id = id;
        this.nome = nome;
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
}
