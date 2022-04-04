package br.demo.todoturbo.api.model.input;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class AtualizarTodoInput {

    private String conteudo;

    private Boolean concluido;

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo.trim();
    }

}