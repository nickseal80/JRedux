package seal.libs.redux;

import seal.libs.redux.state.StateInterface;

/**
 * Интерфейс редьюссера. Пример реализации представлен в файле readme.md
 */
public interface Reducer
{
    StateInterface reduce(StateInterface oldState, Action<Object> action);
}
