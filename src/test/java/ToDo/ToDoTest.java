package ToDo;

import ToDo.model.TodoState;
import ToDo.model.actions.Actions;
import ToDo.model.reducers.TodoReducer;
import org.junit.jupiter.api.Test;
import seal.libs.redux.Store;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoTest
{
    @Test
    public void addTodoTest()
    {
        List<String> todoList = new ArrayList<>();
        TodoState initialState = new TodoState(todoList);
        Store store = new Store(initialState, new TodoReducer());
        store.dispatch(Actions.addTODO("First todo in list"));

        assertEquals("First todo in list", ((TodoState) store.getState()).getTodoList().getFirst());
    }
}
