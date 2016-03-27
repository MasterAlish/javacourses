package labs.lab1.examples.matrix;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Alisher baike on 3/26/16.
 *
 * Массивы это список элементов. Например:
 *
 * 9 3 2 3 4  -  это массив целых чисел
 *
 * В Java массивы выглядят так:
 *
 * int[] array; - это массив целых чисел
 *
 * Инициализируется так:
 * int[] array2 = new int[10]; 10 - это размер массива
 *
 * array2[3] = 3; так мы можем менять значения массива
 */
public class ArrayExample {
    public static void main(String[] args) {
        ArrayExample example = new ArrayExample();   // Создаем объект нашего класса
        example.run(); // и вызываем метод run()
    }

    Scanner scanner = new Scanner(System.in);

    private void run() {
        int[] array1 = readArray("1");
        showArray(array1);
        int[] array2 = readArray("2");
        showArray(array2);

        System.out.println("Сумма двух массивов:");
        int[] sum = sumArrays(array1, array2);
        showArray(sum);
    }

    private int[] sumArrays(int[]  array1, int[] array2) {
        if(array1.length != array2.length) {
            System.err.println("Складывать матрицы разных размеров нельзя");
        }

        int len = array1.length <= array2.length ? array1.length : array2.length; // выбираем наименьшую длину
        int[] sum = new int[len]; // создаем новый массив

        for(int j=0;j<sum.length;j++){           // повторяем для каждого элемента
            sum[j] = array1[j] + array2[j];  // суммируем элементы под индексом j двух массивов
        }
        return sum;
    }

    private int[] readArray(String name) {  // Метод позволяет считать массив из консоля
        System.out.println("Введите длину матрицы "+name+":");
        int l = scanner.nextInt();
        System.out.println("Введите элементы матрицы "+name+":");
        int[] array = new int[l]; // создаем массив с размером l
        for(int j=0; j<l;j++){
            array[j] = scanner.nextInt();  // введеное числе сохраняем в ячейке j массива
        }
        return array;
    }

    private void showArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
