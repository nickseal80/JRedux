package seal.libs.redux;

import java.util.function.Consumer;

/**
 * Функциональный интерфейс отправки данных хранилища для потребителей (объектов-подписчиков)
 * @see seal.libs.redux.Store#dispatch(Object)
 */
@FunctionalInterface
public interface DispatchFunction extends Consumer<Object>
{
    void accept(Object action);
}
