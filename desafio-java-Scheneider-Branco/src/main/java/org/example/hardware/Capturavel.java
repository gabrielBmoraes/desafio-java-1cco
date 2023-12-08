package org.example.hardware;

import java.time.LocalDateTime;

public interface Capturavel<T> {
    abstract String capturar();
    public default LocalDateTime getTempo(){
        return LocalDateTime.now();
    }
}
