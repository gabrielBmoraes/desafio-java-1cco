package org.example.logicaRegistro;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public class Registro {
    private Double valorRegistro;
    private LocalDateTime dataRegistro;
    private Integer fkComponente;

    public Registro(Double valorRegistro, LocalDateTime dataRegistro, Integer fkComponente) {
        this.valorRegistro = valorRegistro;
        this.dataRegistro = dataRegistro;
        this.fkComponente = fkComponente;
    }

    public Double getValorRegistro() {
        return valorRegistro;
    }

    public void setValorRegistro(Double valorRegistro) {
        this.valorRegistro = valorRegistro;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Integer getFkComponente() {
        return fkComponente;
    }

    public void setFkComponente(Integer fkComponente) {
        this.fkComponente = fkComponente;
    }
}