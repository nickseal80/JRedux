package seal.libs.redux;

public interface Reducer<S>
{
    S reduce(S oldState, Action action);
}
