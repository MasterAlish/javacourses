package lectures.collections;

import java.util.*;

/**
 * Created by alisher on 3/24/16.
 */
public class Main {
    public static void main(String[] args) {
        Map<String, String> info = new HashMap<>();

        info.put("Имя", "Рапцнель");
        info.put("Должность", "Принцесса");
        info.put("Особенность", "Волшебные волосы");
        info.put("Родина", "Арендел");

        for(String key: info.keySet()){
            String value = info.get(key);
            System.out.println(key+": "+value);
        }

        Queue<Задача> очередь = new LinkedList<Задача>();

        очередь.add(new Задача("Какая то задача 1"));
        Задача задача2 = new Задача("задача 2");
        очередь.add(задача2); // один и тот же элемент
        очередь.add(задача2); // можно несколько раз добавлять

        while (!очередь.isEmpty()){
            Задача текущаяЗадача = очередь.poll();
            текущаяЗадача.запустить();
        }
        try {
            очередь.element();
        } catch(NoSuchElementException e){ //Элементов нет
            System.out.print("Очередь пустая");
        } catch(NullPointerException e){ // Очередь не инициализирована
            System.out.print("Очередь еще не создана");
        }
    }
}
