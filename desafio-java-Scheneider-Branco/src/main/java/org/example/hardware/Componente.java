package org.example.hardware;

import com.github.britooo.looca.api.core.Looca;
import org.springframework.jdbc.core.JdbcTemplate;

public class Componente implements Capturavel {
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

    public Componente() {
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

    public Integer getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Integer idComponente) {
        this.idComponente = idComponente;
    }

    @Override
    public void capturar(JdbcTemplate conexao, Integer fkComponente) {

    }
}