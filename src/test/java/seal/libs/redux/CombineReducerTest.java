package seal.libs.redux;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import seal.libs.redux.action.Action;
import seal.libs.redux.action.ActionTypes;
import seal.libs.redux.action.TestedActions;
import seal.libs.redux.reducer.Reducer;
import seal.libs.redux.state.RootState;
import seal.libs.redux.state.State;

import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class CombineReducerTest {
    private Reducer projectListReducer;
    private Reducer projectReducer;
    private Reducer<ActionTypes> taskReducer;
    private Reducer<ActionTypes> rootReducer;
    private Store store;

    @BeforeEach
    void setUp() {
        // Создаем моки редьюсеров
        projectListReducer = Mockito.mock(Reducer.class);
        projectReducer = Mockito.mock(Reducer.class);
        taskReducer = Mockito.mock(Reducer.class);

        // Создаем rootReducer через combineReducers
        rootReducer = Redux.combineReducers(Map.of(
                "projectList", projectListReducer,
                "projects", projectReducer,
                "tasks", taskReducer
        ));

        store = new Store(rootReducer);
    }

    @Test
    void testInitialState() {
        assertNotNull(store.getState());
    }

    @Test
    void testReduceAction() {
        Action<ActionTypes, String> action = TestedActions.INSTANCE.changeName("New Project");

        store.dispatch(action);

        Mockito.verify(projectListReducer).reduce(action);
        Mockito.verify(projectReducer).reduce(action);
        Mockito.verify(taskReducer).reduce(action);
    }
}
