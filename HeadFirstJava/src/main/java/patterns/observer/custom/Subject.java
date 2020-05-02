package patterns.observer.custom;

import patterns.observer.custom.observers.Observer;

public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
