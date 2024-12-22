package seal.libs.redux;

import java.util.ArrayList;
import java.util.List;

public class Store
{
    private State currentState;
    private Reducer reducer;
    private final List<Subscriber<State>> subscribers = new ArrayList<>();

    public Store(State initialState, Reducer rootReducer)
    {
        currentState = initialState;
        reducer = rootReducer;
    }

    public State getState()
    {
        return currentState;
    }

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

    public Subscription subscribe(Subscriber<State> subscriber)
    {
        subscribers.add(subscriber);

        subscriber.onChange(currentState);

        return () -> subscribers.remove(subscriber);
    }

    private void notifySubscribers()
    {
        subscribers.forEach(subscriber -> subscriber.onChange(currentState));
    }

    public static Store create(State initialState, Reducer rootReducer)
    {
        return new Store(initialState, rootReducer);
    }
}
