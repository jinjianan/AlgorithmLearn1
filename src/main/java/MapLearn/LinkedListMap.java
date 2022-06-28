package MapLearn;

import linkedListLearn.LinkedList;

public class LinkedListMap<K,V> implements Map<K,V>{

    private class Node {
        private K key;
        private V value;
        private Node next;

        public Node(K key,V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node() {
            this(null,null, null);
        }

        public Node(K key,V value) {
            this(key,value, null);
        }

        @Override
        public String toString() {
            return "{ key = " + key + ", value =" + value + "}";
        }
    }
    Node dummyHead;
    int size;

    public LinkedListMap(){
        dummyHead = new Node();
        size = 0;
    }


    private Node getNode(K key){
        Node cur = dummyHead.next;
        while (cur !=null ){
            if (cur.key.equals(key))return cur;
            cur = cur.next;
        }
        return null;
    }


    @Override
    public boolean contains(K key) {
        return getNode(key) != null ;
    }


    @Override
    public V get(K key) {
        Node node = getNode(key);
        if (node != null)
            return node.value;
        return null;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node==null){
            dummyHead.next = new Node(key,value,dummyHead.next);
            size++;
        }
        else node.value = value;
    }


    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node == null)
            throw new IllegalArgumentException(key + "doesn't exist!");
        node.value = newValue;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(key);
        if (node == null)
            return null;
        Node cur = dummyHead;
        while (cur.next != node)
            cur = cur.next;
        cur.next = node.next;
        node.next = null;
        size--;
        return node.value;
    }


    @Override
    public int getSize() {
        return  size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
