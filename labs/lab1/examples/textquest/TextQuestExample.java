package labs.lab1.examples.textquest;

/**
 * Created by Alisher baike on 3/26/16.
 */
public class TextQuestExample {
    private String userName;    //Имя игрока
    private boolean keyFound = false;   // Показывает нашел ли игрок ключ
    private boolean doorClosed = true;   //Показывает открыта ли дверь

    public static void main(String[] args) {
        TextQuestExample quest = new TextQuestExample();   //Создаем квест
        quest.start(); // запускаем
    }

    private void start() {
        Console.showText("Добро пожаловать в интересный мир текстовых квестов!");
        Console.showText("Ты побываешь в загадочном мире странных существ и испытаешь удовольсвие от игры, которое никогда раньше не испытывал!");
        Console.showText("");
        userName = Console.getString("__Кэрролл__: Как тебя зовут, мой юный друг?");
        Console.showText("");
        Console.showText("__Кэрролл__: Привет, "+userName+", меня зовут Кэрролл.\n__Кэрролл__: И я буду провожать тебя во время этого путешествия.");
        Console.showText("");
        Console.getString("__Кэрролл__: Ну что, "+userName+", ты со мной?");
        Console.showText("__Кэрролл__: Тогда, следуй за мной...");
        Console.showText("");
        Console.showText("Кэрролл ведет тебя в одну интересную комнату.");
        Console.showText("Ты видишь что комната очень красивая. Много разных устройств и украшений на разных стенах.");
        Console.showText("Удивленный красотой комнаты, ты поворачиваешься назад и видишь что Кэрролла нет.");
        Console.showText("'Ну и пусть. Он мне не нужен' - подумаешь ты.");
        Console.pause();
        Console.showText("Во время игры тебе будут предлагаться разные действия. \n" +
                "Чтобы выполнить какое-либо действие, тебе нужно выбрать одно из \n" +
                "предложенных действий и ввести его в консоль. \n" +
                "При этом будет написано:'Доступны действия:'. Например, сейчас ты можешь осмотреться в комнате.");
        Console.pause();

        lookAroundInTheRoom();
    }

    private void lookAroundInTheRoom() {
        while(doorClosed) {      // повторяем пока дверь закрыта
            Console.showText("Ты в комнате\n");
            ActionChooser actionChooser = new ActionChooser();
            actionChooser.addAction("Вверх", "посмотреть вверх");
            actionChooser.addAction("Вниз", "посмотреть вниз");
            actionChooser.addAction("Влево", "посмотреть влево");
            actionChooser.addAction("Вправо", "посмотреть вправо");
            actionChooser.addAction("Назад", "посмотреть назад");
            actionChooser.addAction("Вперед", "посмотреть вперед");
            actionChooser.start();
            String action = actionChooser.getSelectedAction();
            switch (action){   // в зависимости от введеного действия выполняем то или иное действие
                case "Влево":   //если action=='Влево'
                    Console.showText("Хмм. На этой стене нарисованы разные интересные животные.\n" +
                            " Красный от ярости кентавр. Розовый-прерозовый единорог. \n" +
                            "Русалка сидит на ветвях. А кота-ученого что-то не видно.");
                    break; // обязательно в конце каждого case нужно добавлять break
                case "Вверх":
                    solveTaskFromCheshir();
                    break;
                case "Вниз":
                    Console.showText("Внизу мыши одетые как люди ходят туда-сюда.");
                    Console.showText("Ты наклоняешься чтобы внимательно посмотреть на них");
                    Console.showText("И одна мышь кричит тебе пискливым голосом: ");
                    Console.showText("__Мышь__: Что ты смотришь на меня? Не видишь, что я работаю!");
                    Console.showText("\nТы просишь прощения и прекращаешь смотреть на них.");
                    break;
                case "Вправо":
                    tryToOpenBox();
                    break;
                case "Вперед":
                    tryToOpenDoorInFront();
                    break;
                case "Назад":
                    Console.showText("Сзади белая стена и ничего больше");
                    break;
            }
            Console.pause();
        }
        Console.showText("Ты тихонько заходишь в дверь. И там ты видишь...");
        Console.pause();
        Console.showText("Спасибо всем за игру! Чтобы узнать что было дальше, напишите продолжение сами! ");
    }

    private void tryToOpenBox() {
        if(keyFound){   //если ключ уже найден, то выводим текст этот
            Console.showText("На стенке открытый маленький ящик с экраном");
        }else {      //иначе, если ключ не найден, то пусть игрок открывает ящик
            boolean goBackChosen = false;
            Console.showText("На стенке ты видишь маленький ящик с экраном");
            Console.showText("На экране видны кнопочки с цифрами от 0 до 9");
            Console.showText("'Наверное нужно ввести пароль' - подумаешь ты");
            Console.pause();

            while (!goBackChosen && !keyFound) {
                ActionChooser actionChooser = new ActionChooser();
                actionChooser.addAction("Ввести", "ввести пароль");
                actionChooser.addAction("Назад", "отойти назад");
                actionChooser.start();
                String action = actionChooser.getSelectedAction();
                switch (action) {
                    case "Ввести":
                        String password = Console.getString("Пароль:");
                        if(password.equals("0398")){
                            keyFound = true;
                            Console.showText("Ящик издает много разных гудков и открывается");
                            Console.showText("В ящике ты видишь ключ и кладешь его в карман\n");
                        }else{
                            Console.showText("Ящик длинно пищит и ничего не происходит\n");
                        }
                        break;
                    case "Назад":
                        Console.showText("Ты отошел назад");
                        goBackChosen = true;
                        break;
                }
            }
        }
    }

    private void solveTaskFromCheshir() {
        Console.showText("Ты смотришь вверх и тебе кто-то улыбается\n" +
                "И ты видишь как медленно появляется улыбающийся черный кот\n" +
                "'Ух тыы, какой классный чувак' - думаешь ты\n" +
                "И этот кот говорит тебе:");
        Console.pause();
        Console.showText("__Чеширский кот__: Привет, "+userName+", Отгадай мою загадку:");
        Console.showText("__Чеширский кот__: Кто на свете всех милее, всех красивее и белее?");

        Answerer answerer = new Answerer();   // это класс, который помогает нам узнать правильно ли ответил игрок
        answerer.setPrefix("__Чеширский кот__:");
        answerer.addRightAnswer("Белоснежка");
        answerer.addRightAnswer("Я");
        answerer.start();

        String answer = answerer.getAnswer();

        if(answer == null){ //если игрок не дал правильного ответа
            Console.showText("__Чеширский кот__: Ну ладно, немного подумай, потом приходи");
        }else{     //иначе, если игрок дал правильный ответ
            if(answer.equals("Я")) {    // если его ответ Я
                Console.showText("У кота улыбка еще сильнее увеличивается )))\n");
            }
            Console.showText("__Чеширский кот__: Правильно! Вот тебе секретный код: 0398 ");
            Console.showText("__Чеширский кот__: Он поможет тебе когда нибудь ");
        }
        Console.showText("\nСтранный кот медленно исчезает из виду");
    }

    private void tryToOpenDoorInFront() {
        boolean goBackChosen = false;  // показывает выбрал ли пользователь действия "назад"
        while(!goBackChosen && doorClosed) {   //повторять пока пользователь не выберет "Назад" и дверь закрыта
            Console.showText("Впереди какая-то сверкающая дверь высотой около полуметра.\n");
            ActionChooser actionChooser = new ActionChooser();
            actionChooser.addAction("Толкнуть", "Толкнуть дверь чтобы проверить открыта ли она");
            if(keyFound) {  // Если игрок уже нашел ключ, то добавляем еще одно действие
                actionChooser.addAction("Ключ", "Открыть дверь найденным ключом");
            }
            actionChooser.addAction("Назад", "Отойти назад");
            actionChooser.start();
            String action = actionChooser.getSelectedAction();
            switch (action){
                case "Толкнуть":
                    Console.showText("Дверь даже не шелохнулась. \n" +
                            "И ты видишь что в двери есть маленькое отверствие для ключа.");

                    Console.pause();
                    break;
                case "Ключ":
                    doorClosed = false;
                    Console.showText("Дверь со скрипом открывается.");
                    Console.pause();
                    Console.showText("Вдруг дверь начинает увеличиваться.");
                    Console.showText("Ты в недоумении осматриваешься и понимаешь");
                    Console.showText("Что не дверь увеличивается, а ты уменьшаешься");
                    Console.showText("Теперь ты достаточно маленький чтобы пройти через дверь");
                    break;
                case "Назад":
                    Console.showText("Ты отошел назад");
                    goBackChosen = true;
                    break;
            }
        }
    }
}
