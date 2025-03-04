package seal.libs.redux;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import seal.libs.redux.action.ActionType;
import seal.libs.redux.reducer.Reducer;
import seal.libs.redux.reducer.RootReducer;

import java.util.Map;

public class Redux {
    @Contract("_ -> new")
    public static <T extends Enum<T> & ActionType> @NotNull Reducer<T> combineReducers(Map<String, Reducer<T>> reducers) {
        return new RootReducer<>(reducers);
    }
}
