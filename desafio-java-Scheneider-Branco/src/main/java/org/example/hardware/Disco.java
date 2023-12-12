package org.example.hardware;

import org.example.logicaRegistro.Alerta;
import org.springframework.jdbc.core.JdbcTemplate;

public class Disco extends Componente{
    public Disco(Integer idComponente, String nomeComponente, String unidadeMedida, Integer fkCliente) {
        super(idComponente, nomeComponente, unidadeMedida, fkCliente);
    }


    @Override
    public void capturar(JdbcTemplate conexao, Integer fkComponente) {
        Long valorRegistro = looca.getGrupoDeDiscos().getVolumes().get(0).getTotal();

        if(valorRegistro > 70){
            System.out.println(Alerta.valueOf("MEDIO"));
        } else if (valorRegistro > 50) {
            System.out.println(Alerta.valueOf("ALTO"));
        }
        else{
            System.out.println(Alerta.valueOf("BAIXO"));
        }

        conexao.execute("INSERT INTO registro (valorRegistro, dtHoraRegistro, fkComponente) " +
                "VALUES (%s, '%s', %s);".formatted( Math.round(valorRegistro), getTempo(), getIdComponente()));
    }
}
