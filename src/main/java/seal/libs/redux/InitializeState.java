package seal.libs.redux;

public class InitializeState implements State {
    private String name = "asa";
    private String description = "asa is a good potat";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public State withNew(Object data) {
        return this;
    }

    @Override
    public Object getImplementationObject() {
        return this;
    }
}
