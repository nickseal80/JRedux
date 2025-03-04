package seal.libs.redux.action;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ActionsTest {

    @Test
    void testChangeNameAction() {
        String newName = "New Project Name";

        Action<ActionTypes, String> action = TestedActions.INSTANCE.changeName(newName);

        // Проверяем, что тип действия правильный
        assertThat(action.type()).isEqualTo(ActionTypes.CHANGE_NAME);

        // Проверяем, что payload содержит ожидаемое значение
        assertThat(action.payload()).isEqualTo(newName);
    }

    @Test
    void testChangeLanguageAction() {
        String newLanguage = "Java";
        Action<ActionTypes, String> action = TestedActions.INSTANCE.changeLanguage(newLanguage);

        // Проверяем, что тип действия правильный
        assertThat(action.type()).isEqualTo(ActionTypes.CHANGE_LANGUAGE);

        // Проверяем, что payload содержит ожидаемое значение
        assertThat(action.payload()).isEqualTo(newLanguage);
    }

    @Test
    void testNullPayload() {
        Action<ActionTypes, String> action = TestedActions.INSTANCE.changeName(null);

        // Тип действия должен быть корректным, но payload = null
        assertThat(action.type()).isEqualTo(ActionTypes.CHANGE_NAME);
        assertThat(action.payload()).isNull();
    }
}
