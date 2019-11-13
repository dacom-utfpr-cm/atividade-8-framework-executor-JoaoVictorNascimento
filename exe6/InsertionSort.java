package exe6;

import java.util.concurrent.Callable;

public class InsertionSort implements Callable<Integer[]> {
    Integer [] array;

    InsertionSort(Integer[] array) {
        this.array = array.clone();
    }

    void insertionSort(Integer[] array)
    {
        int i, key, j;
        for (i = 1; i < array.length; i++)
        {
            key = array[i];
            j = i - 1;

            while (j >= 0 && array[j] > key)
            {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    @Override
    public Integer[] call() {

        insertionSort(array);
        System.out.println("InsertionSort");
        return array;
    }
}
