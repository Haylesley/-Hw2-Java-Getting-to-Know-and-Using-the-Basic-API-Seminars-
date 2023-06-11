// Реализуйте алгоритм сортировки пузырьком числового массива,
// результат после каждой итерации запишите в лог-файл.

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class SecondTask {
    private static final Logger logger = Logger.getLogger(SecondTask.class.getName());
    public static void main(String[] args) throws IOException {
        FileHandler fh = new FileHandler("logTask2.txt");
        logger.setUseParentHandlers(false); // для того чтобы логи в консоль не выводить
        logger.addHandler(fh);

        SimpleFormatter sFormatter = new SimpleFormatter();
        fh.setFormatter(sFormatter);
        logger.info("Начало");

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            System.out.print("Введите числа массива: ");
            array[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(array));
        logger.info("Массив создан " + Arrays.toString(array));

        Bubble(array);
        System.out.println(Arrays.toString(array));
        logger.info("Массив отсортирован");

        sc.close();
    }

    public static void Bubble(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    int t = array[j];
                    array[j] = array[j+1];
                    array[j+1] = t;
                    logger.info(Arrays.toString(array));
                }
            }
        }
    }
}

