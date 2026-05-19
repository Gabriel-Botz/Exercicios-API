package org.serratec.Exercicio03.Exception;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ErroResposta {

    private Integer status;
    private String descricao;
    private LocalDateTime dataHora;
    private List<String> erros;

    public ErroResposta(LocalDateTime dataHora, String descricao, List<String> erros, Integer status) {
        this.dataHora = dataHora;
        this.descricao = descricao;
        this.erros = erros;
        this.status = status;
    }

    public ErroResposta() {

    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
