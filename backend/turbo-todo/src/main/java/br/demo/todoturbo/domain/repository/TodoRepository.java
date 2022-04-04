package br.demo.todoturbo.domain.repository;

import br.demo.todoturbo.domain.model.TodoModel;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<TodoModel, String> {

}