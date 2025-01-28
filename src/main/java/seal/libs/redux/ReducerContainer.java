package seal.libs.redux;

public class ReducerContainer {
    //_________________
    private String name;

    /**
     * Возвращает имя объекта.
     *
     * @return имя в виде строки.
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает значение имени.
     *
     * @param name Имя, которое будет установлено.
     */
    public void setName(String name) {
        this.name = name;
    }

    //__________________
    private Reducer reducer;

    /**
     * Возвращает объект типа Reducer, который используется для обработки данных.
     *
     * @return объект типа Reducer
     */
    public Reducer getReducer() {
        return reducer;
    }

    /**
     * Устанавливает редуктор для данного объекта.
     *
     * @param reducer экземпляр класса Reducer, который будет установлен.
     */
    public void setReducer(Reducer reducer) {
        this.reducer = reducer;
    }

    //__________________

    /**
     * Класс ReducerContainer представляет собой контейнер для редюсера.
     * Он используется для хранения имени и экземпляра редюсера.
     *
     * @param name имя контейнера редюсера.
     * @param reducer экземпляр редюсера, который будет использоваться в этом контейнере.
     */
    public ReducerContainer(String name, Reducer reducer) {
        this.name = name;
        this.reducer = reducer;
    }

    public ReducerContainer() {}


    /**
     * Возвращает строковое представление объекта ReducerContainer.
     * Строка содержит имя контейнера и информацию о редюсере.
     *
     * @return строковое представление объекта в формате "ReducerContainer [name=<имя>, reducer=<редюсер>]"
     */
    @Override
    public String toString() {
        return "ReducerContainer [name=" + name + ", reducer=" + reducer + "]";
    }

    /**
     * Сравнивает текущий объект с указанным объектом для определения их равенства.
     *
     * @param obj объект, с которым будет произведено сравнение.
     * @return возвращает true, если указанный объект равен текущему объекту; в противном случае возвращает false.
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * Возвращает хэш-код объекта. Хэш-код вычисляется на основе значений полей
     * name и reducer. Используется простая формула, где хэш-код каждого поля
     * умножается на простое число 31, что помогает уменьшить количество
     * коллизий в хэш-таблицах.
     *
     * @return хэш-код объекта в виде целого числа.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((reducer == null) ? 0 : reducer.hashCode());

        return result;
    }
}
