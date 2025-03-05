package seal.libs.redux;

/**
 * A subscription interface used to unsubscribe from notifications or updates.
 */
public interface Subscription
{

    /**
     * Unsubscribes from the subscription, preventing further updates from being received.
     */
    void unsubscribe();
}
