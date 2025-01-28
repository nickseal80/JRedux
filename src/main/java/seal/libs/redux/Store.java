package seal.libs.redux;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import seal.libs.redux.config.ReduxConfig;

import java.util.ArrayList;
import java.util.List;

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
     * Получает текущее состояние объекта.
     * <p>
     * Метод возвращает экземпляр класса State, который представляет текущее состояние.
     *
     * @return текущее состояние
     */
    public State getState() {
        return currentState;
    }


    /**
     * Реализация функционального интерфейса {@link DispatchFunction}.
     * <p>
     * Данный метод отвечает за обработку действий, передаваемых в систему. Он принимает
     * действие в качестве параметра, обновляет состояние, если новое состояние отличается
     * от старого, и уведомляет подписчиков о произошедших изменениях.
     * <p>
     * Метод использует редьюсер для вычисления нового состояния на основе старого состояния
     * и переданного действия. Уведомление подписчиков происходит только в случае, если
     * состояние изменилось, что помогает избежать ненужных обновлений.
     */
    @SuppressWarnings("unchecked")
    private final DispatchFunction dispatch = action -> {
        State oldState = currentState;
        State newState = reducer.reduce((Action<Object>) action);

        if (!oldState.equals(newState)) {
            currentState = newState;

            notifySubscribers((Action<Object>) action);
        }
    };

    /**
     * Обрабатывает заданное действие.
     * <p>
     * Этот метод принимает объект действия и передает его в функцию обработки.
     * <p>
     * @param action объект действия, который будет обработан.
     */
    public void dispatch(Object action) {
        dispatch.accept(action);
    }

    /**
     * Метод добавления подписчиков.
     * <p>
     * Этот метод позволяет добавлять нового подписчика, который будет получать обновления состояния.
     *
     * @param subscriber подписчик, который будет получать уведомления об изменениях состояния.
     * @return метод отписки, который можно вызвать для удаления подписчика из списка.
     */
    public Subscription subscribe(Subscriber<State> subscriber) {
        subscribers.add(subscriber);

        return () -> subscribers.remove(subscriber);
    }

    /**
     * Устанавливает список подписчиков.
     * <p>
     * Метод добавляет переданный список подписчиков в существующий список подписчиков.
     *
     * @param subscribers Список подписчиков, которые будут добавлены.
     */
    public void setSubscribers(@NotNull List<Subscriber<State>> subscribers) {
        this.subscribers.addAll(subscribers);
    }

    /**
     * Метод оповещения подписчиков об изменении состояния хранилища.
     * <p>
     * Этот метод проходит по всем подписчикам и вызывает их метод onChange,
     * передавая ему действие и текущее состояние. Он используется для уведомления
     * всех заинтересованных сторон о том, что произошло изменение в хранилище,
     * что позволяет подписчикам обновить свои данные или выполнить другие
     * необходимые действия в ответ на это изменение.
     *
     * @param action Действие, которое описывает изменение состояния.
     */
    private void notifySubscribers(Action<Object> action) {
        subscribers.forEach(subscriber -> subscriber.onChange(action, currentState));
    }

    /**
     * Создает новый экземпляр хранилища (Store) с заданным начальным состоянием, редюсером и конфигурацией.
     *
     * @param initialState Начальное состояние хранилища.
     * @param rootReducer Редюсер, который будет использоваться для обработки действий.
     * @param config Конфигурация Redux, определяющая параметры хранилища.
     * @return Новый экземпляр хранилища.
     *
     * @deprecated Этот метод устарел и может быть удален в будущих версиях.
     */
    @Deprecated
    @Contract("_, _, _ -> new")
    protected static @NotNull Store create(State initialState, Reducer rootReducer, ReduxConfig config) {
        return new Store(initialState, rootReducer, config);
    }

    /**
     * Создает новый экземпляр хранилища (Store) с использованием переданного редьюсера и конфигурации.
     *
     * @param rootReducer Редьюсер, который будет использоваться для управления состоянием хранилища.
     * @param config Конфигурация, определяющая параметры работы хранилища.
     * @return Новый экземпляр хранилища, инициализированный с указанным редьюсером и конфигурацией.
     */
    @Contract("_, _, -> new")
    protected static @NotNull Store create(Reducer rootReducer, ReduxConfig config) {
        return new Store(rootReducer, config);
    }
}
