package seal.libs.redux.action;

public class ActionFactory<E extends Enum<E> & ActionType> {
    protected <P> Action<E, P> create(E type, P payload) {
        return new Action<>(type, payload);
    }
}
