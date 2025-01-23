package seal.libs.redux;

public interface Subscriber<S>
{
    void onChange(Action<Object> action, S state);
}
