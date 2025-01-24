package taskManager.model.project.actions;

import taskManager.model.task.TaskReducer;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import seal.libs.redux.Action;

import java.util.Date;

public class ProjectActions {
    @Contract("_ -> new")
    public static @NotNull Action<ActionTypes> changeName(String name) {
        return new Action<>(ActionTypes.CHANGE_NAME, name);
    }

    @Contract("_ -> new")
    public static @NotNull Action<ActionTypes> changeLanguage(String language) {
        return new Action<>(ActionTypes.CHANGE_LANGUAGE, language);
    }

    @Contract("_ -> new")
    public static @NotNull Action<ActionTypes> changeCreatedAt(Date createdAt) {
        return new Action<>(ActionTypes.CHANGE_CREATED_AT, createdAt);
    }

    @Contract("_ -> new")
    public static @NotNull Action<ActionTypes> changeUpdatedAt(Date updatedAt) {
        return new Action<>(ActionTypes.CHANGE_UPDATED_AT, updatedAt);
    }

    @Contract("_ -> new")
    public static @NotNull Action<ActionTypes> addTask(TaskReducer.Task task) {
        return new Action<>(ActionTypes.ADD_TASK, task);
    }

    @Contract("_ -> new")
    public static @NotNull Action<ActionTypes> removeTask(TaskReducer.Task task) {
        return new Action<>(ActionTypes.REMOVE_TASK, task);
    }
}
