package seal.libs.redux.state;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public record RootState(Map<String, State> states) implements State {
    public RootState {
        states = Collections.unmodifiableMap(new HashMap<>(states)); // immutable
    }

    @Contract("_, _ -> new")
    public @NotNull RootState withState(String key, State newState) {
        Map<String, State> updatedStates = new HashMap<>(states);
        updatedStates.put(key, newState);
        return new RootState(updatedStates);
    }

    public State getState(String key) {
        return states.get(key);
    }
}
