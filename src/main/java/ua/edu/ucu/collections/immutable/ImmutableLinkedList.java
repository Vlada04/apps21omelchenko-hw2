package ua.edu.ucu.collections.immutable;

public final class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private int size;

    public ImmutableLinkedList(Object[] elements) {
        for (Object elem : elements) {
            Node node = new Node();
            node.setValue(elem);
            this.head = node;
            size++;
        }
    }

    public ImmutableLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public ImmutableList add(Object e) {
        return add(this.size, e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[] {e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(this.size, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Object[] newList = new Object[this.size + c.length];
        Object[] currentList = this.toArray();
        System.arraycopy(currentList, 0, newList, 0, index);
        System.arraycopy(currentList, index, newList, index + c.length, this.size - index);
        System.arraycopy(c, 0, newList, index, c.length);
        return new ImmutableLinkedList(newList);
    }

    @Override
    public Object get(int index) {
        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    @Override
    public ImmutableList remove(int index) {
        Object[] newList = new Object[this.size - 1];
        Object[] currentList = this.toArray();
        System.arraycopy(currentList, 0, newList, 0, index);
        System.arraycopy(currentList, index + 1, newList, index, this.size - 1 - index);
        return new ImmutableLinkedList(newList);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        Object[] currentList = this.toArray();
        currentList[index] = e;
        return new ImmutableLinkedList(currentList);
    }

    @Override
    public int indexOf(Object e) {
        int i = 0;
        Node indexNode = this.head;
        while (indexNode != null) {
            if (indexNode.getValue() == e) {
                return i;
            }
            indexNode = indexNode.getNext();
            i++;
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] newList = new Object[this.size];
        if (this.size > 0) {
            Node current = this.head;
            for (int i = 0; i < this.size; i++) {
                newList[i] = current.getValue();
                current = current.getNext();
            }
        }
        return newList;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) add(e);
    }

//    public Node getHead() {
//        return getHead();
//    }

//    public Node getTail() {
//        return getTail();
//    }

    public Object getFirst() {
        return get(0);
    }

    public Object getLast() {
        return get(this.size - 1);
    }

    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) remove(this.size - 1);
    }
}
