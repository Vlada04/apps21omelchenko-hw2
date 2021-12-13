package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.Objects;

public final class ImmutableArrayList implements ImmutableList {
    private final Object[] array;

    public ImmutableArrayList(Object[] elements) {
        this.array = elements.clone();
    }

    public ImmutableArrayList() {
        this.array = new Object[0];
    }

    @Override
    public ImmutableList add(Object e) {
        return add(array.length, e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Object[] newList = Arrays.copyOf(this.array, this.array.length + 1);
        newList[index] = e;
        for (int i = index + 1; i < this.array.length + 1; i++){
            newList[i] = this.array[i - 1];
        }
        return new ImmutableArrayList(newList);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return this.addAll(this.array.length, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Object [] newList = Arrays.copyOf(this.array, this.array.length + c.length);
        for (int i = index; i < c.length + index; i++) {
            newList[i] = c[i - index];
        }
        for (int i = c.length + index; i < this.array.length + c.length; i++) {
            newList[i] = this.array[i - c.length];
        }
        return new ImmutableArrayList(newList);
    }

    @Override
    public Object get(int index) {
        return this.array[index];
    }

    @Override
    public ImmutableList remove(int index) {
        Object[] newList = Arrays.copyOf(this.array, this.array.length - 1);
        for (int i = index; i < this.array.length - 1; i++) {
            newList[i] = this.array[i+1];
        }
        return new ImmutableArrayList(newList);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        Object[] newList = Arrays.copyOf(this.array, this.array.length);
        newList[index] = e;
        return new ImmutableArrayList(newList);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.array.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.array, this.array.length);
    }
}
