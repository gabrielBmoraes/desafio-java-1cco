package org.example;

import org.example.banco.Conexao;
import org.example.hardware.CPU;
import org.example.hardware.RAM;
import org.example.logicaRegistro.Cliente;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.text.DecimalFormat;
import java.util.List;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leitorScanner = new Scanner(System.in);

        JdbcTemplate con = new Conexao().getConexao();
        List<Cliente> usuarioCadastrado = con.query("select * from cliente", new BeanPropertyRowMapper<>(Cliente.class));

        boolean usuarioValidacao = false;
        int posicaoUsuario = -1;

        do {
            System.out.println("""
            ====================
            Informe seu email:""");
            String respostaEmail = leitorScanner.nextLine();
            System.out.println("Informe sua senha:");
            String respostaSenha = leitorScanner.nextLine();

            for (int i = 0; i < usuarioCadastrado.size(); i++) {

                if (respostaEmail.equals(usuarioCadastrado.get(i).getEmail())
                        && respostaSenha.equals(usuarioCadastrado.get(i).getSenha())) {

                    System.out.println("\nlogin realizado com sucesso!\n");
                    posicaoUsuario = i;
                    break;


                } else if (!usuarioValidacao && i == (usuarioCadastrado.size() - 1)) {

                    System.out.println("\nE-mail e/ou senha incorretos!\n");
                }
            }
        }
        while (!usuarioValidacao);


        boolean mostrarMenu = true;

        while (mostrarMenu) {
            Scanner leitorNumero = new Scanner(System.in);
            System.out.println(
                    """
                    
                    O que deseja fazer?
                    Aperte:
            
                    1 - Capturar dados
                    2 - Visualizar dados
                    0 - sair
                    """
            );

            int respostaUsuario = leitorNumero.nextInt();


            if (respostaUsuario == 1) {

                System.out.println(
                        """
                        
                        Pressione para coletar dados de:
                        1 - CPU
                        2 - DISCO
                        3 - Memória Ram
                        0 - Voltar ao menu                                                             
                        """
                );

                respostaUsuario = leitorNumero.nextInt();

                switch (respostaUsuario) {
                    case 1:
                        CPU cpu = new CPU();
                        cpu.capturar()
                        break;
                    case 2:
                        RAM memoriaRam = new RAM();

                        System.out.println(memoriaRam);
                        con.update("insert into registro(valorRegistro) value (?)",
                                memoriaRam.getUso());

                        con.update("insert into registro(valorRegistro) values (?)",
                                memoriaRam.getDisponivel());

                        con.update("insert into registro(valorRegistro) values (?)",
                                memoriaRam.getTotal());
                        break;
                    case 3:
                        RAM memoriaRam = new RAM();

                        System.out.println(memoriaRam);
                        con.update("insert into registro(valorRegistro) value (?)",
                                memoriaRam.getUso());

                        con.update("insert into registro(valorRegistro) values (?)",
                                memoriaRam.getDisponivel());

                        con.update("insert into registro(valorRegistro) values (?)",
                                memoriaRam.getTotal());
                        break;
                    case 0:
                        System.out.println("voltando ao menu");
                        break;
                    default:
                        System.out.println("Resposta inválida!");
                        break;
                }

            } else if (respostaUsuario == 2){
                System.out.println(
                        """
                        Pressione para selecionar os dados de:
                        1 - CPU
                        2 - DISCO
                        3 - RAM
                        0 - Voltar ao menu         
                        """
                );

                respostaUsuario = leitorNumero.nextInt();

                switch (respostaUsuario){
                    case 1:
                        List<Registro> registrosCpu = con.query("select * from registro" +
                                " join recurso on tipoRecurso like 'Core%';", new BeanPropertyRowMapper<>(Registro.class));
                        System.out.println(registrosCpu);
                        break;
                    case 2:
                        List<Registro> registrosCpu = con.query("select * from registro" +
                                " join recurso on tipoRecurso = 'Leitura RAM';", new BeanPropertyRowMapper<>(Registro.class));
                        System.out.println(registrosCpu);
                        break;
                    case 3:
                        List<Registro> registrosCpu = con.query("select * from registro" +
                                " join recurso on tipoRecurso = 'Leitura RAM';", new BeanPropertyRowMapper<>(Registro.class));
                        System.out.println(registrosCpu);
                        break;
                    case 0:
                        System.out.println("voltando ao menu");
                    default:
                        System.out.println("Resposta inválida!");
                        break;
                }
            }  else if (respostaUsuario == 0) {
                System.out.println("Programa encerrado.");
                mostrarMenu = false;
                leitorScanner.close();
                leitorNumero.close();

            } else {
                System.out.println("Resposta inválida!");
            }

        }

    }
}