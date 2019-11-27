package com.tk.algorithm.vector;

import lombok.Data;

@Data
public class MyVector<T> {

    private T[] data;
    private int capacity;
    private int size;

    public MyVector(int capacity) {
        data = (T[]) new Object[capacity];
        this.capacity = capacity;
        size = 0;
    }

    public MyVector() {
        data = (T[]) new Object[10];
        capacity = 10;
        size = 0;
    }
    private void resize(int newCapacity) {

        T[] newData = (T[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        data = newData;
        capacity = newCapacity;
    }

    public void pushBack(T e) {

        if (size == capacity) {
            resize(capacity * 2);
        }
        data[size++] = e;
    }

    public T popBack() {
        assert (size > 0);
        T ret = data[size-1];
        size--;
        if (size == capacity / 4 && capacity / 2 != 0) {
            resize(capacity / 2);
        }

        return ret;
    }

}
