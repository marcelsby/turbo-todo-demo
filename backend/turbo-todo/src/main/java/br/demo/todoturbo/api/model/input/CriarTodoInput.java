package br.demo.todoturbo.api.model.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CriarTodoInput {

    private String conteudo;

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo.trim();
    }

}