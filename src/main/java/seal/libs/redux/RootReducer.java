package seal.libs.redux;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RootReducer implements Reducer {
    InitialState initialState = new InitialState();

    public RootReducer(Reducer @NotNull ...reducers ) {
        initialState.setReducers(List.of(reducers));
        for (Reducer reducer : reducers) {
            initialState.states.add(reducer.getState());
        }
    }

    @Override
    public State getState() {
        for (State state : initialState.getStates()) {
            return state;
        }

        return null;
    }

    @Override
    public void setInitialState(State state) {
        //
    }

    @Override
    public State reduce(Action<Object> action) {
        for (Reducer reducer : initialState.reducers) {
            return reducer.reduce(action);
        }

        return null;
    }

    public class InitialState {
        //____________________
        private List<Reducer> reducers = new ArrayList<>();

        public List<Reducer> getReducers() {
            return reducers;
        }

        public void setReducers(List<Reducer> reducers) {
            this.reducers = reducers;
        }

        //____________________
        private List<State> states = new ArrayList<>();

        public List<State> getStates() {
            return states;
        }

        public void setStates(List<State> states) {
            this.states = states;
        }
    }
}
