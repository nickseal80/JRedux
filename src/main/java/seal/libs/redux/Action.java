package seal.libs.redux;

/**
 * Представляет действие с определенным типом и полезной нагрузкой.
 *
 * @param <T> Тип действия.
 * @param type Тип действия.
 * @param payload Полезная нагрузка, связанная с действием.
 */
public record Action<T>(T type, Object payload) {}
