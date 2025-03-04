package seal.libs.redux;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import seal.libs.redux.action.Action;
import seal.libs.redux.reducer.Reducer;
import seal.libs.redux.state.State;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private State currentState;
    private Reducer reducer;
    private final List<Subscriber<State>> subscribers = new ArrayList<>();

    @Deprecated
    private Store(State initialState, Reducer rootReducer) {
        currentState = initialState;
        reducer = rootReducer;
    }

    Store(@NotNull Reducer rootReducer) {
        currentState = rootReducer.getState();
        reducer = rootReducer;
    }

    public State getState() {
        return currentState;
    }

    @SuppressWarnings("unchecked")
    private final DispatchFunction dispatch = action -> {
        State oldState = currentState;
        State newState = reducer.reduce((Action) action);

        if (!oldState.equals(newState)) {
            currentState = newState;

            notifySubscribers((Action) action);
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

    private void notifySubscribers(Action action) {
        subscribers.forEach(subscriber -> subscriber.onChange(action, currentState));
    }

    @Deprecated
    @Contract("_, _ -> new")
    protected static @NotNull Store create(State initialState, Reducer rootReducer) {
        return new Store(initialState, rootReducer);
    }

    @Contract("_ -> new")
    protected static @NotNull Store create(Reducer rootReducer) {
        return new Store(rootReducer);
    }
}
