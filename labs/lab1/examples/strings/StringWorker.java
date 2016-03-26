package labs.lab1.examples.strings;

import java.util.Scanner;

/**
 * Created by Alisher baike on 3/26/16.
 *
 * Класс находит слово в тексте и заменяет его
 */
public class StringWorker {
    private String text;   // здесь будет хранится основной текст

    public void setText(String text) {
        this.text = text;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введенный вами текст:");
        System.out.println(text);
        System.out.println("");
        System.out.println("Введите слово для поиска:");
        String word = scanner.nextLine();     // считываем слово для поиска

        if(text.contains(word)){    // если наш текст содержит это слово
            int count = foundsCount(text, word);    // считаем количество
            System.out.println("Введенное слово встречается в тексте: "+count+ " раз");
        }else{    //иначе
            System.out.println("Введенное слово не найдено в тексте");
            return;  // выходим их метода
        }
        System.out.println("");
        System.out.println("Введите слово которым хотите заменить найденное слово:");
        String replace = scanner.nextLine();   // считываем заменяющее слово
        String newText = text.replace(word, replace);  //заменяем в тексте все слова на новое, и получаем новый текст
        System.out.println("");
        System.out.println("Текст полученный после замены:");
        System.out.println(newText);

    }

    private int foundsCount(String text, String word) {
        int count = 0;     // сначала кол-во равно 0
        int lastIndex = -1; // индекс последнего найденного места
        while(true){        //в цикле ищем все места где встрачается искомое слово
            lastIndex = text.indexOf(word, lastIndex+1);  //находим индекс слова, начиная от последнего индекса
            if(lastIndex==-1){  // если индекс равен -1, значит слово больше не найдено
                break;          // выходим из цикла
            }else{
                count++;     // если слово найдено, увеличиваем счетчик
            }
        }
        return count;
    }
}
