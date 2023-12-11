package org.example.hardware;

public class Disco extends Componente{


    public Disco(String nomeComponente, String unidadeMedida, Integer fkCliente) {
        super( nomeComponente, unidadeMedida, fkCliente);
    }

    @Override
    public String capturar() {
        return "INSERT INTO registro (valorRegistro, dtHoraRegistro, fkComponente) " +
                "VALUES (%s, %s, %s)".formatted(looca.getGrupoDeDiscos().getVolumes().get(0).getTotal(), getTempo(),2);
    }

}
