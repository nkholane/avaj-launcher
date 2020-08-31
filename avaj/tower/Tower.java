package dev.avaj.tower;

import dev.avaj.Flyable;

import java.util.LinkedList;

public abstract class Tower {
    private LinkedList<Flyable> observers = new LinkedList<Flyable>();

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionsChanged(){
        for (int a = 0; a < observers.size(); a++){
            observers.get(a).updateConditions();
        }

    }
}
//This section is done