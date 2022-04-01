package br.demo.todoturbo.domain.model;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.UUID;

@Data
@RedisHash("Todo")
public class Todo implements Serializable {

    private UUID id;

    private String content;

    private boolean isDone;

}