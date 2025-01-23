package seal.libs.redux;

import java.util.HashMap;
import java.util.Map;

public class RootReducer implements Reducer {
    InitialState initialState = new InitialState();
    Map<String, Reducer> reducers = new HashMap<>();

    public RootReducer(ReducerContainer ...containers ) {
        for (ReducerContainer container : containers) {
            reducers.put(container.getName(), container.getReducer());
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
        for (String key : reducers.keySet()) {
            Reducer reducer = reducers.get(key);
            initialState.getState().put(key, reducer.reduce(action));
        }

        return initialState;
    }

    public class InitialState implements State {
        private Map<String, Object> state = new HashMap<>();

        public Map<String, Object> getState() {
            return state;
        }

        public void setState(Map<String, Object> state) {
            this.state = state;
        }
    }
}
