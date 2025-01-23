package ToDo.model.task;

import ToDo.model.task.actions.ActionTypes;
import org.jetbrains.annotations.NotNull;
import seal.libs.redux.Action;
import seal.libs.redux.Reducer;
import seal.libs.redux.State;
import seal.libs.redux.annotations.Contract;

import java.util.Date;
import java.util.Objects;

@Contract(innerState = true)
public class TaskReducer implements Reducer {
    Task state = new Task();

    @Override
    public State getState() {
        return state;
    }

    @Override
    public void setInitialState(State state) {}

    @Override
    public State reduce(@NotNull Action<Object> action) {
        switch (action.type()) {
            case ActionTypes.CHANGE_NAME -> {
                state.setName((String) action.payload());
                return state;
            }
            case ActionTypes.CHANGE_DESCRIPTION -> {
                state.setDescription((String) action.payload());
                return state;
            }
            case ActionTypes.CHANGE_STATUS -> {
                state.setStatus((String) action.payload());
                return state;
            }
            case ActionTypes.CHANGE_CREATED_AT -> {
                state.setCreatedAt((Date) action.payload());
                return state;
            }
            default -> {
                return state;
            }
        }
    }


    public class Task implements State {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        //___________________
        private String description;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        //___________________
        private String status;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        //___________________
        public Date createdAt;

        public Date getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
        }

        //___________________
        public Task() {}


        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Task {");
            sb.append("name='").append(name).append('\'');
            sb.append(", description='").append(description).append('\'');
            sb.append(", status=").append(status);
            sb.append(", createdAt=").append(createdAt);
            sb.append('}');

            return sb.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Task that = (Task) o;
            if (!Objects.equals(name, that.name)) return false;
            if (!Objects.equals(description, that.description)) return false;

            return Objects.equals(status, that.status);
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (description != null ? description.hashCode() : 0);
            result = 31 * result + (status != null ? status.hashCode() : 0);

            return result;
        }
    }
}
