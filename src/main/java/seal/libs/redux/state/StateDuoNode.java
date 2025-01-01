package seal.libs.redux.state;

import java.util.Iterator;
import java.util.List;

public class StateDuoNode<K, V> implements Iterable<StateDuoNode<K, V>>
{
    K key;
    V value;
    StateDuoNode<K, V> parent;
    List<StateDuoNode<K, V>> children;

    public StateDuoNode(K key, V value)
    {
        this.key = key;
        this.value = value;
    }

    public StateDuoNode<K, V> addChild(K key, V value)
    {
        StateDuoNode<K, V> childNode = new StateDuoNode<>(key, value);
        childNode.parent = this;
        this.children.add(childNode);

        return childNode;
    }

    @Override
    public Iterator<StateDuoNode<K, V>> iterator()
    {
        return null;
    }
}
