package com.solvd.linkedList;

import java.util.ListIterator;
import java.util.NoSuchElementException;


public class LinkedList<T> implements Iterable<T> {
    private int n;
    private Node<T> pre;
    private Node<T> post;

    public LinkedList() {
        pre = new Node<>();
        post = new Node<>();
        pre.next = post;
        post.prev = pre;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void add(T item) {
        Node<T> last = post.prev;
        Node<T> x = new Node<>();
        x.item = item;
        x.next = post;
        x.prev = last;
        post.prev = x;
        last.next = x;
        n++;
    }

    void remove(T item){
        ListIterator<T> iterator = this.iterator();
        while (iterator.hasNext()){
            T toRemove = iterator.next();
            if (toRemove.equals(item)){
                iterator.remove();
                break;
            }
        }
    }

    void remove(int index){
        ListIterator<T> iterator = this.iterator();
        while (iterator.hasNext()){
            T x = iterator.next();
            if (iterator.nextIndex() - 1 == index){
                iterator.remove();
                break;
            }
        }
    }

    public ListIterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements ListIterator<T> {
        private Node<T> current = pre.next;
        private Node<T> lastAccessed = null;
        private int index = 0;

        public boolean hasNext() {
            return index < n;
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
            n--;
            if (current == lastAccessed)
                current = y;
            else
                index--;
            lastAccessed = null;
        }

        // add element to list
        public void add(T item) {
            Node<T> x = current.prev;
            Node<T> y = new Node<>();
            Node<T> z = current;
            y.item = item;
            x.next = y;
            y.next = z;
            z.prev = y;
            y.prev = x;
            n++;
            index++;
            lastAccessed = null;
        }

    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (T item : this)
            s.append(item).append(" ");
        return s.toString();
    }
}

