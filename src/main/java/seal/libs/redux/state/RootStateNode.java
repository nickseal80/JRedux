package seal.libs.redux.state;

public class RootStateNode
{
    String name;
    Object tree;

    public RootStateNode(String name, Object node)
    {
        this.name = name;
        this.tree = node;
    }

    public Object getTree()
    {
        return tree;
    }

    public void setTree(Object tree)
    {
        this.tree = tree;
    }
}
