package seal.libs.redux;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import seal.libs.redux.action.ActionType;
import seal.libs.redux.reducer.Reducer;
import seal.libs.redux.reducer.RootReducer;

import java.util.Map;

/**
 * A utility class that provides Redux-like functionality, including combining multiple reducers.
 * This class is intended to simplify the integration of reducers in a Redux-like architecture.
 */
public class Redux {

    /**
     * Combines multiple reducers into a single root reducer.
     * This allows for splitting the state into smaller parts, each managed by a different reducer.
     *
     * @param reducers A map of reducer names to reducer functions.
     * @param <T> The type of action type, extending {@link Enum} and {@link ActionType}.
     * @return A single root reducer that combines the given reducers.
     */
    @Contract("_ -> new")
    public static <T extends Enum<T> & ActionType> @NotNull Reducer<T> combineReducers(Map<String, Reducer<T>> reducers) {
        return new RootReducer<>(reducers); // Create a root reducer that combines all provided reducers
    }
}
