package lectures.collections.generics;

/**
 * Created by alisher on 3/25/16.
 */
public class Box <T> {
    private T element;

    public T getElement() {
        return element;
    }

    public void putElement(T element) {
        this.element = element;
        Box<Car> carBox = new Box<Car>();
        Car car = new Car();
        carBox.putElement(car);
    }
}
