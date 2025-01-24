package taskManager.model.projectList;

import seal.libs.redux.utils.CloneUtil;
import taskManager.model.project.ProjectReducer;
import taskManager.model.projectList.actions.ActionTypes;
import org.jetbrains.annotations.NotNull;
import seal.libs.redux.Action;
import seal.libs.redux.Reducer;
import seal.libs.redux.State;
import seal.libs.redux.annotations.Contract;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Contract(innerState = true)
public class ProjectListReducer implements Reducer {
    ProjectList state = new ProjectList();

    @Override
    public State getState() {
        return state;
    }

    @Override
    public void setInitialState(State state) {
        //
    }

    @Override
    public State reduce(@NotNull Action<Object> action) {
        switch (action.type()) {
            case ActionTypes.ADD_PROJECT -> {
                state.getProjects().add((ProjectReducer.Project) action.payload());
                return CloneUtil.deepClone(state);
            }
            case ActionTypes.REMOVE_PROJECT -> {
                state.getProjects().remove((ProjectReducer.Project) action.payload());
                return CloneUtil.deepClone(state);
            }
            default -> {
                return state;
            }
        }
    }


    public class ProjectList implements State {
        //__________________
        private List<ProjectReducer.Project> projects;

        public List<ProjectReducer.Project> getProjects() {
            return projects;
        }

        public void setProjects(List<ProjectReducer.Project> projects) {
            this.projects = projects;
        }

        //__________________
        private Date createdAt;

        public Date getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
        }

        //___________________
        public ProjectList() {}


        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (ProjectReducer.Project project : projects) {
                sb.append(project.toString());
            }
            sb.append("\n");
            sb.append("CreatedAt: " + createdAt + "\n");

            return sb.toString();
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 29 * hash + Objects.hashCode(this.projects);

            return hash;
        }
    }
}
