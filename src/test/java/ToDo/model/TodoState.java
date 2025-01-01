package ToDo.model;

import seal.libs.redux.state.RootStateNode;
import seal.libs.redux.state.StateInterface;

import java.util.List;

public class TodoState implements StateInterface
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


    @Override
    @SuppressWarnings("unchecked")
    public StateInterface withNew(Object todoList)
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
