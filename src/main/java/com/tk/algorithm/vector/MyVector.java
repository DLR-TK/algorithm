package com.tk.algorithm.vector;

import lombok.Data;

import java.lang.reflect.Array;

@Data
public class MyVector<T> {

    private T[] data;
    private int capacity;
    private int size;
    private Class type;

    public MyVector(Class<T> type) {
        data = (T[]) Array.newInstance(type, 10);
        capacity = 10;
        size = 0;
        this.type = type;
    }


    private void resize(int newCapacity) {

        T[] newData = (T[]) Array.newInstance(type, newCapacity);

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
        if (size == capacity / 4) {
            resize(capacity / 2);
        }

        return ret;
    }

}
