package seal.libs.redux.store;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
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
     * Retrieves the existing singleton store instance, if it has been created.
     * If the store has not been initialized, this method will throw a {@link RuntimeException}.
     *
     * @param <E> The type of the action type, extending {@link Enum} and {@link ActionType}.
     * @return The singleton store instance, or throws a {@link RuntimeException} if the store was not created.
     * @throws RuntimeException if the store has not been initialized using {@link #getOrCreateStore(Reducer)}.
     */
    @Contract(pure = true)
    @SuppressWarnings("unchecked")
    public static <E extends Enum<E> & ActionType> @Nullable Store<E> getStore() {
        if (instance != null) {
            return (Store<E>) instance;
        }

        throw new RuntimeException("Store was not created");
    }

    /**
     * Resets the store, allowing it to be reinitialized.
     * This is typically used for testing or resetting the application state.
     */
    public static synchronized void resetStore() {
        instance = null;
    }
}
