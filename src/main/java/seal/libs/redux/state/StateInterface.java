package seal.libs.redux.state;

/**
 * Интерфейс текущего состояния. Пример реализации представлен в файле readme.md
 */
public interface StateInterface
{
    StateInterface withNew(Object data);
}
