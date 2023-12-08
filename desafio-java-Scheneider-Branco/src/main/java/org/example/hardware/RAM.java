package org.example.hardware;

public class RAM extends Componente{
    private Integer idComponente;

    public RAM(Integer idComponente, String nomeComponente, String unidadeMedida, Integer fkCliente, Integer idComponente1) {
        super(idComponente, nomeComponente, unidadeMedida, fkCliente);
        this.idComponente = idComponente1;
    }

    @Override
    public String capturar() {
        return "INSERT INTO registro (valorRegistro, dtHoraRegistro, fkComponente) " +
                "VALUES (%s, %s, %s)".formatted(looca.getMemoria().getEmUso(), getTempo(), getIdComponente());
    }

    public Integer getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Integer idComponente) {
        this.idComponente = idComponente;
    }
}
