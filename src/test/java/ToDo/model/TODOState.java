package ToDo.model;

import seal.libs.redux.State;

import java.util.List;

public class TODOState implements State
{
    List<String> todoList;

    public TODOState(List<String> todoList)
    {
        this.todoList = todoList;
    }

    public List<String> getTodoList()
    {
        return todoList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public State withNew(Object todoList)
    {
        if (this.todoList.equals(todoList)) {
            return this;
        } else {
            return new TODOState((List<String>) todoList);
        }
    }
}
