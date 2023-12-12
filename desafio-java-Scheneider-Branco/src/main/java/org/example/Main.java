package org.example;

import org.example.banco.BaseQuery;
import org.example.banco.Conexao;
import org.example.hardware.CPU;
import org.example.hardware.Componente;
import org.example.hardware.Disco;
import org.example.hardware.RAM;
import org.example.logicaRegistro.ClasseTimer;
import org.example.logicaRegistro.Cliente;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner leitorScanner = new Scanner(System.in);

        JdbcTemplate con = new Conexao().getConexao();
        BaseQuery mysql = new BaseQuery(con);

        List<Cliente> usuarioCadastrado = mysql.selectClienteTodos();
        Integer idCliente = -1;
        Boolean verificacaoLogin = true;
        int respostaUsuario;

        while (verificacaoLogin) {
            System.out.println("""
            ====================
            Informe seu email:
            """);

            String respostaEmail = leitorScanner.nextLine();
            System.out.println("Informe sua senha:");
            String respostaSenha = leitorScanner.nextLine();

            for (Cliente cliente :usuarioCadastrado) {
                if(respostaEmail.equalsIgnoreCase(cliente.getEmail()) && respostaSenha.equalsIgnoreCase(cliente.getSenha())){
                    System.out.println("\nlogin realizado com sucesso!\n");
                    idCliente = cliente.getIdCliente();
                    verificacaoLogin = false;
                }
            }
        }

        Scanner leitorNumero = new Scanner(System.in);

        System.out.println(
                """                               
                Pressione para coletar dados de:
                1 - CPU
                2 - DISCO
                3 - RAM
                4- Todos
                0 - Voltar ao menu                                                             
                """
            );

        respostaUsuario = leitorNumero.nextInt();

        List<Componente> componentes = mysql.selectComponenteCliente(idCliente);
        Timer timer = new Timer();

        CPU cpu = null;
        RAM memoriaRam= null;
        Disco disco = null;

        for (Componente componente: componentes) {
            if(componente.getNomeComponente().equalsIgnoreCase("CPU")){
                cpu = new CPU(componente.getIdComponente(), componente.getNomeComponente(), componente.getUnidadeMedida(), componente.getFkCliente());
            }
            else if (componente.getNomeComponente().equalsIgnoreCase("RAM")) {
                memoriaRam = new RAM(componente.getIdComponente(), componente.getNomeComponente(), componente.getUnidadeMedida(), componente.getFkCliente());
            }
            else {
                disco = new Disco(componente.getIdComponente(), componente.getNomeComponente(), componente.getUnidadeMedida(), componente.getFkCliente());
            }
        }

        ClasseTimer baseTimer = new ClasseTimer(cpu, memoriaRam, disco, con);



        switch (respostaUsuario) {
            case 1:
                timer.schedule(baseTimer.getTaskCPU(),0, 3000);
                break;
            case 2:
                timer.schedule(baseTimer.getTaskDisco(),0 , 3000);
                break;
            case 3:
                timer.schedule(baseTimer.getTaskRAM(),0, 3000);
                break;
            case 4:
                timer.schedule(baseTimer.getTaskCPU(),0, 3000);
                timer.schedule(baseTimer.getTaskDisco(),0, 3000);
                timer.schedule(baseTimer.getTaskRAM(),0, 3000);
                break;
            case 0:
                System.out.println("voltando ao menu");
                break;
                default:
                    System.out.println("Resposta inválida!");
                    break;
        }
    }
}