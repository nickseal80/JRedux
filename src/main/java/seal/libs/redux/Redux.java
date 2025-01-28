package seal.libs.redux;

import seal.libs.redux.config.ReduxConfig;


public class Redux {
    private ReduxConfig config;
    private Store store;

    public Redux(ReduxConfig config) {
        this.config = config;
    }

    public Redux() {}

    /**
     * Получает экземпляр хранилища.
     * <p>
     * Если хранилище не инициализировано, будет выброшено исключение RuntimeException с сообщением
     * "Хранилище не инициализировано. Используйте createStore() вместо этого."
     *
     * @return экземпляр хранилища.
     */
    public Store getStore() {
        if (store == null) {
            throw new RuntimeException("Store not initialized. Use createStore() instead.");
        }
        return store;
    }

    /**
     * Создает новое хранилище (store) с использованием указанного редьюсера.
     *
     * @param rootReducer Редьюсер, который будет использоваться для управления состоянием хранилища.
     * @return Возвращает созданное хранилище.
     */
    public Store createStore(Reducer rootReducer) {
        Store store = Store.create(rootReducer, config);
        this.store = store;

        return store;
    }

    /**
     * Создает новый экземпляр хранилища (Store) с заданным начальным состоянием и корневым редюсером.
     * <p>
     * Этот метод устарел и не рекомендуется к использованию. Вместо него следует использовать
     * альтернативные методы создания хранилища, если таковые имеются.
     *
     * @param initialState Начальное состояние хранилища.
     * @param rootReducer Корневой редюсер, который управляет изменениями состояния.
     * @return Возвращает созданное хранилище.
     */
    @Deprecated
    public Store createStore(State initialState, Reducer rootReducer) {
        Store store = Store.create(initialState, rootReducer, config);
        this.store = store;

        return store;
    }

    /**
     * Объединяет несколько редюсеров в один.
     * <p>
     * Этот метод принимает массив контейнеров редюсеров и создает корневой редюсер,
     * который будет объединять их функциональность. Используется для управления
     * состоянием приложения, позволяя комбинировать логику различных редюсеров
     * в единый редюсер.
     *
     * @param containers массив контейнеров редюсеров, которые будут объединены.
     * @return новый экземпляр RootReducer, который объединяет переданные редюсеры.
     */
    public Reducer combineReducer(ReducerContainer ...containers) {

        return new RootReducer(containers);
    }
}
