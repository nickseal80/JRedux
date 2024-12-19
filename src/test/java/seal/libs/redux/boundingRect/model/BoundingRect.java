package seal.libs.redux.boundingRect.model;

import seal.libs.redux.Subscriber;

import java.util.Map;

public class BoundingRect implements Subscriber<BoundingRectState>
{
    private Map<String, Double> axis =
            Map.of("left", 10.0, "right", 40.0, "top", 10.0, "bottom", 40.0);

    public Map<String, Double> getAxis()
    {
        return axis;
    }

    public void setAxis(Map<String, Double> axis)
    {
        this.axis = axis;
    }

    @Override
    public void onChange(BoundingRectState state)
    {
        this.axis = state.getBoundingRect();
    }
}
