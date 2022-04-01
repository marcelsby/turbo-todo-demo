package br.demo.todoturbo.api.controller;

import br.demo.todoturbo.domain.model.Todo;
import br.demo.todoturbo.domain.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/todos")
@RestController
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @GetMapping
    public List<Todo> listar() {
        return (List<Todo>) todoRepository.findAll();
    }

    @PostMapping
    public Todo cadastrar(@RequestBody Todo novoTodo) {
        novoTodo.setId(UUID.randomUUID());
        novoTodo.setDone(false);
        return todoRepository.save(novoTodo);
    }

}