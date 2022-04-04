package br.demo.todoturbo.api.model.input;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class AtualizarTodoInput {

    private String descricao;

    private Boolean concluido;

    public void setDescricao(String descricao) {
        this.descricao = descricao.trim();
    }

}