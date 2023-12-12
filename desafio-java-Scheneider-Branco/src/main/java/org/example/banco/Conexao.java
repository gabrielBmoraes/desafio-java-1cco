package org.example.banco;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class Conexao {
    private JdbcTemplate conexao;

    public Conexao() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/%s".formatted("desafioJava"));
        dataSource.setUsername("root");
        dataSource.setPassword("");
        this.conexao = new JdbcTemplate(dataSource);
    }
    public JdbcTemplate getConexao(){
        return conexao;
    }
}