package seal.libs.redux;

import java.util.function.Consumer;

@FunctionalInterface
public interface DispatchFunction extends Consumer<Object>
{
    void accept(Object action);
}
