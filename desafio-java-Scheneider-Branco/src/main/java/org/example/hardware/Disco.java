package org.example.hardware;

public class Disco extends Componente{
    private Integer idComponente;

    public Disco(Integer idComponente, String nomeComponente, String unidadeMedida, Integer fkCliente, Integer idComponente1) {
        super(idComponente, nomeComponente, unidadeMedida, fkCliente);
        this.idComponente = idComponente1;
    }

    @Override
    public String capturar() {
        return "INSERT INTO registro (valorRegistro, dtHoraRegistro, fkComponente) " +
                "VALUES (%s, %s, %s)".formatted(looca.getGrupoDeDiscos().getVolumes().get(0).getTotal(), getTempo(), getIdComponente());
    }

    public Integer getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Integer idComponente) {
        this.idComponente = idComponente;
    }
}
