package ToDo;

import ToDo.model.TodoState;
import ToDo.model.actions.Actions;
import ToDo.model.reducers.TodoReducer;
import ToDo.model.seeders.TodoListSeeder;
import org.junit.jupiter.api.Test;
import seal.libs.redux.Store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoTest
{
    @Test
    public void addTodoTest()
    {
        List<String> todoList = new ArrayList<>();
        TodoState initialState = new TodoState(todoList);
        Store store = Store.create(initialState, new TodoReducer());
        store.dispatch(Actions.addTODO("First todo in list"));

        assertEquals("First todo in list", ((TodoState) store.getState()).getTodoList().getFirst());
    }

    @Test
    public void deleteFromTodoListTest()
    {
        List<String> todoList = TodoListSeeder.todoList();
        TodoState initialState = new TodoState(todoList);
        Store store = Store.create(initialState, new TodoReducer());
        assertEquals(initialState, store.getState());

        store.dispatch(Actions.deleteTODO("Epic 113"));
        System.out.println(store.getState());
        assertNotEquals(initialState, store.getState());
        List<String> newTodoList = new ArrayList<>(Arrays.asList("Planning", "PBR epic", "launch", "Epic 112", "End of work"));
        assertEquals(newTodoList, ((TodoState) store.getState()).getTodoList());
    }
}
