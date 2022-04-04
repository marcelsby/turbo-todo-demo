package br.demo.todoturbo.api.model.output;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoOutput {

    private String id;

    private String descricao;

    private boolean concluido;

}