package ToDo.model.projectList.actions;

import ToDo.model.project.ProjectReducer;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import seal.libs.redux.Action;

public class Actions {
    @Contract("_ -> new")
    public static @NotNull Action<ActionTypes> addProject(ProjectReducer.Project project) {
        return new Action<>(ActionTypes.ADD_PROJECT, project);
    }

    @Contract("_ -> new")
    public static @NotNull Action<ActionTypes> removeProject(ProjectReducer.Project project) {
        return new Action<>(ActionTypes.REMOVE_PROJECT, project);
    }
}
