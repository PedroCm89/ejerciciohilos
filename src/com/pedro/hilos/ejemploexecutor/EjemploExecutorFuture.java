package com.pedro.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> tarea =()->{
            System.out.println("Inicio de tarea...");
            try {
                System.out.println(Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("Finalizada la tarea.");
            return "Algun resultado importante de la tarea";
        };
        Future<String> resultado = executorService.submit(tarea);
        executorService.shutdown();
        System.out.println("Continuando con el metodo main 1...");

        //System.out.println(resultado.isDone());
        while (!resultado.isDone()){
            System.out.println("Ejecutando la tarea.");
            TimeUnit.MILLISECONDS.sleep(1500);
        }
        System.out.println(resultado.get());
        System.out.println(resultado.isDone());
    }
}
