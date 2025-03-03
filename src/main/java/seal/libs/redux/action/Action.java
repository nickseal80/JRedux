package seal.libs.redux.action;

/**
 * Представляет действие с определенным типом и полезной нагрузкой.
 */
public record Action<E extends Enum<E> & ActionType, P>(E type, P payload) {}