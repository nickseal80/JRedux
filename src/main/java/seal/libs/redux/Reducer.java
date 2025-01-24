package seal.libs.redux;

/**
 * Интерфейс редьюссера. Пример реализации представлен в файле readme.md
 */
public interface Reducer
{
    public State getState();

    void setInitialState(State state);

    State reduce(Action<Object> action);
}
