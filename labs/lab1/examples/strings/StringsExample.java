package labs.lab1.examples.strings;

import java.util.Scanner;

/**
 * Created by Alisher baike on 3/26/16.
 */
public class StringsExample {
    public static void main(String[] args) {
        String text = ""; // Вначале наш текст пустой
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ваш текст из нескольких строк. Нажмите Enter два раза чтобы закончить:");

        while(true){                           // в цикле
            String line = scanner.nextLine();  //считываем строчку, которую ввел пользователь
            if(line.isEmpty()){  //если строчка пустаю,
                break;           // завершаем цикл
            }else{         // иначе
                text = text + "\n"+ line; //добавляем считанную строчку в наш текст
                //   \n - это знак переноса строки
            }
        }

        StringWorker stringWorker = new StringWorker(); //создаем обработчик текст
        stringWorker.setText(text); // передаем наш текст
        stringWorker.run(); // запускаем его
    }
}
