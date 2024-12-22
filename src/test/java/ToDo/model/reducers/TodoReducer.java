package ToDo.model.reducers;

import ToDo.model.TodoState;
import ToDo.model.actions.ActionTypes;
import seal.libs.redux.Action;
import seal.libs.redux.Reducer;
import seal.libs.redux.State;

import java.util.ArrayList;
import java.util.List;

public class TodoReducer implements Reducer
{
    @Override
    public State reduce(State state, Action<Object> action)
    {
        switch (action.getType()) {
            case ActionTypes.ADD_TODO -> {
                List<String> oldTodoList = ((TodoState) state).getTodoList();
                List<String> newTodoList = new ArrayList<>(oldTodoList);
                newTodoList.add((String) action.getPayload());

                return state.withNew(newTodoList);
            }

            case ActionTypes.DELETE_TODO -> {
                List<String> oldTodoList = ((TodoState) state).getTodoList();
                List<String> newTodoList = new ArrayList<>(oldTodoList);
                newTodoList.removeIf(todo -> todo.equals(action.getPayload()));

                return state.withNew(newTodoList);
            }

            default -> {
                return state;
            }
        }
    }
}
