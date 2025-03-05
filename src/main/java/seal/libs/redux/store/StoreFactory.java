package seal.libs.redux.store;

import org.jetbrains.annotations.NotNull;
import seal.libs.redux.action.ActionType;
import seal.libs.redux.reducer.Reducer;

public class StoreFactory {
    private static Store instance;

    private StoreFactory() {} // Запрещаем создание экземпляров

    public static synchronized <E extends Enum<E> & ActionType> Store<E> getOrCreateStore(@NotNull Reducer<E> reducer) {
        if (instance == null) {
            instance = new Store<>(reducer);
        }
        return instance;
    }

    public static synchronized void resetStore() {
        instance = null;
    }
}
