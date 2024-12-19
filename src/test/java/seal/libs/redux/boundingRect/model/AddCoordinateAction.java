package seal.libs.redux.boundingRect.model;

import seal.libs.redux.Action;

import java.util.HashMap;
import java.util.Map;

public class BoundingRectAction implements Action
{
    private final Map<String, Double> coordinate;

    public BoundingRectAction(String name, double value)
    {
        this.coordinate = Map.of(name, value);
    }

    public Map<String, Double> getCoordinate()
    {
        return coordinate;
    }
}
