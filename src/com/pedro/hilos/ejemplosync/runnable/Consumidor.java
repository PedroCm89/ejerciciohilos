package com.pedro.hilos.ejemplosync.runnable;

import com.pedro.hilos.ejemplosync.Panaderia;

public class Consumidor implements Runnable{

    private Panaderia panaderia;

    public Consumidor(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    @Override
    public void run() {
        for(int i=0;i<=0;i++){
            panaderia.consumir();
        }
    }
}