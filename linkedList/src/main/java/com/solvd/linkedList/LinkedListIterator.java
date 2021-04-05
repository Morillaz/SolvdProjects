package com.solvd.linkedList;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedListIterator<T> implements ListIterator<T> {
    private LinkedList<T> l;
    private Node<T> current;
    private Node<T> lastAccessed;
    private int index;

    public LinkedListIterator(LinkedList<T> l) {
        this.l = l;
        current = l.getPre().next;
        lastAccessed = null;
        index = 0;
    }

    public boolean hasNext() {
        return index < l.getN();
    }

    public boolean hasPrevious() {
        return index > 0;
    }

    public int previousIndex() {
        return index - 1;
    }

    public int nextIndex() {
        return index;
    }

    public T next() {
        if (!hasNext()) throw new NoSuchElementException();
        lastAccessed = current;
        T item = current.item;
        current = current.next;
        index++;
        return item;
    }

    public T previous() {
        if (!hasPrevious()) throw new NoSuchElementException();
        current = current.prev;
        index--;
        lastAccessed = current;
        return current.item;
    }

    public void set(T item) {
        if (lastAccessed == null) throw new IllegalStateException();
        lastAccessed.item = item;
    }

    public void remove() {
        if (lastAccessed == null) throw new IllegalStateException();
        Node<T> x = lastAccessed.prev;
        Node<T> y = lastAccessed.next;
        x.next = y;
        y.prev = x;
        l.setN(l.getN() - 1);
        if (current == lastAccessed)
            current = y;
        else
            index--;
        lastAccessed = null;
    }

    public void add(T item) {
        Node<T> x = current.prev;
        Node<T> y = new Node<>();
        Node<T> z = current;
        y.item = item;
        x.next = y;
        y.next = z;
        z.prev = y;
        y.prev = x;
        l.setN(l.getN() + 1);
        index++;
        lastAccessed = null;
    }

}
