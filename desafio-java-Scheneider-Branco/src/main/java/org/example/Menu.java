package org.example;

import org.example.banco.Conexao;
import org.example.logicaRegistro.Cliente;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Scanner;

public class Menu {

    public Menu() {
    }

    public void menuLogin(){
        JdbcTemplate con = new Conexao().getConexao();
        List<Cliente> usuarioCadastrado = con.query("select * from login", new BeanPropertyRowMapper<>(Login.class));

        Scanner leitorScanner = new Scanner(System.in);
        System.out.println("=".repeat(30));
        System.out.println("Informe seu email: ");
        String email = leitorScanner.nextLine();
        System.out.println("Informe sua senha: ");
        String senha = leitorScanner.nextLine();


        for (int i = 0; i < usuarioCadastrado.size(); i++) {

            if (email.equals(usuarioCadastrado.get(i).getEmail())
                    && senha.equals(usuarioCadastrado.get(i).getSenha())) {

                System.out.println("\nlogin realizado com sucesso!\n");

            } else if (!(usuarioCadastrado && i == (usuarioCadastrado.size() - 1))) {
                System.out.println("\nE-mail e/ou senha incorretos!\n");
            }
        }

    }

    public boolean validarLogin(){
        return  true;
    }




}
