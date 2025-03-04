package seal.libs.redux.reducer;

import org.jetbrains.annotations.NotNull;
import seal.libs.redux.action.Action;
import seal.libs.redux.action.ActionType;
import seal.libs.redux.state.RootState;
import seal.libs.redux.state.State;

import java.util.Map;
import java.util.stream.Collectors;

public class RootReducer<T extends Enum<T> & ActionType> implements Reducer<T> {
    private final Map<String, Reducer<T>> reducers;
    private RootState state;

    public RootReducer(@NotNull Map<String, Reducer<T>> reducers) {
        this.reducers = reducers;
        this.state = new RootState(
                reducers.entrySet().stream()
                        .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().getState()))
        );
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public State reduce(Action<T, ?> action) {
        RootState newState = state;

        for (Map.Entry<String, Reducer<T>> entry : reducers.entrySet()) {
            String key = entry.getKey();
            Reducer<T> reducer = entry.getValue();
            State newSubState = reducer.reduce(action);
            newState = newState.withState(key, newSubState);
        }

        state = newState;
        return state;
    }
}