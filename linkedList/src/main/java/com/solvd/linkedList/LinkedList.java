package com.solvd.linkedList;

import java.util.ListIterator;

public class LinkedList<T> implements Iterable<T> {
    private int n;
    private Node<T> pre;
    private Node<T> post;

    public LinkedList() {
        pre = new Node<>();
        post = new Node<>();
        pre.setNext(post);
        post.setPrev(pre);
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void add(T item) {
        Node<T> last = post.getPrev();
        Node<T> x = new Node<>();
        x.setItem(item);
        x.setNext(post);
        x.setPrev(last);
        post.setPrev(x);
        last.setNext(x);
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
            if (iterator.nextIndex() - 1 == index){
                iterator.remove();
                break;
            }
        }
    }

    public ListIterator<T> iterator() {
        return new LinkedListIterator<>(this);
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public Node<T> getPre() {
        return pre;
    }

    public void setPre(Node<T> pre) {
        this.pre = pre;
    }

    public Node<T> getPost() {
        return post;
    }

    public void setPost(Node<T> post) {
        this.post = post;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (T item : this)
            s.append(item).append(" ");
        return s.toString();
    }
}

