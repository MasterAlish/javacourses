package labs.lab1.examples.textquest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alisher baike on 3/26/16.
 *
 * Класс помогающий предложить пользователя несколько действий
 * Позволяет выбрать только один из предложенных действий
 */
public class ActionChooser {
    private Map<String, String> actions = new HashMap<>();
    private String selectedAction = null;

    public void addAction(String actionText, String description) {
        actions.put(actionText, description);
    }

    public void start() {
        showAvailableActions();
        selectOneAction();
    }

    private void selectOneAction() {
        outer:while(true){
            selectedAction = null;
            String enteredAction = Console.getString("Введите действие: ");

            for(String action:actions.keySet()){
                if(action.toLowerCase().equals(enteredAction.toLowerCase().trim())){
                    selectedAction = action;
                    break outer;
                }
            }
        }
    }

    private void showAvailableActions() {
        Console.showText("Доступны действия:");
        for (String action: actions.keySet()){
            String description = actions.get(action);
            String text = String.format("- %s - %s", action, description);
            Console.showText(text);
        }
    }

    public String getSelectedAction() {
        return selectedAction;
    }
}
