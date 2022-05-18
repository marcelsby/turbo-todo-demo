## Instruções para executar localmente

Clone o projeto

```bash
  git clone https://github.com/marcelsby/turbo-todo-demo
```

Mude o seu terminal para a pasta do projeto

```bash
  cd turbo-todo-demo
```

Configure as variáveis de ambiente

- Ambiente parcialmente Dockerizado

    1. Configure as seguintes variáveis de ambiente no seu SO ou IDE, por exemplo:

    - `TODOTURBO_REDIS_HOSTNAME`
    - `TODOTURBO_REDIS_PORT`

- Ambiente completamente Dockerizado

    1. Copie o arquivo `.env.example`, renomeando-o para `.env`

    2. Preencha as variáveis de ambiente com os dados de conexão com o Redis do `docker-compose.yml`, por exemplo:

    ```bash
    REDIS_HOSTNAME=redis
    REDIS_PORT=6379
    ```
Execute o script de incialização

- Para o ambiente parcialmente Dockerizado

```bash
./start-local
```

- Ambiente completamente Dockerizado

```bash
./start 
```

## Extras

[Referência da API](https://github.com/marcelsby/turbo-todo-demo/blob/master/backend/turbo-todo/API.md)
