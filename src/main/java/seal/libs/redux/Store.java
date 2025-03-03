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

    public State getState() {
        return currentState;
    }

    @SuppressWarnings("unchecked")
    private final DispatchFunction dispatch = action -> {
        State oldState = currentState;
        State newState = reducer.reduce((Action<Object>) action);

        if (!oldState.equals(newState)) {
            currentState = newState;

            notifySubscribers((Action<Object>) action);
        }
    };

    public void dispatch(Object action) {
        dispatch.accept(action);
    }

    public Subscription subscribe(Subscriber<State> subscriber) {
        subscribers.add(subscriber);

        return () -> subscribers.remove(subscriber);
    }

    public void setSubscribers(@NotNull List<Subscriber<State>> subscribers) {
        this.subscribers.addAll(subscribers);
    }

    private void notifySubscribers(Action<Object> action) {
        subscribers.forEach(subscriber -> subscriber.onChange(action, currentState));
    }

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
