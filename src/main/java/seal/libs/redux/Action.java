package seal.libs.redux;

public class Action
{
    public Action(Enum<?> type, Object payload)
    {
        this.type = type;
        this.payload = payload;
    }

    private final Enum<?> type;

    public Enum<?> getType()
    {
        return type;
    }

    private final Object payload;

    public Object getPayload()
    {
        return payload;
    }
}
