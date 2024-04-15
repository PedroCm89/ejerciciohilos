package com.pedro.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {


        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);

        System.out.println("El tamaño del pool es: "+executorService.getCorePoolSize());
        System.out.println("Cantidad de tareas en cola : "+executorService.getQueue().size());


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
        Callable<Integer>tarea2=()->{
            System.out.println("Iniciando tarea 2...");
            TimeUnit.SECONDS.sleep(2);
            return 10;
        };
        Future<String> resultado = executorService.submit(tarea);
        Future<String> resultado2 = executorService.submit(tarea);
        Future<Integer> resultado3 = executorService.submit(tarea2);
        System.out.println("El tamaño del pool es: "+executorService.getCorePoolSize());
        System.out.println("Cantidad de tareas en cola : "+executorService.getQueue().size());
        executorService.shutdown();
        System.out.println("Continuando con el metodo main 1...");

        //System.out.println(resultado.isDone());
        while (!(resultado.isDone() && resultado2.isDone() && resultado3.isDone())){
            System.out.println(String.format("resultado 1: %s, resultado2: %s, resultado3: %s",
                    resultado.isDone()? "finalizado": "en proceso",
                    resultado2.isDone()? "finalizado": "en proceso",
                    resultado3.isDone()? "finalizado": "en proceso"));
            TimeUnit.MILLISECONDS.sleep(1000);
        }
        System.out.println(resultado.get());
        System.out.println(resultado3.get());
        System.out.println(resultado.isDone());
    }
}
