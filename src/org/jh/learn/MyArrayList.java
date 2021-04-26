package org.jh.learn;

import java.util.Arrays;

/**
 * @author hjh
 * @version 1.0
 * @date 2021/4/26 23:27
 */
public class MyArrayList<T> {
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private Object[] elementData;

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public MyArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("非法初始化容量" + initialCapacity);
        }
    }

    public int size() {
        return size;
    }

    public boolean add(T t) {
        ensureCapacityInternal(size + 1);
        elementData[size++] = t;
        return true;
    }

    private void ensureCapacityInternal(int minCapacity) {
       if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
           minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
       }
        ensureExplicitCapacity(minCapacity);
    }

    private void ensureExplicitCapacity(int minCapacity) {
        if (minCapacity - elementData.length > 0) {
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        return minCapacity > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }
}

