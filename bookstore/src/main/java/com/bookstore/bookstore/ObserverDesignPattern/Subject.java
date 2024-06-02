package com.bookstore.bookstore.ObserverDesignPattern;

public interface Subject {
    /**
     * Attaches an observer to the subject.
     *
     * @param observer The observer to attach to the subject.
     */
    void attach(Observer observer);

    /**
     * Detaches an observer from the subject.
     *
     * @param observer The observer to detach from the subject.
     */
    void detach(Observer observer);

    /**
     * Notifies all attached observers of a change in the subject.
     *
     * @param msg The message or data associated with the change in the subject.
     *            This can vary depending on the implementation.
     */
    void notifyObservers(String msg);
}
