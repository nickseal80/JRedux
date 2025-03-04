package seal.libs.redux.reducer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seal.libs.redux.state.TestedState;
import seal.libs.redux.action.Action;
import seal.libs.redux.action.ActionTypes;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class ReducerTest {
    private TestedReducer reducer;

    @BeforeEach
    void setUp() {
        reducer = new TestedReducer();
    }

    @Test
    void testChangeName() {
        Action<ActionTypes, String> action = new Action<>(ActionTypes.CHANGE_NAME, "New Project Name");
        TestedState newState = (TestedState) reducer.reduce(action);

        assertThat(newState.name()).isEqualTo("New Project Name");
    }

    @Test
    void testChangeLanguage() {
        Action<ActionTypes, String> action = new Action<>(ActionTypes.CHANGE_LANGUAGE, "Kotlin");
        TestedState newState = (TestedState) reducer.reduce(action);

        assertThat(newState.language()).isEqualTo("Kotlin");
    }

    @Test
    void testChangeCreatedAt() {
        Action<ActionTypes, Date> action = new Action<>(ActionTypes.CHANGE_CREATED_AT, new Date());
        TestedState newState = (TestedState) reducer.reduce(action);

        assertThat(newState.createdAt()).isNotNull();
    }

    @Test
    void testReducerDoesNotModifyPreviousState() {
        TestedState oldState = (TestedState) reducer.getState();
        Action<ActionTypes, String> action = new Action<>(ActionTypes.CHANGE_NAME, "Another Name");

        TestedState newState = (TestedState) reducer.reduce(action);

        assertThat(oldState.name()).isNotEqualTo(newState.name());
    }
}
