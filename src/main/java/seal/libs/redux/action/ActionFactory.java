package seal.libs.redux.action;

/**
 * Factory class for creating {@link Action} objects.
 *
 * @param <E> The type of the action type, extending {@link Enum} and {@link ActionType}.
 */
public class ActionFactory<E extends Enum<E> & ActionType> {

    /**
     * Creates an {@link Action} with the specified type and payload.
     *
     * @param type The type of the action.
     * @param payload The payload of the action.
     * @param <P> The type of the payload.
     * @return A new instance of {@link Action} with the given type and payload.
     */
    protected <P> Action<E, P> create(E type, P payload) {
        return new Action<>(type, payload);
    }
}
