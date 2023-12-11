package org.example.logicaRegistro;

public class Cliente {

    private Integer idCliente;
    private String email;
    private String senha;

    public Cliente(Integer idCliente, String email, String senha) {
        this.idCliente = idCliente;
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
}
