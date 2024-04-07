package com.bookstore.bookstore.ObserverDesignPattern;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(String msg);
}
