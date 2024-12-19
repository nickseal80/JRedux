package seal.libs.redux.boundingRect.model;

import java.util.Map;

public class BoundingRectState
{
    private final Map<String, Double> boundingRect;

    public BoundingRectState(Map<String, Double> boundingRect)
    {
        this.boundingRect = boundingRect;
    }

    public Map<String, Double> getBoundingRect()
    {
        return boundingRect;
    }

    public BoundingRectState withBoundingRect(Map<String, Double> boundingRect)
    {
        if (boundingRect.equals(this.boundingRect)) {
            return this;
        } else {
            return new BoundingRectState(boundingRect);
        }
    }
}
