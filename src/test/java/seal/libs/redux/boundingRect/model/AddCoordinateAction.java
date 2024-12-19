package seal.libs.redux.boundingRect.model;

import seal.libs.redux.Action;

import java.util.Map;

public class AddCoordinateAction implements Action
{
    private final Map<String, Double> coordinate;

    public AddCoordinateAction(String name, double value)
    {
        this.coordinate = Map.of(name, value);
    }

    public Map<String, Double> getCoordinate()
    {
        return coordinate;
    }
}
