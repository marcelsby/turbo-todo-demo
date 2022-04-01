package br.demo.todoturbo.domain.repository;

import br.demo.todoturbo.domain.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {

}