package org.example.hardware;

import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;

public interface Capturavel<T> {
    abstract void capturar(JdbcTemplate conexao, Integer fkComponente);

    public default LocalDateTime getTempo(){
        return LocalDateTime.now();
    }
}
