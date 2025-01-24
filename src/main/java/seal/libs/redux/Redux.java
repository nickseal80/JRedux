package seal.libs.redux;

import seal.libs.redux.config.ReduxConfig;

public class Redux {
    private ReduxConfig config;
    private Store store;

    public Redux(ReduxConfig config) {
        this.config = config;
    }

    public Redux() {}

    public Store getStore() {
        if (store == null) {
            throw new RuntimeException("Store not initialized. Use createStore() instead.");
        }
        return store;
    }

    public Store createStore(Reducer rootReducer) {
        Store store = Store.create(rootReducer, config);
        this.store = store;

        return store;
    }

    @Deprecated
    public Store createStore(State initialState, Reducer rootReducer) {
        Store store = Store.create(initialState, rootReducer, config);
        this.store = store;

        return store;
    }

    public Reducer combineReducer(Reducer ...reducers) {

        return new RootReducer(reducers);
    }
}
