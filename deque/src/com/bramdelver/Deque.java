package com.bramdelver;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Deque data structure implemented with a doubly-linked list for worst-case constant time operations.
 * Also implements iterator to allow for enhanced for-loop.
 *
 * Supports the following methods:
 * addFirst, addLast, removeFirst, removeLast, isEmpty and size
 */
public class Deque<Item> implements Iterable<Item> {
    private node first;
    private node last;
    private int size;

    public Deque() {
        first = null;
        last = null;
        size = 0;
    }

    /*
     * Private node class to implement the linked list
     */
    private class node {
        private Item value;
        private node next;
        private node previous;

        public node(Item value) {
            this.value = value;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    /*
     * Returns the number of elements in the deque
     */
    public int size() {
        return size;
    }

    /*
     * Adds an item to the beginning of the list
     */
    public boolean addFirst(Item item) {
        if (item == null) {
            return false;
        }

        if (first == null) { // Our list is currently empty
            first = new node(item);
            last = first;
        } else {
            node oldFirst = first;
            first = new node(item);
            first.next = oldFirst;
            oldFirst.previous = first;
        }

        size++;
        return true;
    }

    /*
     * Adds an item to the end of the list
     */
    public boolean addLast(Item item) {
        if (item == null) {
            return false;
        }
        if (last == null){ // Our list is currently empty
            last = new node(item);
            first = last;
        } else{
            node oldLast = last;
            last = new node(item);
            last.previous = oldLast;
            oldLast.next = last;
        }
        size++;
        return true;
    }

    /*
     * Removes the first item in the list
     */
    public Item removeFirst() {
        if (first == null) {
            return null;
        }
        Item firstItem = first.value;
        first = first.next;
        size--;
        return firstItem;
    }

    /*
     * Removes the last item in the list
     */
    public Item removeLast() {
        if (last == null) { // Our deque is empty
            return null;
        }

        Item lastValue = last.value;
        size--;

        if (last == first) { // Our deque has only 1 element left
            last = null;
            return lastValue;
        }

        last = last.previous;
        last.next = null;
        return lastValue;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if(current != null) {
                Item nextItem = current.value;
                current = current.next;
                return nextItem;
            }
            else {
                throw new NoSuchElementException();
            }
        }
    }
}
