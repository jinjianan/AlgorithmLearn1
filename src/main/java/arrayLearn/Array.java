package arrayLearn;

import linear_search.LinearSearch;

public class Array<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] data;
    private int size;

    public Array(int capacity) {
        data = new Object[capacity];
        size = 0;
    }

    public Array() {
        this(DEFAULT_CAPACITY);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int capacity){
        Object[] newData = new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public void add(int index, T t) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("index illegal");

        if (size == data.length)
            resize( data.length * 2);

//        if (size - index >= 0) System.arraycopy(data, index, data, index + 1, size - index);
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = t;
        size++;
    }

    public void addFirst(T t) {
        add(0, t);
    }

    public void addLast(T t) {
        add(size, t);
    }

    @SuppressWarnings("unchecked")
    private T element(Object obj) {
        return (T) obj;
    }

    public T get(int index) {
        if (index >= size || index < 0)
            throw new IllegalArgumentException("index越界");
        return element(data[index]);
    }

    public void set(int index, T t) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("index illegal");
        data[index] = t;
    }

    public boolean contains(T t) {
        if (t == null) return false;
        return LinearSearch.search(data, t) >= 0;
    }

    public int indexOf(T t) {
        if (t == null) return -1;
        return LinearSearch.search(data, t);
    }

    public T remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("index illegal");

        T t = element(data[index]);
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
        if ( size == data.length / 2)
                resize( data.length / 2);
        return t;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size - 1);
    }

    public void removeElement(T t){
        int index = indexOf(t);
        if (index != -1)remove(index);
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size %d , capacity = %d \n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i].toString());
            if (i != size - 1)
                res.append(", ");
        }
        res.append("]");
        return res.toString();
    }

}
