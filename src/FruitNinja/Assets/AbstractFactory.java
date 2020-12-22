package FruitNinja.Assets;

public interface AbstractFactory<T> {
    T create(String asset);
}
