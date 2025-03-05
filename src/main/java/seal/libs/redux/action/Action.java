package seal.libs.redux.action;

/**
 * Represents an action in the Redux-like pattern.
 * The action has a type and an associated payload.
 *
 * @param <E> The type of the action type, extending {@link Enum} and {@link ActionType}.
 * @param <P> The type of the payload that the action carries.
 */
public record Action<E extends Enum<E> & ActionType, P>(E type, P payload) {}