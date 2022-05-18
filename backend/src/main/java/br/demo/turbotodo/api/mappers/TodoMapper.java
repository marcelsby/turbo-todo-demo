package br.demo.turbotodo.api.mappers;

import br.demo.turbotodo.api.model.input.AtualizarDescricaoTodoInput;
import br.demo.turbotodo.api.model.input.CriarTodoInput;
import br.demo.turbotodo.api.model.output.TodoOutput;
import br.demo.turbotodo.domain.model.TodoModel;
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

    public TodoModel updateToEntity(AtualizarDescricaoTodoInput atualizarDescricaoTodoInput) {
        return modelMapper.map(atualizarDescricaoTodoInput, TodoModel.class);
    }

    public TodoOutput toView(TodoModel todoModel) {
        return modelMapper.map(todoModel, TodoOutput.class);
    }

}