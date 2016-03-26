package labs.lab1.examples.textquest;

import java.util.Scanner;

/**
 * Created by Alisher baike on 3/26/16.
 *
 * Этот класс помогает нам взаимодействовать с пользователем через консоль
 */
public class Console {
    private static String prefix = "> ";
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Этот метод выводит текст пользователю
     * И ждет пока пользователь что-то напишет
     * И возвращает введеный текст
     */
    public static String getString(String prompt){
        System.out.println(prompt);
        System.out.print(prefix);
        return scanner.nextLine();
    }

    /**
     * Выводит текст на консоль
     */
    public static void showText(String text){
        System.out.println(text);
    }

    /**
     * prefix - это строка которая показывается, когда пользователь что-то должен ввести
     */
    public static void setPrefix(String prefix) {
        Console.prefix = prefix;
    }

    /**
     * Этот метод ожидает пока пользователь нажмет Enter
     * или напишет любую строчку
     */
    public static void pause() {
        System.out.println("\n...Нажите Enter чтобы продолжить...");
        scanner.nextLine();
    }
}
