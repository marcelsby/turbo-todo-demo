package br.demo.turbotodo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;

@Configuration
public class RedisConfig {

    @Value("${todoTurbo.db.hostname}")
    private String redisHostName;

    @Value("${todoTurbo.db.port}")
    private int redisPort;

    @Bean
    public JedisClientConfiguration getClientConfig() {
        JedisClientConfiguration.JedisClientConfigurationBuilder builder =
                JedisClientConfiguration.builder();

        var connectionTimeout = Duration.ofSeconds(30);

        return builder.connectTimeout(connectionTimeout)
                .usePooling().build();
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        var environmentalConfig = new RedisStandaloneConfiguration(redisHostName, redisPort);

        return new JedisConnectionFactory(environmentalConfig, getClientConfig());
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }

}