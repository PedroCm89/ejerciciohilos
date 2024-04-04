package com.pedro.hilos.ejemplosync;

import com.pedro.hilos.ejemplosync.runnable.Consumidor;
import com.pedro.hilos.ejemplosync.runnable.Panadero;

public class EjemploProductoConsumidor {
    public static void main(String[] args) {
        Panaderia p = new Panaderia();
        new Thread(new Panadero(p)).start();
        new Thread(new Consumidor(p)).start();

    }
}
