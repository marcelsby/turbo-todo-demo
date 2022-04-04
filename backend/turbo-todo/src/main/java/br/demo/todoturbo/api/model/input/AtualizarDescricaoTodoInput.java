package br.demo.todoturbo.api.model.input;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class AtualizarDescricaoTodoInput {

    private String descricao;

    public void setDescricao(String descricao) {
        this.descricao = descricao.trim();
    }

}