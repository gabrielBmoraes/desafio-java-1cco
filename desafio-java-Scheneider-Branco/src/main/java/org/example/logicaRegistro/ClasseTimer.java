package org.example.logicaRegistro;

import org.example.hardware.CPU;
import org.example.hardware.Disco;
import org.example.hardware.RAM;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.TimerTask;

public class ClasseTimer {
    private TimerTask taskCPU;
    private TimerTask taskRAM;
    private TimerTask taskDisco;

    public ClasseTimer(CPU cpu, RAM ram, Disco disco, JdbcTemplate conexao) {
        taskCPU = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Guardando CPU");
                cpu.capturar(conexao, cpu.getIdComponente());
            }
        };

        taskRAM = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Guardando RAM");
                ram.capturar(conexao, ram.getIdComponente());
            }
        };
        taskDisco = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Guardando Disco");
                disco.capturar(conexao, disco.getIdComponente());
            }
        };
    }

    public ClasseTimer(JdbcTemplate conexao, RAM ram) {
        taskRAM = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Guardando RAM");
                ram.capturar(conexao, ram.getIdComponente());
            }
        };
    }

    public TimerTask getTaskCPU() {
        return taskCPU;
    }

    public void setTaskCPU(TimerTask taskCPU) {
        this.taskCPU = taskCPU;
    }

    public TimerTask getTaskRAM() {
        return taskRAM;
    }

    public TimerTask getTaskDisco() {
        return taskDisco;
    }
}
