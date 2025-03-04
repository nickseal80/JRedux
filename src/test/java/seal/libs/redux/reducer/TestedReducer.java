package seal.libs.redux.reducer;

import org.jetbrains.annotations.NotNull;
import seal.libs.redux.state.State;
import seal.libs.redux.state.TestedState;
import seal.libs.redux.action.Action;
import seal.libs.redux.action.ActionTypes;

import java.util.Date;

public class TestedReducer implements Reducer<ActionTypes> {
    private TestedState state = new TestedState("Default Project", "Java", new Date());

    @Override
    public State getState() {
        return state;
    }

    @Override
    public State reduce(@NotNull Action<ActionTypes, ?> action) {
        switch (action.type()) {
            case CHANGE_NAME -> state = state.withUpdatedName((String) action.payload());
            case CHANGE_LANGUAGE -> state = state.withUpdatedLanguage((String) action.payload());
            case ADD_TASK -> state = state.withCreatedAt((Date) action.payload());
        }
        return state;
    }
}
