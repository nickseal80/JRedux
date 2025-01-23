package seal.libs.redux.config;

import java.util.ArrayList;
import java.util.List;

public class ReduxConfig {
    public static final String DISPATCH_METHOD_SUBSCRIBE = "useSubscribe";
    public static final String DISPATCH_METHOD_EVENT = "useEvent";

    //_______________
    private String packageName;

    public String getPackageName() {
        return packageName;
    }

    public ReduxConfig setPackageName(String packageName) {
        this.packageName = packageName;

        return this;
    }

    //_______________
    private List<String> dispatchMethods = new ArrayList<>();

    public List<String> getDispatchMethods() {
        return dispatchMethods;
    }

    public void setDispatchMethods(List<String> dispatchMethods) {
        this.dispatchMethods = dispatchMethods;
    }

    //_______________
    public ReduxConfig add() {
        return this;
    }


}
