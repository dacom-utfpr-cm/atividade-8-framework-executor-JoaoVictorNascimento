/*
    Autor: João Victor Nascimento
    RA: 1817442
    Descrição: Faça um programa que execute três algoritmos de ordenação para um conjunto de valores e exiba o resultado apenas do algoritmo que finalizar primeiro (use invokeAny ).
 */

package exe6;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Integer[] array = new Integer[] { 3, 4, 7, 2, 9 };

        List<Callable<Integer[]>> tasks = new ArrayList<Callable<Integer[]>>();

        tasks.add(new InsertionSort(array));
        tasks.add(new GnomeSort(array));
        tasks.add(new QuickSort(array));


        try {
            Integer[] result = executor.invokeAny(tasks);
            System.out.println(Arrays.toString(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }

}

