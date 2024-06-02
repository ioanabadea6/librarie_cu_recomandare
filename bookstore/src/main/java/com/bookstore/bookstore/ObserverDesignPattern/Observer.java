package com.bookstore.bookstore.ObserverDesignPattern;

public interface Observer {
    /**
     * This method is called by the subject to notify the observer of a change.
     *
     * @param msg The message or data associated with the update from the subject.
     *            This can vary depending on the implementation.
     */
    void update(String msg);
}
