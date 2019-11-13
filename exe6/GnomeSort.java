package exe6;
import java.util.concurrent.Callable;

public class GnomeSort implements Callable<Integer[]> {
    int index = 0;
    Integer [] array;

    GnomeSort(Integer[] array) {
        this.array = array.clone();
    }

    void gnomeSort(Integer[] array) {
        while (index < array.length) {
            if (index == 0)
                index++;
            if (array[index] >= array[index - 1])
                index++;
            else {
                int aux = array[index];
                array[index] = array[index - 1];
                array[index - 1] = aux;
                index--;
            }
        }
    }


    @Override
    public Integer[] call() {

        gnomeSort(array);
        System.out.println("GnomeSort");
        return array;
    }
}
