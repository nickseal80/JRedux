package ToDo;

import ToDo.model.project.ProjectReducer;
import ToDo.model.project.actions.ProjectActions;
import ToDo.model.projectList.ProjectListReducer;
import ToDo.model.projectList.actions.ProjectListActions;
import ToDo.model.task.TaskReducer;
import ToDo.model.task.actions.TaskActions;
import org.junit.jupiter.api.Test;
import seal.libs.redux.*;



import java.util.Date;

public class ToDoTest
{
    @Test
    public void addTodoTest()
    {
        Redux redux = new Redux();

        // creating reducers
        ProjectListReducer projectListReducer = new ProjectListReducer();
        ProjectReducer projectReducer = new ProjectReducer();
        TaskReducer taskReducer = new TaskReducer();

        Reducer rootReducer = redux.combineReducer(
                new ReducerContainer("area", projectReducer),
                new ReducerContainer("project", projectListReducer),
                new ReducerContainer("task", taskReducer)
        );

        Store store = redux.createStore(rootReducer);
        // add task
        store.dispatch(TaskActions.changeName("Task 1"));
        store.dispatch(TaskActions.changeDescription("Task 1 такая Task 1"));
        store.dispatch(TaskActions.changeCreatedAt(new Date()));

        // add project
        store.dispatch(ProjectActions.changeName("DI container"));
        store.dispatch(ProjectActions.changeLanguage("java"));
        store.dispatch(ProjectActions.addTask((TaskReducer.Task) taskReducer.getState()));

        // add project list
        store.dispatch(ProjectListActions.addProject((ProjectReducer.Project) projectReducer.getState()));
    }
}
