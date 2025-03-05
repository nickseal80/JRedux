package seal.libs.redux.action;

public record Action<E extends Enum<E> & ActionType, P>(E type, P payload) {}