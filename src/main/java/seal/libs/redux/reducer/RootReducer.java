package seal.libs.redux.reducer;

import org.jetbrains.annotations.NotNull;
import seal.libs.redux.action.Action;
import seal.libs.redux.action.ActionType;
import seal.libs.redux.state.RootState;
import seal.libs.redux.state.State;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * The root reducer is responsible for combining multiple reducers into one.
 * It delegates the action to each of the child reducers and merges their states.
 *
 * @param <T> The type of the action type, extending {@link Enum} and {@link ActionType}.
 */
public class RootReducer<T extends Enum<T> & ActionType> implements Reducer<T> {
    private final Map<String, Reducer<T>> reducers;
    private RootState state;

    /**
     * Creates a new RootReducer with the provided child reducers.
     *
     * @param reducers A map of child reducers, where the key is the reducer name and the value is the reducer itself.
     */
    public RootReducer(@NotNull Map<String, Reducer<T>> reducers) {
        this.reducers = reducers;
        this.state = new RootState(
                reducers.entrySet().stream()
                        .collect(
                                Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().getState())
                        )
        );
    }

    /**
     * Gets the current root state, which includes the states of all child reducers.
     *
     * @return The current root state.
     */
    @Override
    public State getState() {
        return state;
    }

    /**
     * Reduces the state by applying the given action to all child reducers.
     * This method returns a new root state with updated states from each child reducer.
     *
     * @param action The action to process.
     * @return A new root state with updated states.
     */
    @Override
    public State reduce(Action<T, ?> action) {
        // Create a new state object to avoid mutability issues
        RootState newState = new RootState(
                reducers.entrySet().stream()
                        .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().reduce(action)))
        );

        // Update the root state with the new state
        state = newState;
        return state;
    }
}