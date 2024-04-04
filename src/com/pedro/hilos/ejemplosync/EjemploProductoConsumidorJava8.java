package com.pedro.hilos.ejemplosync;

import com.pedro.hilos.ejemplosync.runnable.Consumidor;
import com.pedro.hilos.ejemplosync.runnable.Panadero;

import java.util.concurrent.ThreadLocalRandom;

public class EjemploProductoConsumidorJava8 {
    public static void main(String[] args) {
        Panaderia p = new Panaderia();

        new Thread(() -> {
            for (int i = 0; i <= 10; i++) {
                p.hornear("Pan nª: " + i);
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500, 1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i <= 0; i++) {
                p.consumir();
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(200,500));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

    }
}
