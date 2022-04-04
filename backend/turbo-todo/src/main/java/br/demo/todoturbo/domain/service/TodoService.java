package br.demo.todoturbo.domain.service;

import br.demo.todoturbo.api.mappers.TodoMapper;
import br.demo.todoturbo.api.model.input.AtualizarDescricaoTodoInput;
import br.demo.todoturbo.api.model.input.CriarTodoInput;
import br.demo.todoturbo.api.model.output.TodoOutput;
import br.demo.todoturbo.domain.exception.RegraNegocioException;
import br.demo.todoturbo.domain.model.TodoModel;
import br.demo.todoturbo.domain.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TodoService {

    TodoRepository repository;

    TodoMapper todoMapper;

    public List<TodoModel> listar() {
        return (List<TodoModel>) repository.findAll();
    }

    public TodoOutput cadastrar(CriarTodoInput criarTodoInput) {
        String descricaoRecebida = criarTodoInput.getDescricao();

        if (descricaoRecebida == null || descricaoRecebida.isEmpty()) {
            throw new RegraNegocioException("Não é possível criar uma tarefa sem um conteúdo.");
        }

        TodoModel novoTodo = repository.save(todoMapper.createToEntity(criarTodoInput));

        return todoMapper.toView(novoTodo);
    }

    public Optional<TodoOutput> atualizarDescricao(String id, AtualizarDescricaoTodoInput atualizarDescricaoTodoInput) {
        var todoBuscado = repository.findById(id);

        // Verifica se o to do está cadastrado
        if (todoBuscado.isEmpty()) {
            return Optional.empty();
        }

        // Verifica se a conteúdo enviada é nula ou está em branco,
        // em caso positivo ele lança uma exceção

        var descricaoRecebida = atualizarDescricaoTodoInput.getDescricao();

        if (descricaoRecebida == null || descricaoRecebida.isEmpty()) {
            throw new RegraNegocioException("Para atualizar uma tarefa é necessário que a descrição esteja preenchida.");
        }

        // Monta o to do atualizado
        var todoAtualizado = todoMapper.updateToEntity(atualizarDescricaoTodoInput);

        todoAtualizado.setId(id);

        // Salva as alterações no banco de dados
        repository.save(todoAtualizado);

        // Retorna o to do no formato de visualização
        return Optional.of(todoMapper.toView(todoAtualizado));
    }

    public Optional<TodoOutput> alternarEstadoConcluida(String id) {
        var todoBuscado = repository.findById(id);

        if (todoBuscado.isEmpty()) {
            return Optional.empty();
        }

        var estadoAlternado = !todoBuscado.get().isConcluido();

        var todoAtualizado = todoBuscado.get();

        todoAtualizado.setConcluido(estadoAlternado);

        repository.save(todoAtualizado);

        return Optional.of(todoMapper.toView(todoAtualizado));
    }

    public boolean excluir(String id) {
        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);

        return true;
    }

    public void limparBanco() {
        repository.deleteAll();
    }

}