package ToDo.model;

import seal.libs.redux.Action;

public class Actions
{
    public static Action addTODO(String text)
    {
        return new Action(ActionTypes.ADD_TODO, text);
    }

    public static Action deleteTODO(String text)
    {
        return new Action(ActionTypes.DELETE_TODO, text);
    }

    public static Action setTODOStatus(Enum<?> status)
    {
        return new Action(ActionTypes.SET_TODO_STATUS, status);
    }
}
