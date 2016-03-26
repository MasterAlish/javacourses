package labs.lab1.examples.matrix;

import java.util.Scanner;

/**
 * Created by Alisher baike on 3/26/16.
 *
 * Матрицы это двумерные массивы. Например:
 *
 * 0 0 1 1 2
 * 9 3 2 3 4  -  это матрица размером 5х3
 * 2 3 4 3 3
 *
 * Инфо про матрицы: http://www.mathprofi.ru/deistviya_s_matricami.html
 *
 * В Java матрицы это массивы массивов:
 *
 * int[] array; - это массив целых чисел
 * int[][] matrix; - а это массив массивов целых чисел
 *
 * Если это один массив: 0 0 1 1 2
 * А это второй массив: 9 3 2 3 4
 *
 * То массив состоящий из этих двух массивов:
 * 0 0 1 1 2
 * 9 3 2 3 4  -  это матрица
 *
 * Матрицы в Java: http://study-java.ru/uroki-java/urok-12-mnogomerny-e-massivy-v-java/
 */
public class MatrixExample {
    public static void main(String[] args) {
        MatrixExample example = new MatrixExample();   // Создаем объект нашего класса
        example.run(); // и вызываем метод run()
    }

    Scanner scanner = new Scanner(System.in);

    private void run() {
        int[][] matrix1 = readMatrix("1");
        showMatrix(matrix1);
        int[][] matrix2 = readMatrix("2");
        showMatrix(matrix2);

        System.out.println("Сумма двух матриц:");
        int[][] sum = sumMatrixes(matrix1, matrix2);
        showMatrix(sum);
    }

    private int[][] sumMatrixes(int[][] matrix1, int[][] matrix2) {
        int[][] sum = new int[matrix1.length][]; // создаем новый массив массивов без внутренних массивов

        for(int j=0;j<sum.length;j++){           // повторяем для каждой строчки нового массива
            sum[j] = new int[matrix1[j].length]; // создаем новые массивы для каждой строчки
            for(int i=0; i<sum[j].length; i++){  // повторяем для каждого элемента внутреннего массива
                sum[j][i] = matrix1[j][i]+matrix2[j][i];  // суммируем элементы под индексом i,j двух матриц
            }
        }
        return sum;
    }

    private int[][] readMatrix(String name) {  // Метод позволяет считать матрицы из консоля
        System.out.println("Введите ширину матрицы "+name+":");
        int x = scanner.nextInt();
        System.out.println("Введите высоту матрицы "+name+":");
        int y = scanner.nextInt();
        System.out.println("Введите элементы матрицы "+name+":");
        int[][] matrix = new int[y][x]; // создаем двумерный массив с размером y на x
        for(int j=0; j<y;j++){          // повторяем для всех строк
            for(int i=0;i<x;i++){       //повторяем для всех колонок
                matrix[j][i] = scanner.nextInt();  // введеное числе сохраняем в ячейке j,i матрицы
            }
        }
        return matrix;
    }

    private void showMatrix(int[][] matrix) {
        for (int[] array : matrix) {       // перебираем все массивы в матрице
            for (int number : array) {     // перебирваем все элементы в массиве
                System.out.print(number);  // печатаем текущий элемент
                System.out.print("\t");    // после элемента добавляем TAB
            }
            System.out.println();  // после каждой строки переходим на новую строчку
        }
    }
}
