package seal.libs.redux;

import seal.libs.redux.action.Action;
import seal.libs.redux.action.ActionTypes;
import seal.libs.redux.action.TestedActions;
import seal.libs.redux.reducer.Reducer;
import seal.libs.redux.state.State;

class FakeReducer implements Reducer<ActionTypes> {
    @Override
    public State getState() {
        return new State(); // или мок
    }

    @Override
    public State reduce(Action<ActionTypes, ?> action) {
        return new State(); // или логика
    }
}
