package seal.libs.redux;

import java.util.ArrayList;
import java.util.List;

public class Store<S>
{
    private S currentState;
    private Reducer<S> reducer;
    private final List<Subscriber<S>> subscribers = new ArrayList<>();

    public Store(S initialState, Reducer<S> rootReducer)
    {
        currentState = initialState;
        reducer = rootReducer;
    }

    public S getState()
    {
        return currentState;
    }

    private final DispatchFunction dispatch = action -> {
        S oldState = currentState;
        System.out.println("oldState: " + oldState);
        S newState = reducer.reduce(this.currentState, (Action) action);

        if (oldState != newState && !oldState.equals(newState)) {
            currentState = newState;

            notifySubscribers();
        }
    };

    public void dispatch(Object action)
    {
        dispatch.accept(action);
    }

    public Subscription subscribe(Subscriber<S> subscriber)
    {
        subscribers.add(subscriber);

        subscriber.onChange(currentState);

        return () -> subscribers.remove(subscriber);
    }

    private void notifySubscribers()
    {
        subscribers.forEach(subscriber -> subscriber.onChange(currentState));
    }
}
