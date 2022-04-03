package br.demo.todoturbo.api.controller;

import br.demo.todoturbo.domain.model.Todo;
import br.demo.todoturbo.domain.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/todos")
@RestController
public class TodoController {

    @Autowired
    TodoService service;

    @GetMapping
    public ResponseEntity<List<Todo>> listar() {
        var resultadoListagemTodos = service.listar();

        if (resultadoListagemTodos.isPresent()) {
            return ResponseEntity.ok(resultadoListagemTodos.get());
        }

        return ResponseEntity.noContent().build();
    }

}