package heap;

import arrayLearn.Array;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(){
        data = new Array<>();
    }

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for (int i = parent(arr.length-1); i >=0 ; i--)
            siftDown(i);
    }

    public int size(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return  data.isEmpty();
    }

    private int parent(int index){
        if (index == 0) throw new IllegalArgumentException("No parent");
        return (index-1) / 2;
    }

    private int left(int index){
        return index * 2 + 1;
    }

    private int right(int index){
        return index * 2 + 2;
    }

    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize()-1);
    }

    private void siftUp(int index){
        while (index > 0 && data.get(parent(index)).compareTo(data.get(index)) < 0){
            data.swap(parent(index),index);
            index = parent(index);
        }
    }

    public E findMax(){
        if (size() == 0)
            throw new IllegalArgumentException("size 0 , no max");
        return data.get(0);
    }

    public E extractMax(){
        E r = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return r;
    }

    private void siftDown(int index){
        while (left(index) < size()){
            int j = left(index);
            if (j + 1 <size() && data.get(j+1).compareTo(data.get(j)) > 0)
                j++;

            if (data.get(j).compareTo(data.get(index)) < 0)
                break;

            data.swap(j,index);
            index = j;
        }
    }

    public E replace(E e){
        E res = findMax();
        data.set(0,e);
        siftDown(0);
        return res;
    }

}
