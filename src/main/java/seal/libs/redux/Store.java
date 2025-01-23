package seal.libs.redux;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import seal.libs.redux.config.ReduxConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс глобального хранилища.
 * Более подробное описания глобального хранилища представлено здесь:
 * <a href="https://redux.js.org/tutorials/fundamentals/part-4-store">Store</a>
 */
public class Store {
    private State currentState;
    private Reducer reducer;
    private ReduxConfig config;
    private final List<Subscriber<State>> subscribers = new ArrayList<>();

    @Deprecated
    private Store(State initialState, Reducer rootReducer, ReduxConfig config) {
        currentState = initialState;
        reducer = rootReducer;
        this.config = config;
    }

    private Store(@NotNull Reducer rootReducer, ReduxConfig config) {
        currentState = rootReducer.getState();
        reducer = rootReducer;
        this.config = config;
    }

    /**
     * @return текущее состояние
     */
    public State getState() {
        return currentState;
    }


    /**
     * Реализация функционального интерфейса {@link seal.libs.redux.DispatchFunction}
     */
    @SuppressWarnings("unchecked")
    private final DispatchFunction dispatch = action -> {
        State oldState = currentState;
        State newState = reducer.reduce(this.currentState, (Action<Object>) action);

        if (!oldState.equals(newState)) {
            currentState = newState;

            notifySubscribers((Action<Object>) action);
        }
    };

    public void dispatch(Object action) {
        dispatch.accept(action);
    }

    /**
     * Метод добавления подписчиков
     *
     * @param subscriber подписчик @see {@link seal.libs.redux.Subscriber}
     * @return метод отписки
     */
    public Subscription subscribe(Subscriber<State> subscriber) {
        subscribers.add(subscriber);

//        subscriber.onChange(currentState);

        return () -> subscribers.remove(subscriber);
    }

    public void setSubscribers(@NotNull List<Subscriber<State>> subscribers) {
        this.subscribers.addAll(subscribers);
    }

    /**
     * Метод оповещения подписчиков об изменеии состояния хранилища
     */
    private void notifySubscribers(Action<Object> action) {
        subscribers.forEach(subscriber -> subscriber.onChange(action, currentState));
    }

    /**
     * Статический метод для создания хранилища
     *
     * @param initialState изначальное состояние, принимаемое хранилищем в качестве базового состояния инициализации
     * @param rootReducer  @see <a href="https://redux.js.org/tutorials/fundamentals/part-3-state-actions-reducers">
     *                     Redux Fundamentals, Part 3: State, Actions, and Reducers
     *                     </a>
     * @return новое хранилище.
     * Примечание: количество хранилищ в вашем проекте может быть не ограничено, однако эти хранилища не будут иметь
     * между собой никакой связи. Если есть необходимость в зависимостях модулей и их состояний между собой, следует
     * создать одно хранилище с несколькими редьюсерами
     */
    @Deprecated
    @Contract("_, _, _ -> new")
    protected static @NotNull Store create(State initialState, Reducer rootReducer, ReduxConfig config) {
        return new Store(initialState, rootReducer, config);
    }

    @Contract("_, _, -> new")
    protected static @NotNull Store create(Reducer rootReducer, ReduxConfig config) {
        return new Store(rootReducer, config);
    }
}
