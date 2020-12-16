package FruitNinja.Models;

public class MovingObjectFactory {
    public NeutralMovingObject createNeutralMovingObject(String object) throws NullPointerException {
        if (object.equals("Fruit")) {
            return new Fruit(); // TODO: 16/12/2020 change later
        }
        return null;
    }
}
