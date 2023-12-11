package org.example.hardware;

import org.example.logicaRegistro.Alerta;
import org.springframework.jdbc.core.JdbcTemplate;

public class CPU extends Componente{


    public CPU( String nomeComponente, String unidadeMedida, Integer fkCliente) {
        super(nomeComponente, unidadeMedida, fkCliente);
    }

    @Override
    public void capturar(JdbcTemplate conexao) {


        Double valorRegistro = looca.getProcessador().getUso();



        conexao.execute("INSERT INTO registro (valorRegistro, dtHoraRegistro, fkComponente) " +
                    "VALUES (%d, %s, %d);").formatted(looca.getProcessador().getUso(), getTempo(),1));

        if (valorRegistro > 80){
            Alerta alerta = null;

            System.out.println(alerta.getAlerta());
        }

    };

}
