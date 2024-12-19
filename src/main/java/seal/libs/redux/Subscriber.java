package seal.libs.redux;

public interface Subscriber<S>
{
    void onChange(S state);
}
