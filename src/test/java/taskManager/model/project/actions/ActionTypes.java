package taskManager.model.project.actions;

import seal.libs.redux.action.ActionType;

public enum ActionTypes implements ActionType {
    CHANGE_NAME,
    CHANGE_LANGUAGE,
    CHANGE_CREATED_AT,
    CHANGE_UPDATED_AT,
    ADD_TASK,
    REMOVE_TASK,
}
