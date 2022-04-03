package br.demo.todoturbo.domain.service;

import br.demo.todoturbo.domain.model.Todo;
import br.demo.todoturbo.domain.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    TodoRepository repository;

    public Optional<List<Todo>> listar() {
        var resultadoListagemTodos = (List<Todo>) repository.findAll();

        return resultadoListagemTodos.isEmpty() ? Optional.empty() : Optional.of(resultadoListagemTodos);
    }

}