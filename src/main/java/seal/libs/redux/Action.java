package seal.libs.redux;

public class Action <T>
{
    public Action(T type, Object payload)
    {
        this.type = type;
        this.payload = payload;
    }

    private final T type;

    public T getType()
    {
        return type;
    }

    private final Object payload;

    public Object getPayload()
    {
        return payload;
    }
}
