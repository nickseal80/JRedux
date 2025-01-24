package seal.libs.redux;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class RootReducer implements Reducer {
    private InitialState initialState = new InitialState();
    private ReducerContainer[] reducerContainers;

    public RootReducer(ReducerContainer @NotNull ...containers ) {
        this.reducerContainers = containers.clone();
        for (ReducerContainer container : containers) {
            initialState.put(container.getName(), container.getReducer().getState());
        }
    }

    @Override
    public State getState() {
        return initialState;
    }

    @Override
    public void setInitialState(State state) {
        //
    }

    @Override
    public State reduce(Action<Object> action) {
        for (ReducerContainer container : reducerContainers) {
            initialState.put(container.getName(), container.getReducer().reduce(action));
        }

        return initialState;
    }

    public class InitialState extends HashMap<String, State> implements State {}
}
