package seal.libs.redux.state;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StateTest {
    @Test
    void testWithUpdatedName() {
        TestedState initialState = new TestedState("Old Name", "Java", new Date());
        TestedState newState = initialState.withUpdatedName("New Name");

        assertThat(newState.name()).isEqualTo("New Name");
        assertThat(newState.language()).isEqualTo("Java");
        assertThat(newState.createdAt()).isEqualTo(initialState.createdAt());

        // Проверяем, что старый объект не изменился
        assertThat(initialState.name()).isEqualTo("Old Name");
    }

    @Test
    void testWithUpdatedLanguage() {
        TestedState initialState = new TestedState("Project", "Java", new Date());
        TestedState newState = initialState.withUpdatedLanguage("Kotlin");

        assertThat(newState.language()).isEqualTo("Kotlin");
        assertThat(newState.name()).isEqualTo("Project");

        // Проверяем, что старый объект не изменился
        assertThat(initialState.language()).isEqualTo("Java");
    }

    @Test
    void testWithNewTask() {
        TestedState initialState = new TestedState("Project", "Java", new Date());
        TestedState newState = initialState.withCreatedAt(initialState.createdAt());

        assertThat(newState.name()).isEqualTo("Project");
        assertThat(newState.language()).isEqualTo("Java");
        assertThat(newState.createdAt()).isEqualTo(initialState.createdAt());
    }
}
