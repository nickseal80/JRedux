package seal.libs.redux;

/**
 * Интерфейс редьюссера. Пример реализации представлен в файле readme.md
 */
public interface Reducer
{
    public State getState();

    void setInitialState(State state);

    default State reduce(State state, Action<Object> action) {
        return state;
    }

    default State reduce(Action<Object> action) {
        return null;
    }
}
