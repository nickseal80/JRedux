package seal.libs.redux;

public interface Reducer
{
    State reduce(State oldState, Action<Object> action);
}
