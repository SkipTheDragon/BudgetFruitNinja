package FruitNinja.Events;

import FruitNinja.Events.Game.GameEventListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventManager<T extends EventListener> {
    protected Map<String, List<T>> listeners = new ConcurrentHashMap<>();

    public EventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new CopyOnWriteArrayList<>());
        }
    }

    public void subscribe(String eventType, T listener) {
        List<T> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, T listener) {
        List<T> users = listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(String eventType) {
        List<T> users = listeners.get(eventType);
        for (T listener : users) {
            listener.update(eventType);
        }
    }

}