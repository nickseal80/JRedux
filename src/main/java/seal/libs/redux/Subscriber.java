package seal.libs.redux;

import seal.libs.redux.action.Action;

/**
 * Subscriber interface that is used to receive updates on state changes.
 *
 * @param <S> The type of the state being observed.
 */
public interface Subscriber<S>
{

    /**
     * Called when the state changes, notifying the subscriber of the change.
     *
     * @param action The action that triggered the state change.
     * @param state The updated state after the change.
     */
    void onChange(Action<?, ?> action, S state);
}
