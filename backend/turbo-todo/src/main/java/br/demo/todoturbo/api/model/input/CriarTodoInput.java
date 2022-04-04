package br.demo.todoturbo.api.model.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CriarTodoInput {

    private String descricao;

    public void setDescricao(String descricao) {
        this.descricao = descricao.trim();
    }

}