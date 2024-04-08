package com.pedro.hilos.ejemtimer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class EjemploAgendaTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Tare realizada en: "+new Date()+"Nombre del hilo: "+
                        Thread.currentThread().getName());
                System.out.println("Finalizado el timepo");
                timer.cancel();

            }
        }, 10000);

        System.out.println("Programando tarea para 5 segundos...");
    }
}
