package seal.libs.redux;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс глобального хранилища.
 * Более подробное описания глобального хранилища представлено здесь:
 * <a href="https://redux.js.org/tutorials/fundamentals/part-4-store">Store</a>
 */
public class Store
{
    private State currentState;
    private Reducer reducer;
    private final List<Subscriber<State>> subscribers = new ArrayList<>();

    /**
     * Конструктор
     *
     * @param initialState исходное состояние сущности @see {@link State}
     * @param rootReducer корневой редьюсер, объединяющий частные редьюсеры @see {@link Reducer}
     */
    private Store(State initialState, Reducer rootReducer)
    {
        currentState = initialState;
        reducer = rootReducer;
    }

    /**
     * @return текущее состояние
     */
    public State getState()
    {
        return currentState;
    }


    /**
     * Реализация функционального интерфейса {@link seal.libs.redux.DispatchFunction}
     */
    @SuppressWarnings("unchecked")
    private final DispatchFunction dispatch = action -> {
        State oldState = currentState;
        State newState = reducer.reduce(this.currentState, (Action<Object>) action);

        if (oldState != newState && !oldState.equals(newState)) {
            currentState = newState;

            notifySubscribers();
        }
    };

    public void dispatch(Object action)
    {
        dispatch.accept(action);
    }

    /**
     * Метод добавления подписчиков
     *
     * @param subscriber подписчик @see {@link seal.libs.redux.Subscriber}
     * @return метод отписки
     */
    public Subscription subscribe(Subscriber<State> subscriber)
    {
        subscribers.add(subscriber);

        subscriber.onChange(currentState);

        return () -> subscribers.remove(subscriber);
    }

    /**
     * Метод оповещения подписчиков об изменеии состояния хранилища
     */
    private void notifySubscribers()
    {
        subscribers.forEach(subscriber -> subscriber.onChange(currentState));
    }

    /**
     * Статический метод для создания хранилища
     *
     * @param initialState изначальное состояние, принимаемое хранилищем в качестве базового состояния инициализации
     * @param rootReducer @see <a href="https://redux.js.org/tutorials/fundamentals/part-3-state-actions-reducers">
     *                    Redux Fundamentals, Part 3: State, Actions, and Reducers
     *                    </a>
     * @return новое хранилище.
     * Примечание: количество хранилищ в вашем проекте может быть не ограничено, однако эти хранилища не будут иметь
     * между собой никакой связи. Если есть необходимость в зависимостях модулей и их состояний между собой, следует
     * создать одно хранилище с несколькими редьюсерами
     */
    public static Store create(State initialState, Reducer rootReducer)
    {
        return new Store(initialState, rootReducer);
    }
}
