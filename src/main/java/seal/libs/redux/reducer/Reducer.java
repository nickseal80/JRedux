package seal.libs.redux.reducer;

import seal.libs.redux.state.State;
import seal.libs.redux.action.Action;
import seal.libs.redux.action.ActionType;

/**
 * The interface that defines a reducer. A reducer is responsible for updating the state based on an action.
 * It should implement a method to get the current state and a method to reduce the state based on an action.
 *
 * @param <E> The type of the action type, extending {@link Enum} and {@link ActionType}.
 */
public interface Reducer<E extends Enum<E> & ActionType> {

    /**
     * Gets the current state of the reducer.
     *
     * @return The current state.
     */
    State getState();

    /**
     * Reduces the state based on the provided action and returns a new state.
     *
     * @param action The action to process.
     * @return The new state after applying the action.
     */
    State reduce(Action<E, ?> action);
}
