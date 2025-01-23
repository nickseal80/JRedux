package ToDo;

import ToDo.model.project.ProjectReducer;
import org.junit.jupiter.api.Test;
import seal.libs.redux.Redux;
import seal.libs.redux.Store;

import java.util.Date;

public class ToDoTest
{
    @Test
    public void addTodoTest()
    {
        Redux redux = new Redux();
        ProjectReducer projectReducer = new ProjectReducer();
        Store store = redux.createStore(projectReducer);

//        List<String> todoList = new ArrayList<>();
//        TodoState initialState = new TodoState(todoList);
//        Redux redux = new Redux(new ReduxConfig().setPackageName("ToDo"));
//        Store store = redux.createStore(initialState, new TodoReducer());
//        store.dispatch(Actions.addTODO("First todo in list"));
//
//        assertEquals("First todo in list", ((TodoState) store.getState()).getTodoList().getFirst());
    }

    private ProjectReducer.Project createProjectState(ProjectReducer reducer) {
        ProjectReducer.Project state = reducer.new Project();
        state.setName("DI Container");
        state.setLanguage("Java");
        state.setCreatedAt(new Date());

        return state;
    }
}
