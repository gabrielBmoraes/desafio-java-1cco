package org.example.logicaRegistro;

public enum Alerta {
    ALTO("ALERTA PERIGO ALTO"),
    MEDIO("ALERTA MEDIO"),
    BAIXO("TUDO NOS CONFORMES");

    private String alerta;

    Alerta(String alerta) {
        this.alerta = alerta;
    }

    public String getAlerta(){
        return alerta;
    }
}