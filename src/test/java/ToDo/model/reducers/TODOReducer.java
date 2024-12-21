package ToDo.model.reducers;

import ToDo.model.TODOState;
import ToDo.model.actions.ActionTypes;
import seal.libs.redux.Action;
import seal.libs.redux.Reducer;
import seal.libs.redux.State;

import java.util.ArrayList;
import java.util.List;

public class TODOReducer implements Reducer
{
    @Override
    public State reduce(TODOState oldState, Action<ActionTypes> action)
    {
        switch (action.getType()) {
            case ActionTypes.ADD_TODO -> {
                List<String> oldTodoList = oldState.getTodoList();
                List<String> newTodoList = new ArrayList<>(oldTodoList);
            }
        }
    }
}
