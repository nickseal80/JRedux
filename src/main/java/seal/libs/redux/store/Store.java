package seal.libs.redux.store;

import org.jetbrains.annotations.NotNull;
import seal.libs.redux.DispatchFunction;
import seal.libs.redux.Subscriber;
import seal.libs.redux.Subscription;
import seal.libs.redux.action.Action;
import seal.libs.redux.action.ActionType;
import seal.libs.redux.reducer.Reducer;
import seal.libs.redux.state.State;

import java.util.ArrayList;
import java.util.List;

public class Store <E extends Enum<E> & ActionType> {
    private State currentState;
    private Reducer<E> reducer;
    private final List<Subscriber<State>> subscribers = new ArrayList<>();

    Store(@NotNull Reducer<E> rootReducer) {
        this.reducer = rootReducer;
        this.currentState = rootReducer.getState();
    }

    public State getState() {
        return currentState;
    }

    @SuppressWarnings("unchecked")
    private final DispatchFunction dispatch = action -> {
        State oldState = currentState;
        State newState = reducer.reduce((Action<E, ?>) action);

        if (!oldState.equals(newState)) {
            currentState = newState;
            notifySubscribers((Action<E, ?>) action);
        }
    };

    public void dispatch(Object action) {
        dispatch.accept(action);
    }

    public Subscription subscribe(Subscriber<State> subscriber) {
        subscribers.add(subscriber);
        return () -> subscribers.remove(subscriber);
    }

    private void notifySubscribers(Action<E, ?> action) {
        subscribers.forEach(subscriber -> subscriber.onChange(action, currentState));
    }
}
