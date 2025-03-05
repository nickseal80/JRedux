package seal.libs.redux.state;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents the root state that holds all the individual states for a Redux-like store.
 * It ensures immutability by wrapping the state map in an unmodifiable collection.
 */
public record RootState(Map<String, State> states) implements State {

    /**
     * Constructs a new {@link RootState} with an unmodifiable map of states.
     *
     * @param states A map of state names to state objects.
     */
    public RootState {
        // Ensuring that the states map is immutable
        states = Collections.unmodifiableMap(new HashMap<>(states));
    }

    /**
     * Creates a new {@link RootState} with an updated state for the given key.
     * This method returns a new instance of RootState with the modified state, leaving the original state unchanged.
     *
     * @param key The key for the state to update.
     * @param newState The new state to associate with the key.
     * @return A new {@link RootState} instance with the updated state.
     */
    @Contract("_, _ -> new")
    public @NotNull RootState withState(String key, State newState) {
        // Creating a new map to hold the updated states
        Map<String, State> updatedStates = new HashMap<>(states);
        updatedStates.put(key, newState); // Updating the state for the specified key

        return new RootState(updatedStates);
    }

    /**
     * Retrieves the state associated with the given key.
     *
     * @param key The key for the state to retrieve.
     * @return The state associated with the key, or {@code null} if not found.
     */
    public State getState(String key) {
        return states.get(key);
    }
}
