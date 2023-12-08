package org.example.hardware;

public class CPU extends Componente{
    private Integer idComponente;

    public CPU(Integer idComponente, String nomeComponente, String unidadeMedida, Integer fkCliente, Integer idComponente1) {
        super(idComponente, nomeComponente, unidadeMedida, fkCliente);
        this.idComponente = idComponente;
    }

    @Override
    public String capturar() {
        return "INSERT INTO registro (valorRegistro, dtHoraRegistro, fkComponente) " +
                "VALUES (%s, %s, %s)".formatted(looca.getProcessador().getUso(), getTempo(), getIdComponente());
    };

    public Integer getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Integer idComponente) {
        this.idComponente = idComponente;
    }
}
