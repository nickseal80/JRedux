package seal.libs.redux;

public class ReducerContainer {
    //_________________
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //__________________
    private Reducer reducer;

    public Reducer getReducer() {
        return reducer;
    }

    public void setReducer(Reducer reducer) {
        this.reducer = reducer;
    }

    //__________________
    public ReducerContainer(String name, Reducer reducer) {
        this.name = name;
        this.reducer = reducer;
    }

    public ReducerContainer() {}


    @Override
    public String toString() {
        return "ReducerContainer [name=" + name + ", reducer=" + reducer + "]";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((reducer == null) ? 0 : reducer.hashCode());

        return result;
    }
}
