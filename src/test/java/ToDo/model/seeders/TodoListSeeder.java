package ToDo.model.seeders;

import java.util.ArrayList;
import java.util.List;

public class TodoListSeeder
{
    public static List<String> todoList()
    {
        List<String> list = new ArrayList<>();
        list.add("Planning");
        list.add("PBR epic");
        list.add("launch");
        list.add("Epic 112");
        list.add("Epic 113");
        list.add("End of work");

        return list;
    }
}
