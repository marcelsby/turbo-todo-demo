
# Referência da API

## Debug

#### Inserir dados de teste

```http
  GET /todos/debug/inserirDadosTeste
```

#### Limpar o banco de dados

```http
  GET /todos/debug/limparBanco
```

## Recurso de To do

#### Listar todos os to do's

```http
  GET /todos
```

#### Cadastrar um to do

```http
  POST /todos
```

| Parameter   | Type     | Description                            |
| :---------- | :------- | :------------------------------------- |
| `descricao` | `string` | **Obrigatório**. A descrição da tarefa |

#### Editar a descrição de um to do

```http
  PATCH /todos/${id}
```
| Parameter   | Type     | Description                                       |
| :---------- | :------- | :------------------------------------------------ |
| `id`        | `string` | **Obrigatório**. Id do item que será atualizado   |
| `descricao` | `string` | **Obrigatório**. A descrição atualizada da tarefa |

#### Alternar o estado de um to do (concluído, não concluído)

```http
  PATCH /todos/${id}/alternar
```
| Parameter   | Type     | Description                                              |
| :---------- | :------- | :------------------------------------------------------- |
| `id`        | `string` | **Obrigatório**. Id do item que o estado será atualizado |


#### Excluir um to do

```http
  DELETE /todos/${id}
```
| Parameter   | Type     | Description                                              |
| :---------- | :------- | :------------------------------------------------------- |
| `id`        | `string` | **Obrigatório**. Id do item que o estado será excluído   |