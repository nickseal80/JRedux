package seal.libs.redux;

/**
 * Интерфейс Subscriber предназначен для обработки изменений состояния.
 *
 * @param <S> Тип состояния, который будет передан в метод onChange.
 * Метод onChange вызывается при изменении состояния и принимает действие и текущее состояние.
 */
public interface Subscriber<S>
{
    void onChange(Action<Object> action, S state);
}
