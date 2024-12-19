package seal.libs.redux.boundingRect;

import org.junit.jupiter.api.Test;
import seal.libs.redux.Store;
import seal.libs.redux.boundingRect.model.AddCoordinateAction;
import seal.libs.redux.boundingRect.model.BoundingRect;
import seal.libs.redux.boundingRect.model.BoundingRectReducer;
import seal.libs.redux.boundingRect.model.BoundingRectState;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TestBoundingRect
{
    Store<BoundingRectState> store;

    Map<String, Double> rect =
            Map.of("left", 10.0, "right", 40.0, "top", 10.0, "bottom", 40.0);

    BoundingRectState initialState = new BoundingRectState(rect);

    @Test
    public void testBoundingRect()
    {
        Store<BoundingRectState> store = new Store<>(initialState, new BoundingRectReducer());
        BoundingRect boundingRect = new BoundingRect();
        store.subscribe(boundingRect);

        assertEquals(store.getState(), initialState);

        store.dispatch(new AddCoordinateAction("left", 20.0));

        assertEquals(20.0, store.getState().getBoundingRect().get("left"));

        Map<String, Double> newRect = Map.of("left", 20.0, "right", 40.0, "top", 10.0, "bottom", 40.0);
        assertEquals(boundingRect.getAxis(), newRect);
        System.out.println(boundingRect.getAxis());
    }
}
