package seal.libs.redux.utils;

import com.google.gson.Gson;

@SuppressWarnings("unchecked")
public class CloneUtil {
    private static final Gson gson = new Gson();

    public static <T> T deepClone(T object) {
        return gson.fromJson(gson.toJson(object), (Class<T>) object.getClass());
    }
}
