package ToDo.model;

import seal.libs.redux.State;

import java.util.List;

public class TodoState implements State
{
    List<String> todoList;

    public TodoState(List<String> todoList)
    {
        this.todoList = todoList;
    }

    public List<String> getTodoList()
    {
        return todoList;
    }

    @SuppressWarnings("unchecked")
    public State withNew(Object todoList)
    {
        if (this.todoList.equals(todoList)) {
            return this;
        } else {
            return new TodoState((List<String>) todoList);
        }
    }

    @Override
    public String toString()
    {
        return this.todoList.toString();
    }
}
