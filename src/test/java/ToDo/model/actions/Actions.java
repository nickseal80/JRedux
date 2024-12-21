package ToDo.model.actions;

import seal.libs.redux.Action;

public class Actions
{
    public static Action<ActionTypes> addTODO(String text)
    {
        return new Action<>(ActionTypes.ADD_TODO, text);
    }

    public static Action<ActionTypes> deleteTODO(String text)
    {
        return new Action<>(ActionTypes.DELETE_TODO, text);
    }

    public static Action<ActionTypes> setTODOStatus(Enum<?> status)
    {
        return new Action<>(ActionTypes.SET_TODO_STATUS, status);
    }
}
