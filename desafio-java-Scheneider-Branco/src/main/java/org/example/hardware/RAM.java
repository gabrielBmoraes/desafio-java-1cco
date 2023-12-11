package org.example.hardware;

public class RAM extends Componente{

    public RAM(String nomeComponente, String unidadeMedida, Integer fkCliente) {
        super(nomeComponente, unidadeMedida, fkCliente);
    }

    @Override
    public String capturar() {
        return "INSERT INTO registro (valorRegistro, dtHoraRegistro, fkComponente) " +
                "VALUES (%d, %s, %d)".formatted(looca.getMemoria().getEmUso(), getTempo(),3);
    }
}
