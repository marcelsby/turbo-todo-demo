package br.demo.turbotodo.domain.repository;

import br.demo.turbotodo.domain.model.TodoModel;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<TodoModel, String> {

}