package seal.libs.redux.store;

import org.jetbrains.annotations.NotNull;
import seal.libs.redux.action.ActionType;
import seal.libs.redux.reducer.Reducer;

/**
 * A factory class for creating and managing a singleton store.
 * This ensures that only one store instance exists throughout the application.
 */
public class StoreFactory {
    private static Store<?> instance;

    // Private constructor to prevent instantiation
    private StoreFactory() {}

    /**
     * Retrieves the singleton store instance. If the store does not exist, it will be created.
     *
     * @param reducer The reducer to initialize the store with.
     * @param <E> The type of the action type, extending {@link Enum} and {@link ActionType}.
     * @return The singleton store instance.
     */
    @SuppressWarnings("unchecked")
    public static synchronized <E extends Enum<E> & ActionType> Store<E> getOrCreateStore(@NotNull Reducer<E> reducer) {
        if (instance == null) {
            instance = new Store<>(reducer);
        }
        return (Store<E>) instance; // Cast safely because of the singleton
    }

    /**
     * Resets the store, allowing it to be reinitialized.
     * This is typically used for testing or resetting the application state.
     */
    public static synchronized void resetStore() {
        instance = null;
    }
}
