package seal.libs.redux;

/**
 * Record Action представляет экземпляр метода экшнов в стандартной библиотеке Redux
 * <P>
 *     Для примера: <br/>
 *     <code>
 *         public static Action&lt;ActionTypes> addToList(String text) <br/>
 *         { <br/>
 *             &nbsp;&nbsp;&nbsp;&nbsp;return new Action<>(ActionTypes.ADD_TO_LIST, text); <br/>
 *         }
 *     </code>
 *
 *
 * @param type описание действия экшена
 * @param payload данные хранилища, над которыми будут производится действия
 * @param <T> тип описания действия экшена. Как правило это String или Enum
 */
public record Action<T>(T type, Object payload)
{
}
