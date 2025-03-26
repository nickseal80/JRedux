# Redux-like Java Library

This is a simple Java library implementing a Redux-like pattern for state 
management. It provides tools to manage application state through actions, 
reducers, and stores. This library is designed to mimic the core concepts of 
Redux, popularized by JavaScript applications, with a focus on strong type safety.

## Key Concepts

### Action
An **Action** represents an event or a change that occurs in the application. 
Each action has a type and payload.

- **ActionType:** An interface implemented by enums to categorize actions.
- **Action:** A record class that holds an `ActionType` and a `payload` of a generic type.

### Reducer
A **Reducer** is responsible for updating the state in response to actions. 
It defines how the application state should change when an action is dispatched.

- **Reducer:** An interface that requires the method `reduce(Action)` to return a new state based 
on the action.
- **RootReducer:** A concrete implementation of the `Reducer` interface that combines multiple 
reducers into a single root reducer.

### Store
The **Store** holds the application's state and allows actions to be dispatched to update it. 
It also manages subscribers who are notified when the state changes.

- **Store:** The central object responsible for holding the current state, dispatching actions, 
and notifying subscribers of state changes.
- **DispatchFunction:** A functional interface used to dispatch actions.
- **Subscription:** An interface for unsubscribing from state change notifications.
- **Subscriber:** An interface for subscribing to state changes.

### Combining Reducers
The library allows you to combine multiple reducers into one root reducer using the
`Redux.combineReducers()` utility.

---

## Getting Started

### Dependencies
This library is written in Java and can be used in any Java-based project. 
There are no external dependencies required for basic usage.

### Usage
Here’s how you can use the library to create a Redux-like state management system.

#### Step 1: Define Action Types
Define an enum that implements `ActionType`.
```java
public enum MyActionType implements ActionType {
    INCREMENT,
    DECREMENT;
}
```

#### Step 2: Create Actions
Define actions using the `Action` record.
```java
Action<MyActionType, Integer> incrementAction = new Action<>(MyActionType.INCREMENT, 1);
Action<MyActionType, Integer> decrementAction = new Action<>(MyActionType.DECREMENT, 1);
```
Or use the ActionFactory.
```java
public class Actions extends ActionFactory<MyActionType> {
    public static final Actions INSTANCE = new Actions();

    public Action<MyActionType, Integer> incrementAction() {
        return create(MyActionType.INCREMENT, 1);
    }

    public Action<MyActionType, Integer> incrementAction() {
        return create(MyActionType.DECREMENT, 1);
    }
}
```

#### Step 3: Create Reducers
Create reducers for your application state.
```java
public class CounterReducer implements Reducer<MyActionType> {
    private int count = 0;

    @Override
    public State getState() {
        return new CounterState(count);
    }

    @Override
    public State reduce(Action<MyActionType, ?> action) {
        if (action.type() == MyActionType.INCREMENT) {
            count += (Integer) action.payload();
        } else if (action.type() == MyActionType.DECREMENT) {
            count -= (Integer) action.payload();
        }
        return new CounterState(count);
    }
}
```

#### Step 4: Combine Reducers
If you have multiple reducers, combine them into a root reducer.
```java
Map<String, Reducer<MyActionType>> reducers = Map.of(
    "counter", new CounterReducer()
);

Reducer<MyActionType> rootReducer = Redux.combineReducers(reducers);
```

#### Step 5: Create a Store
Create a store using the root reducer.
```java
Store<MyActionType> store = StoreFactory.getOrCreateStore(rootReducer);
```

#### Step 6: Dispatch Actions
Now you can dispatch actions to update the state.
```java
store.dispatch(incrementAction);
store.dispatch(decrementAction);
```

#### Step 7: Subscribe to State Changes
You can subscribe to state changes and receive notifications when the state updates.
```java
store.subscribe((action, state) -> {
    System.out.println("State changed: " + state);
});
```

---

## API Overview
### Action
```java
public record Action<E extends Enum<E> & ActionType, P>(E type, P payload) {}
```
Represents an action with a type and payload.

### Reducer
```java
public interface Reducer<E extends Enum<E> & ActionType> {
    State getState();
    State reduce(Action<E, ?> action);
}
```
A reducer that handles state changes based on actions.

### RootReducer
```java
public class RootReducer<T extends Enum<T> & ActionType> implements Reducer<T> {
    // Combines multiple reducers into one.
}
```
A reducer that combines multiple sub-reducers into a root reducer.

### Store
```java
public class Store<E extends Enum<E> & ActionType> {
    public State getState();
    public void dispatch(Action<E, ?> action);
    public Subscription subscribe(Subscriber<State> subscriber);
}
```
Holds the application state, dispatches actions, and notifies subscribers of state changes.

### Subscriber
```java
public interface Subscriber<S> {
    void onChange(Action<?, ?> action, S state);
}
```
An interface for subscribing to state changes.

### Subscription
```java
public interface Subscription {
    void unsubscribe();
}
```
An interface for unsubscribing from state change notifications.

---

## Contributing
Feel free to contribute to this library! If you find a bug or want to suggest a feature,
open an issue or submit a pull request.

---

## License
This library is licensed under the MIT License.
