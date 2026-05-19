package org.serratec.Exercicio03.Domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "nome", nullable = false, length = 20)
    @NotBlank(message = "O nome não pode ser vazio.")
    @Size(min = 2, max = 50, message = "O nome deve ter entre 2 e 50 caracteres")
    private String nome;

    @Column(name = "setor", nullable = false, length = 20)
    @NotBlank(message = "O setor não pode ser vazio.")
    @Size(min = 2, max = 50, message = "O setor deve ter entre 2 e 50 caracteres")
    private String setor;

    @Column(name = "gerente", nullable = false,length = 40)
    @NotBlank(message = "O campo 'gerente' não pode ser vazio.")
    @Size(min = 2, max = 50, message = "O campo 'gerente' deve ter entre 2 e 50 caracteres")
    private String gerente;

    @Column
    @NotBlank(message = "O campo email não pode estar vazio.")
    @Email(message = "Email inválido")
    private String email;

    public Departamento(String email, String gerente, Long id, String nome, String setor) {
        this.email = email;
        this.gerente = gerente;
        this.id = id;
        this.nome = nome;
        this.setor = setor;
    }

    public Departamento() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
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

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}
