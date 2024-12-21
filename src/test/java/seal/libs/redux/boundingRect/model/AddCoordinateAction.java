package seal.libs.redux.boundingRect.model;

import java.util.Map;

public class AddCoordinateAction
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
