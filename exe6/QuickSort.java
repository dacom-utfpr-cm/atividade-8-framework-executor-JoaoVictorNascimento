package exe6;
import java.util.concurrent.Callable;

public class QuickSort implements Callable<Integer[]> {
    Integer[] array;

    QuickSort(Integer[] array) {
        this.array = array.clone();
    }

    void quickSort(Integer[] vet, int startPos, int endPos) {
        if (startPos < endPos) {
            int pivo = findPivo(vet, startPos, endPos);
            quickSort(vet, startPos, pivo - 1);
            quickSort(vet, pivo + 1, endPos);
        }
    }

    int findPivo(Integer[] vector, int startPos, int endPos) {
        int pivo = vector[startPos];
        int b = startPos + 1;
        int e = endPos;

        while (b <= e) {
            if (vector[b] <= pivo) {
                b++;
            } else if (pivo < vector[e]) {
                e--;
            } else {
                int temp = vector[b];
                vector[b] = vector[e];
                vector[e] = temp;
                b++;
                e--;
            }
        }
        vector[startPos] = vector[e];
        vector[e] = pivo;
        return e;
    }

    @Override
    public Integer[] call() {

        quickSort(array, 0, array.length - 1);
        System.out.println("QuickSort");
        return array;
    }
}
