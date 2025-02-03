
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int n = sc.nextInt();
        int[][] array = new int[n][n]; // Создаем двумерный массив

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = sc.nextInt(); // Читаем элементы массива
            }
        }
        printArray(array);
        sortArray(array); // Сортируем побочную диагональ
        System.out.println("Массив после сортировки побочной диагонали:");
        printArray(array); // Выводим отсортированный массив
    }

    public static void sortArray(int[][] array) {
        int n = array.length;

        // Собираем элементы побочной диагонали в массив
        int[] diagonal = new int[n];
        for (int i = 0; i < n; i++) {
            diagonal[i] = array[i][n - 1 - i];
        }

        // Сортировка методом выбора
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (diagonal[j] < diagonal[minIndex]) {
                    minIndex = j;
                }
            }
            // Меняем местами
            int temp = diagonal[minIndex];
            diagonal[minIndex] = diagonal[i];
            diagonal[i] = temp;
        }

        // Возвращаем отсортированные элементы на побочную диагональ
        for (int i = 0; i < n; i++) {
            array[i][n - 1 - i] = diagonal[i];
        }
    }

    public static void printArray(int[][] array) {
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }
    }
}

