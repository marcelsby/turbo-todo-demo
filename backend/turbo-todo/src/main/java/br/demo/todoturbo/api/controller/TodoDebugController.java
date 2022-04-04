package br.demo.todoturbo.api.controller;

import br.demo.todoturbo.api.model.input.CriarTodoInput;
import br.demo.todoturbo.domain.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/todos")
@RestController
public class TodoDebugController {

    TodoService service;

    TodoController todoController;

    @GetMapping("/debug/limparBanco")
    public void limparBanco() {
        service.limparBanco();
    }

    @GetMapping("/debug/inserirDadosTeste")
    public void inserirDadosTeste() {
        var tarefa1 = new CriarTodoInput("Fazer carinho no Mingau");
        var tarefa2 = new CriarTodoInput("Lavar o banheiro");
        var tarefa3 = new CriarTodoInput("Fazer a compra de frutas do mês");

        todoController.cadastrar(tarefa1);
        todoController.cadastrar(tarefa2);
        todoController.cadastrar(tarefa3);
    }

}