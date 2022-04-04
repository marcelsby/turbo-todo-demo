package br.demo.todoturbo.api.controller;

import br.demo.todoturbo.api.model.input.AtualizarTodoInput;
import br.demo.todoturbo.api.model.input.CriarTodoInput;
import br.demo.todoturbo.api.model.output.TodoOutput;
import br.demo.todoturbo.domain.model.TodoModel;
import br.demo.todoturbo.domain.service.TodoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/todos")
@AllArgsConstructor
@RestController
public class TodoController {

    TodoService service;

    ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<TodoModel>> listar() {
        var resultadoListagem = service.listar();

        if (!resultadoListagem.isEmpty()) {
            log.info("Tarefas listadas com sucesso!");
            return ResponseEntity.ok(resultadoListagem);
        }

        log.info("Nenhuma tarefa encontrada!");
        return ResponseEntity.noContent().build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public TodoOutput cadastrar(@RequestBody CriarTodoInput criarTodoInput) {
        return service.cadastrar(criarTodoInput);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoOutput> atualizar(@PathVariable String id, @RequestBody AtualizarTodoInput atualizarTodoInput) {
        var resultadoAtualizacao = service.atualizar(id, atualizarTodoInput);

        if (resultadoAtualizacao.isPresent()) {
            log.info("Tarefa de ID: " + id + " atualizada com sucesso!");
            return ResponseEntity.ok(resultadoAtualizacao.get());
        }

        log.info("Não foi possível completar a operação, pois a tarefa não foi encontrada!");
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable String id) {
        var resultadoExclusao = service.excluir(id);

        if (resultadoExclusao) {
            log.info("Tarefa de ID: " + id + " excluída com sucesso!");
            return ResponseEntity.ok().build();
        }

        log.info("Não foi possível completar a operação, pois a tarefa não foi encontrada!");
        return ResponseEntity.notFound().build();
    }

}