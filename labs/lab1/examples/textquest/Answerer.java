package labs.lab1.examples.textquest;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alisher baike on 3/26/16.
 *
 * Этот класс помогает задать вопрос игроку
 * и узнать правильно ли ответил игрок
 *
 * При этом мы должны указать все правильные варианты ответов
 */
public class Answerer {
    // В этом множестве - мы храним все правильные ответы
    private Set<String> rightAnswers = new HashSet<>();
    private String answer = null; // ответ пользователя будет храниться здесь
    private String prefix = "";
    private String wrongAnswerText = "Ответ неправильный"; //Текст который выводится, если ответ неправльный

    /**
     * Добавляет правильный ответ во множетсво правильных ответов
     */
    public void addRightAnswer(String answer) {
        rightAnswers.add(answer);
    }

    public void start() {
        askUserToAnswer();
    }

    private void askUserToAnswer() {
        answer = null;
        outer:while(true){ // повторяем бесконечно
            String enteredAnswer = Console.getString("Введите ответ или напишите 'Сдаюсь': ");

            //toLowerCase() - делает строку в нижнем регистре
            if(enteredAnswer.toLowerCase().equals("сдаюсь")){
                break;
            }

            for (String rightAnswer: rightAnswers){  // перебираем все правильные ответы
                if(rightAnswer.toLowerCase().equals(enteredAnswer.toLowerCase())){  //если введенный ответ совпал с одном из правильных
                    answer = rightAnswer;
                    break outer; // то, выходит из цикла outer
                }
            }
            // если ответ был неправльным, выводим текст неправльного ответа
            Console.showText(prefix+" "+ wrongAnswerText);
        }
    }

    /**
     * Возвращает введеный пользоветем ответ
     */
    public String getAnswer() {
        return answer;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setWrongAnswerText(String wrongAnswerText) {
        this.wrongAnswerText = wrongAnswerText;
    }
}
