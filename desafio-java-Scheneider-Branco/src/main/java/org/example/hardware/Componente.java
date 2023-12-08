package org.example.hardware;

import com.github.britooo.looca.api.core.Looca;

public abstract class Componente implements Capturavel {
    Looca looca;
    Integer idComponente;
    String nomeComponente;
    String unidadeMedida;
    Integer fkCliente;

    public Componente(Integer idComponente, String nomeComponente, String unidadeMedida, Integer fkCliente) {
        this.looca = new Looca();
        this.idComponente = idComponente;
        this.nomeComponente = nomeComponente;
        this.unidadeMedida = unidadeMedida;
        this.fkCliente = fkCliente;
    }

    public String getNomeComponente() {
        return nomeComponente;
    }

    public void setNomeComponente(String nomeComponente) {
        this.nomeComponente = nomeComponente;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Integer getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(Integer fkCliente) {
        this.fkCliente = fkCliente;
    }
}