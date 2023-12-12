package org.example.banco;

import org.example.hardware.Componente;
import org.example.hardware.RAM;
import org.example.logicaRegistro.Cliente;
import org.example.logicaRegistro.Registro;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BaseQuery {
    private JdbcTemplate connection;

    public BaseQuery(JdbcTemplate connection) {
        this.connection = connection;
    }

    public void cadastrar(Registro registro){
        connection.update("INSERT INTO registro (valor_registro, data_registro, fk_componente, fk_medida) " +
                "VALUES (?, ?, ?)", registro.getValorRegistro(), registro.getDataRegistro(), registro.getFkComponente());
    }

    public List<Cliente> selectClienteTodos(){
        return connection.query("SELECT * FROM Cliente", new BeanPropertyRowMapper<>(Cliente.class));
    }

    public List<Componente> selectComponenteCliente(Integer fk_cliente){
        return connection.query("SELECT * FROM componente WHERE fkCliente = %s".formatted(fk_cliente), new BeanPropertyRowMapper<>(Componente.class));
    }
}