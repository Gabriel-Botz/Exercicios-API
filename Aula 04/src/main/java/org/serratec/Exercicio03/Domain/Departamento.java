package org.serratec.Exercicio03.Domain;

import jakarta.persistence.*;

@Entity
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 20)
    private String nome;

    @Column(name = "setor", nullable = false, length = 20)
    private String setor;

    @Column(name = "gerente", nullable = false,length = 40)
    private String gerente;

    public Departamento(Long id, String gerente, String nome, String setor) {
        this.id = id;
        this.gerente = gerente;
        this.nome = nome;
        this.setor = setor;
    }

    public Departamento() {

    }

    public Long getCod() {
        return id;
    }

    public void setCod(Long cod) {
        this.id = cod;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}
