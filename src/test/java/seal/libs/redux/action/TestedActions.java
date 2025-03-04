package seal.libs.redux.action;

import java.util.Date;

public class TestedActions extends ActionFactory<ActionTypes> {
    public static final TestedActions INSTANCE = new TestedActions();

    private TestedActions() {}

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
