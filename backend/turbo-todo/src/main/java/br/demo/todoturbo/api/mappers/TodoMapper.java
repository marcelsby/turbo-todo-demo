package br.demo.todoturbo.api.mappers;

import br.demo.todoturbo.api.model.input.AtualizarTodoInput;
import br.demo.todoturbo.api.model.input.CriarTodoInput;
import br.demo.todoturbo.api.model.output.TodoOutput;
import br.demo.todoturbo.domain.model.TodoModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TodoMapper {

    @Autowired
    ModelMapper modelMapper;

    public TodoModel createToEntity(CriarTodoInput criarTodoInput) {
        return modelMapper.map(criarTodoInput, TodoModel.class);
    }

    public TodoModel updateToEntity(AtualizarTodoInput atualizarTodoInput) {
        return modelMapper.map(atualizarTodoInput, TodoModel.class);
    }

    public TodoOutput toView(TodoModel todoModel) {
        return modelMapper.map(todoModel, TodoOutput.class);
    }

}