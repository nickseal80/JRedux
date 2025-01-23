package ToDo.model.project;

import ToDo.model.project.actions.ActionTypes;
import ToDo.model.task.TaskReducer;
import org.jetbrains.annotations.NotNull;
import seal.libs.redux.Action;
import seal.libs.redux.Reducer;
import seal.libs.redux.State;
import seal.libs.redux.annotations.Contract;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Contract(innerState = true)
public class ProjectReducer implements Reducer {
    Project state = new Project();

    @Override
    public State getState() {
        return this.state;
    }

    @Override
    public void setInitialState(State state) {
        this.state = (Project) state;
    }

    @Override
    public State reduce(@NotNull Action<Object> action) {
        switch (action.type()) {
            case ActionTypes.CHANGE_NAME -> {
                state.setName((String) action.payload());
                state.setUpdatedAt(new Date());
                return state;
            }
            case ActionTypes.CHANGE_LANGUAGE -> {
                state.setLanguage((String) action.payload());
                state.setUpdatedAt(new Date());
                return state;
            }
            case ActionTypes.CHANGE_CREATED_AT -> {
                state.setCreatedAt((Date) action.payload());
                return state;
            }
            case ActionTypes.CHANGE_UPDATED_AT -> {
                state.setUpdatedAt((Date) action.payload());
                return state;
            }
            case ActionTypes.ADD_TASK -> {
                state.getTasks().add((TaskReducer.Task) action.payload());
                return state;
            }
            case ActionTypes.REMOVE_TASK -> {
                state.getTasks().remove((TaskReducer.Task) action.payload());
                return state;
            }
            default -> {
                return state;
            }
        }
    }


    public class Project implements State {
        //__________________
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        //__________________
        private String language;

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        //___________________
        private Date createdAt;

        public Date getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
        }

        //___________________
        private Date updatedAt;

        public Date getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Date updatedAt) {
            this.updatedAt = updatedAt;
        }

        //___________________
        private List<TaskReducer.Task> tasks;

        public List<TaskReducer.Task> getTasks() {
            return tasks;
        }

        public void setTasks(List<TaskReducer.Task> tasks) {
            this.tasks = tasks;
        }

        //___________________
        public Project() {}


        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Project {");
            sb.append("name: ").append(name).append('\'');
            sb.append(", language: ").append(language).append('\'');
            sb.append(", createdAt: ").append(createdAt).append('\'');
            sb.append(", updatedAt: ").append(updatedAt).append('\'');
            sb.append(", tasks: ").append(tasks.toString());

            return sb.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Project project = (Project) o;
            if (!Objects.equals(name, project.name)) return false;
            if (!Objects.equals(language, project.language)) return false;

            return createdAt.equals(project.createdAt) && updatedAt.equals(project.updatedAt);
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (language != null ? language.hashCode() : 0);
            result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
            result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);

            return result;
        }
    }
}
