package br.demo.todoturbo.api.model.input;

import lombok.Getter;

@Getter
public class CriarTodoInput {

    private String descricao;

    public void setDescricao(String descricao) {
        this.descricao = descricao.trim();
    }

}