package taskManager;

import taskManager.model.project.ProjectReducer;
import taskManager.model.project.actions.ProjectActions;
import taskManager.model.projectList.ProjectListReducer;
import taskManager.model.projectList.actions.ProjectListActions;
import taskManager.model.task.TaskReducer;
import taskManager.model.task.actions.TaskActions;
import org.junit.jupiter.api.Test;
import seal.libs.redux.*;

import java.util.Date;

public class TaskManagerTest {
    @Test
    public void addTaskTest() {
        Redux redux = new Redux();

        TaskReducer taskReducer = new TaskReducer();
        Reducer rootReducer = redux.combineReducer(taskReducer);
        Store store = redux.createStore(rootReducer);
        store.dispatch(TaskActions.changeName("Task 1"));
    }

//    @Test
//    public void addTest() {
//        Redux redux = new Redux();
//
//        // creating reducers
//        ProjectListReducer projectListReducer = new ProjectListReducer();
//        ProjectReducer projectReducer = new ProjectReducer();
//        TaskReducer taskReducer = new TaskReducer();
//
//        // combine reducers
//        Reducer rootReducer = redux.combineReducer(
//                new ReducerContainer("area", projectReducer),
//                new ReducerContainer("project", projectListReducer),
//                new ReducerContainer("task", taskReducer)
//        );
//        // create store
//        Store store = redux.createStore(rootReducer);
//
//        // add task
//        store.dispatch(TaskActions.changeName("Task 1"));
//        store.dispatch(TaskActions.changeDescription("Task 1 такая Task 1"));
//        store.dispatch(TaskActions.changeCreatedAt(new Date()));
//
//        // add project
//        store.dispatch(ProjectActions.changeName("DI container"));
//        store.dispatch(ProjectActions.changeLanguage("java"));
//        store.dispatch(ProjectActions.addTask((TaskReducer.Task) taskReducer.getState()));
//
//        // add project list
//        store.dispatch(ProjectListActions.addProject((ProjectReducer.Project) projectReducer.getState()));
//
//        System.out.println(projectReducer.getState());
//    }
}
