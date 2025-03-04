package seal.libs.redux.state;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

public record TestedState(String name, String language, Date createdAt) implements State {
    // Метод для обновления имени
    @Contract("_ -> new")
    public @NotNull TestedState withUpdatedName(String newName) {
        return new TestedState(newName, this.language, this.createdAt);
    }

    // Метод для обновления языка
    @Contract("_ -> new")
    public @NotNull TestedState withUpdatedLanguage(String newLanguage) {
        return new TestedState(this.name, newLanguage, this.createdAt);
    }

    @Contract("_ -> new")
    public @NotNull TestedState withCreatedAt(Date newCreatedAt) {
        return new TestedState(this.name, this.language, newCreatedAt);
    }
}
