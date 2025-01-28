package seal.libs.redux;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

/**
 * Класс RootReducer реализует интерфейс Reducer и управляет состоянием приложения,
 * используя контейнеры редьюсеров.
 * <p>
 * Конструктор класса принимает массив контейнеров редьюсеров и инициализирует
 * начальное состояние, извлекая состояние из каждого редьюсера.
 **/
public class RootReducer implements Reducer {
    private InitialState initialState = new InitialState();
    private ReducerContainer[] reducerContainers;

    public RootReducer(ReducerContainer @NotNull ...containers ) {
        this.reducerContainers = containers.clone();
        for (ReducerContainer container : containers) {
            initialState.put(container.getName(), container.getReducer().getState());
        }
    }

    /**
     * Получает текущее состояние.
     *
     * @return текущее состояние типа State.
     */
    @Override
    public State getState() {
        return initialState;
    }

    /**
     * Устанавливает начальное состояние для объекта.
     *
     * @param state объект состояния, который будет установлен в качестве начального.
     */
    @Override
    public void setInitialState(State state) {
        //
    }

    /**
     * Метод reduce применяет заданное действие к текущему состоянию, обновляя его на основе
     * редюсеров, содержащихся в контейнерах редюсеров.
     *
     * @param action действие, которое будет применено к текущему состоянию
     * @return обновленное состояние после применения действия
     */
    @Override
    public State reduce(Action<Object> action) {
        for (ReducerContainer container : reducerContainers) {
            initialState.put(container.getName(), container.getReducer().reduce(action));
        }

        return initialState;
    }

    /**
     * Класс InitialState представляет собой реализацию состояния,
     * которое расширяет функциональность HashMap, где ключами
     * являются строки, а значениями - объекты типа State.
     * Этот класс служит для хранения и управления состояниями
     * в виде пар "ключ-значение", позволяя легко добавлять,
     * удалять и извлекать состояния по их уникальным идентификаторам.
     * <p>
     * InitialState реализует интерфейс State, что позволяет
     * использовать его в контексте, где требуется взаимодействие
     * с состоянием, обеспечивая гибкость и возможность
     * расширения функциональности.
     */
    public class InitialState extends HashMap<String, State> implements State {}
}
