package seal.libs.redux.state;

public abstract class State implements StateInterface
{
    protected final RootStateNode root;

    public State(String name, Object tree)
    {
        root = new RootStateNode(name, tree);
    }

    public RootStateNode get()
    {
        return root;
    }

}
