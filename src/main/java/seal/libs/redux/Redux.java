package seal.libs.redux;

import org.javatuples.Pair;

import java.util.HashMap;
import java.util.Map;

public class Redux
{
    @SafeVarargs
    public static Reducer combineReducers(Pair<String, Reducer>... reducers)
    {
        HashMap<String, Reducer> allReducers = new HashMap<>();
        for (Pair<String, Reducer> reducer : reducers) {
            allReducers.put(reducer.getValue0(), reducer.getValue1());
        }

        return (oldState, action) -> {
            State s = new State()
            {
                Map<String, Reducer> reducers = allReducers;
            };

            for (Map.Entry<String, Reducer> entry : allReducers.entrySet()) {

            }

            return oldState;
        };
    }
}
