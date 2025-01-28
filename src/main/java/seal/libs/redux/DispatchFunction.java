package seal.libs.redux;

import java.util.function.Consumer;

/**
 * Интерфейс DispatchFunction представляет собой функциональный интерфейс,
 * который расширяет интерфейс Consumer. Он предназначен для обработки
 * объектов действия, принимая их в качестве аргумента.
 * <p>
 * Этот интерфейс позволяет реализовать логику обработки действий
 * в виде лямбда-выражений или ссылок на методы, что упрощает
 * работу с функциональным программированием в Java.
 * <p>
 * Метод accept принимает объект действия и выполняет с ним
 * заданные операции.
 */
@FunctionalInterface
public interface DispatchFunction extends Consumer<Object>
{
    void accept(Object action);
}
