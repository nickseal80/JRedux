package seal.libs.redux;

/**
 * Интерфейс Subscription представляет собой контракт для управления подписками.
 * Он определяет метод для отмены подписки.
 */
public interface Subscription
{
    void unsubscribe();
}
