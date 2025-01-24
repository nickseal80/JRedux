package taskManager;

import taskManager.model.project.ProjectReducer;
import taskManager.model.project.actions.ProjectActions;
import taskManager.model.projectList.ProjectListReducer;
import taskManager.model.task.TaskReducer;
import taskManager.model.task.TaskStatus;
import taskManager.model.task.actions.TaskActions;
import org.junit.jupiter.api.Test;
import seal.libs.redux.*;

import java.util.Date;

public class TaskManagerTest {
    @Test
    public void addTaskTest() {
        Redux redux = new Redux();

        TaskReducer taskReducer = new TaskReducer();
        ProjectReducer projectReducer = new ProjectReducer();
        ProjectListReducer projectListReducer = new ProjectListReducer();
        Reducer rootReducer = redux.combineReducer(
//                new ReducerContainer("projectList", projectListReducer),
                new ReducerContainer("projects", projectReducer),
                new ReducerContainer("tasks", taskReducer)
        );
        Store store = redux.createStore(rootReducer);

        store.dispatch(ProjectActions.changeName("Project 1"));
        store.dispatch(ProjectActions.changeLanguage("Java"));
        store.dispatch(ProjectActions.changeCreatedAt(new Date()));

        // create a task
//        store.dispatch(TaskActions.changeName("Task 1"));
//        store.dispatch(TaskActions.changeDescription("Task 1 Description"));
//        store.dispatch(TaskActions.changeStatus(TaskStatus.STATUS_TODO.getStatus()));
//        store.dispatch(TaskActions.changeCreatedAt(new Date()));

//        store.dispatch(ProjectActions.addTask((TaskReducer.Task)((RootReducer.InitialState) store.getState()).get("task")));

//        store.dispatch(TaskActions.changeDescription("Task 2"));
//        store.dispatch(TaskActions.changeDescription("Task 2 Description"));
//        store.dispatch(TaskActions.changeStatus(TaskStatus.STATUS_TODO.getStatus()));
//        store.dispatch(TaskActions.changeCreatedAt(new Date()));





        System.out.println(store.getState().toString());
    }
}
