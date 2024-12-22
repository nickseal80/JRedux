package seal.libs.redux;

/**
 * Интерфейс редьюссера. Пример реализации представлен в файле readme.md
 */
public interface Reducer
{
    State reduce(State oldState, Action<Object> action);
}
