package fruitninja.assets;

public interface AbstractFactory<T> {
    T create(String asset);
}
