package taskManager.model.project.actions;

import seal.libs.redux.action.ActionFactory;
import seal.libs.redux.action.Action;

import java.util.Date;

public class ProjectActions extends ActionFactory<ActionTypes> {
    public static final ProjectActions INSTANCE = new ProjectActions();

    private ProjectActions() {}

    public Action<ActionTypes, String> changeName(String name) {
        return create(ActionTypes.CHANGE_NAME, name);
    }

    public Action<ActionTypes, String> changeLanguage(String language) {
        return create(ActionTypes.CHANGE_LANGUAGE, language);
    }

    public Action<ActionTypes, Date> changeCreatedAt(Date createdAt) {
        return create(ActionTypes.CHANGE_CREATED_AT, createdAt);
    }

    public Action<ActionTypes, Date> changeUpdatedAt(Date updatedAt) {
        return create(ActionTypes.CHANGE_UPDATED_AT, updatedAt);
    }
}
