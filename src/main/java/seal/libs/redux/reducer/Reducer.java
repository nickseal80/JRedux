package seal.libs.redux.reducer;

import seal.libs.redux.state.State;
import seal.libs.redux.action.Action;
import seal.libs.redux.action.ActionType;

public interface Reducer<E extends Enum<E> & ActionType> {
    State getState();

    State reduce(Action<E, ?> action);
}
