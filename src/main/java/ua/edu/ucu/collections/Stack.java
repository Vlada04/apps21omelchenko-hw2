package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList linkedList;

    public void push(Object e) {
        linkedList = linkedList.addLast(e);
    }

    public Object pop() {
        Object obj = this.peek();
        linkedList = linkedList.removeLast();
        return obj;
    }

    public Object peek() {
        return linkedList.getLast();
    }
}
