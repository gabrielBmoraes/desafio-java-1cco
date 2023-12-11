package org.example;

import org.example.banco.Conexao;
import org.example.hardware.CPU;
import org.example.hardware.Componente;
import org.example.hardware.Disco;
import org.example.hardware.RAM;
import org.example.logicaRegistro.ClasseTimer;
import org.example.logicaRegistro.Cliente;
import org.example.logicaRegistro.Registro;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.text.DecimalFormat;
import java.util.List;

import java.util.Scanner;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {

        Scanner leitorScanner = new Scanner(System.in);

        JdbcTemplate con = new Conexao().getConexao();
        List<Cliente> usuarioCadastrado = con.query("select * from cliente", new BeanPropertyRowMapper<>(Cliente.class));

        boolean usuarioValidacao = false;
        int posicaoUsuario = -1;
        Integer idCliente = -1;

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
                    idCliente = usuarioCadastrado.get(posicaoUsuario).getIdCliente();
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
                        3 - RAM
                        0 - Voltar ao menu                                                             
                        """
                );

                respostaUsuario = leitorNumero.nextInt();

                switch (respostaUsuario) {
                    case 1:
                        CPU cpu = new CPU("cpu","%", idCliente);
                        capturarDados(cpu,con);
                        break;
                    case 2:

                        Disco disco = new Disco("disco","%", idCliente);
                        capturarDados(disco,con);
                        break;
                    case 3:
                        RAM memoriaRam = new RAM("ram","%", idCliente);
                        capturarDados(memoriaRam,con);
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
                        List<Registro> registrosCpu = con.query(
                                "select registro.* from registro join componente" +
                                        "on fkComponente = 1", new BeanPropertyRowMapper<>(Registro.class));
                        System.out.println(registrosCpu);
                        break;
                    case 2:
                        List<Registro> registrosDisco = con.query("select registro.* from registro" +
                                " join componente on fkComponente = 2;", new BeanPropertyRowMapper<>(Registro.class));
                        System.out.println(registrosDisco);
                        break;
                    case 3:
                        List<Registro> registrosRam = con.query("select registro.* from registro" +
                                "join componente on fkComponente = 3;", new BeanPropertyRowMapper<>(Registro.class));
                        System.out.println(registrosRam);
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

    public static void capturarDados(Componente componente, JdbcTemplate conexao){

        Scanner leitorQuantidade = new Scanner(System.in);
        Boolean capturar = true;
        TimerTask tempoCaptura = new TimerTask() {
            @Override
            public void run() {
                componente.capturar(conexao);
                System.out.println("Valor registrado com sucesso!");
            }
        };

        do {

            System.out.println("Informe a quantidade de tempo que deseja ficar capturando: ");
            Integer tempo = leitorQuantidade.nextInt();
            tempoCaptura.run();
            System.out.println("Digite 0 para sair, se não, continue esperando");
            tempo = leitorQuantidade.nextInt();

            if (tempo == 0){
                capturar  = false;
                System.out.println("Voltando ao menu!\n");
            }

        } while (capturar);
    }
}