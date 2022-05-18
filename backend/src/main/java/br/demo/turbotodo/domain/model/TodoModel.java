package br.demo.turbotodo.domain.model;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@RedisHash("Todo")
public class TodoModel implements Serializable {

    private String id;

    private String descricao;

    private boolean concluido;

}