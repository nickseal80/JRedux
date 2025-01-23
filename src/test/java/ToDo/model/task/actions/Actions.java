package ToDo.model.task.actions;

import ToDo.model.task.TaskStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import seal.libs.redux.Action;

import java.util.Date;

public class Actions {
    @Contract("_ -> new")
    public static @NotNull Action<ActionTypes> changeName(String name) {
        return new Action<>(ActionTypes.CHANGE_NAME, name);
    }

    @Contract("_ -> new")
    public static @NotNull Action<ActionTypes> changeDescription(String description) {
        return new Action<>(ActionTypes.CHANGE_DESCRIPTION, description);
    }

    @Contract("_ -> new")
    public static @NotNull Action<ActionTypes> changeStatus(String status) {
        return new Action<>(ActionTypes.CHANGE_STATUS, status);
    }

    @Contract("_ -> new")
    public static @NotNull Action<ActionTypes> changeCreatedAt(Date createdAt) {
        return new Action<>(ActionTypes.CHANGE_CREATED_AT, createdAt);
    }
}
