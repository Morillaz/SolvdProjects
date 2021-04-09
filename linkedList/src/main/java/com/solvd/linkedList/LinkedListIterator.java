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
        current = l.getPre().getNext();
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
        T item = current.getItem();
        current = current.getNext();
        index++;
        return item;
    }

    public T previous() {
        if (!hasPrevious()) throw new NoSuchElementException();
        current = current.getPrev();
        index--;
        lastAccessed = current;
        return current.getItem();
    }

    public void set(T item) {
        if (lastAccessed == null) throw new IllegalStateException();
        lastAccessed.setItem(item);
    }

    public void remove() {
        if (lastAccessed == null) throw new IllegalStateException();
        Node<T> x = lastAccessed.getPrev();
        Node<T> y = lastAccessed.getNext();
        x.setNext(y);
        y.setPrev(x);
        l.setN(l.getN() - 1);
        if (current == lastAccessed)
            current = y;
        else
            index--;
        lastAccessed = null;
    }

    public void add(T item) {
        Node<T> x = current.getPrev();
        Node<T> y = new Node<>();
        Node<T> z = current;
        y.setItem(item);
        x.setNext(y);
        y.setNext(z);
        z.setPrev(y);
        y.setPrev(x);
        l.setN(l.getN() + 1);
        index++;
        lastAccessed = null;
    }

}
