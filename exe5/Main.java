/*
    Autor: João Victor Nascimento
    RA: 1817442
    Descrição: Faça um programa que possibilite agendar uma tarefa para ser executada em um horário especı́fico.
 */
package exe5;

import java.util.Date;
import java.util.Calendar;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;

public class Main {

    public static void main(String[] args) {


        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, 14);
        calendar.set(Calendar.MINUTE, 05);
        long seconds = (calendar.getTime().getTime() - new Date().getTime()) / 1000;

        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture future = executor.schedule(new Runnable(){

            @Override public void run() {
                System.out.println("Schedule in : " + new Date().toString());
            }
        }, seconds, TimeUnit.SECONDS);
        try {
            future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Done!");
        executor.shutdown();
    }

}
