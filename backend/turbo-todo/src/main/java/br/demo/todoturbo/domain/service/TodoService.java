package br.demo.todoturbo.domain.service;

import br.demo.todoturbo.api.mappers.TodoMapper;
import br.demo.todoturbo.api.model.input.AtualizarTodoInput;
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
        String conteudoRecebido = criarTodoInput.getConteudo();

        if (conteudoRecebido == null || conteudoRecebido.isEmpty()) {
            throw new RegraNegocioException("Não é possível criar uma tarefa sem um conteúdo.");
        }

        TodoModel novoTodo = repository.save(todoMapper.createToEntity(criarTodoInput));

        return todoMapper.toView(novoTodo);
    }

    public Optional<TodoOutput> atualizar(String id, AtualizarTodoInput atualizarTodoInput) {
        // Verifica se pelo menos um campo vindo da requisição está preenchido
        if (atualizarTodoInput.getConcluido() == null && atualizarTodoInput.getConteudo() == null) {
            throw new RegraNegocioException("Para realizar uma atualização, pelo menos um campo deve ser preenchido.");
        }

        var todoBuscado = repository.findById(id);

        // Verifica se o to do está cadastrado
        if (todoBuscado.isEmpty()) {
            return Optional.empty();
        }

        // Verifica se o conteúdo enviado é nulo, em caso positivo ele seta o conteúdo antigo, para ser o novo conteúdo
        if (atualizarTodoInput.getConteudo() == null) {
            var conteudoAntigo = todoBuscado.get().getConteudo();
            atualizarTodoInput.setConteudo(conteudoAntigo);
        }

        // Verifica se o status de concluído é nulo, em caso positivo ele seta o valor antigo, para ser o novo status de concluído
        if (atualizarTodoInput.getConcluido() == null) {
            var isConcluidoAntigo = todoBuscado.get().isConcluido();
            atualizarTodoInput.setConcluido(isConcluidoAntigo);
        }

        // Monta o to do atualizado
        var todoAtualizado = todoMapper.updateToEntity(atualizarTodoInput);

        todoAtualizado.setId(id);

        // Salva as alterações no banco de dados
        repository.save(todoAtualizado);

        // Retorna o to do no formato de visualização
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