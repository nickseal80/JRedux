package seal.libs.redux.boundingRect.model;

import seal.libs.redux.Action;
import seal.libs.redux.Reducer;

import java.util.HashMap;
import java.util.Map;

public class BoundingRectReducer implements Reducer<BoundingRectState>
{
    @Override
    public BoundingRectState reduce(BoundingRectState oldState, Action action)
    {
        if (action instanceof AddCoordinateAction addCoordinateAction) {

            Map<String, Double> oldBoundingRect = oldState.getBoundingRect();

            Map<String, Double> newBoundingRect = new HashMap<>(oldBoundingRect);
            newBoundingRect.putAll(addCoordinateAction.getCoordinate());

            return oldState.withBoundingRect(newBoundingRect);
        }

        return oldState;
    }
}
