package seal.libs.redux;

import seal.libs.redux.action.Action;
import seal.libs.redux.action.ActionType;

/**
 * A functional interface representing a function that accepts an action and dispatches it.
 * This is used for dispatching actions to the store.
 *
 * @param <E> The type of the action type, extending {@link Enum} and {@link ActionType}.
 */
@FunctionalInterface
public interface DispatchFunction<E extends Enum<E> & ActionType>
{
    /**
     * Dispatches the given action to the store.
     *
     * @param action The action to be dispatched.
     */
    void accept(Action<E, ?> action);
}
