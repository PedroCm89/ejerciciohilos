package com.pedro.hilos.ejemtimer;

import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploAgendaTimerPeriodo {
    public static void main(String[] args) {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        AtomicInteger contadorAtomi=new AtomicInteger(3);
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            //private int contador = 3;
            @Override
            public void run() {

                if (contadorAtomi.getAndDecrement()>0) {
                    toolkit.beep();
                    System.out.println("Tare periodica "+contadorAtomi+" en: " + new Date() + "Nombre del hilo: " +
                            Thread.currentThread().getName());
                    //contador--;
                }else{
                    System.out.println("Finalizado el timepo");
                    timer.cancel();
                }
            }
        }, 1000,2000);

        System.out.println("Programando tarea para 5 segundos mas...");
    }
}
