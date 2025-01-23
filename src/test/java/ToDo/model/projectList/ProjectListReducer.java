package ToDo.model.projectList;

import ToDo.model.project.ProjectReducer;
import seal.libs.redux.Action;
import seal.libs.redux.Reducer;
import seal.libs.redux.State;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ProjectListReducer implements Reducer {
    @Override
    public State getState() {
        //
    }

    @Override
    public void setInitialState(State state) {

    }

    @Override
    public State reduce(Action<Object> action) {
        return Reducer.super.reduce(action);
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
        public boolean equals(Object o) {
            return super.equals(o);
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 29 * hash + Objects.hashCode(this.projects);

            return hash;
        }
    }
}
