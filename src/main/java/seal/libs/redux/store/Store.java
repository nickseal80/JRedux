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

/**
 * A class representing the store that holds the application state, applies reducers to actions, and manages subscribers.
 * The store dispatches actions and notifies subscribers of state changes.
 *
 * @param <E> The type of the action type, extending {@link Enum} and {@link ActionType}.
 */
public class Store <E extends Enum<E> & ActionType> {
    private State currentState;
    private Reducer<E> reducer;
    private final List<Subscriber<State>> subscribers = new ArrayList<>();

    /**
     * Constructs a new Store with the provided root reducer.
     *
     * @param rootReducer The root reducer responsible for reducing the state based on actions.
     */
    Store(@NotNull Reducer<E> rootReducer) {
        this.reducer = rootReducer;
        this.currentState = rootReducer.getState();
    }

    /**
     * Retrieves the current state of the store.
     *
     * @return The current application state.
     */
    public State getState() {
        return currentState;
    }

    private final DispatchFunction<E> dispatch = action -> {
        State oldState = currentState;
        State newState = reducer.reduce(action);

        if (!oldState.equals(newState)) {
            currentState = newState;
            notifySubscribers(action);
        }
    };

    /**
     * Dispatches an action to the store, causing the state to be reduced and updated.
     *
     * @param action The action to dispatch.
     */
    public void dispatch(Action<E, ?> action) {
        dispatch.accept(action);
    }

    /**
     * Subscribes to the store, allowing a subscriber to be notified when the state changes.
     *
     * @param subscriber The subscriber to notify on state change.
     * @return A {@link Subscription} that can be used to unsubscribe.
     */
    public Subscription subscribe(Subscriber<State> subscriber) {
        subscribers.add(subscriber);
        return () -> subscribers.remove(subscriber);
    }

    /**
     * Notifies all subscribers of a state change.
     *
     * @param action The action that caused the state change.
     */
    private void notifySubscribers(Action<E, ?> action) {
        subscribers.forEach(subscriber -> subscriber.onChange(action, currentState));
    }
}
