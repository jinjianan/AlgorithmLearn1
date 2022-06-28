package MapLearn;

public class BSTMap<K extends Comparable<K>,V> implements Map<K,V>{

    private class Node {
        private K key;
        private V value;
        private Node left, right;

        public Node(K key,V value) {
            this.key =key;
            this.value = value;
            left = right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap(){
        root = null;
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(key, value,root);
    }

    private Node add(K key,V value,Node node){
        if (node == null) {
            size++;
            return new Node(key,value);
        }

        if (node.key.compareTo(key) == 0)
            node.value = value;
        else if (node.key.compareTo(key) > 0)
            node.left = add(key, value, node.left);
        else
            node.right = add(key, value, node.right);
        return node;
    }

    private Node getNode(K key){
        Node cur = root;
        while (cur != null){
            if (key.compareTo(cur.key) == 0) return cur;
            else if (key.compareTo(cur.key) < 0) cur = cur.left;
            else cur = cur.right;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        Node node = getNode(key);
        return node != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value ;
    }

    @Override
    public void set(K key, V newValue) {

        Node node = getNode(key);
        if (node!= null )
            node.value = newValue;
        else throw new IllegalArgumentException("key不存在");
    }

    @Override
    public V remove(K key) {
        Node node = getNode(key);
        if (node != null){
            root = remove(root,key);
            return node.value;
        }
        return null;
    }

    private Node min(Node node){
        if (node.left == null)
            return node;
        return min(node.left);
    }

    private Node remove(Node node, K key){
        System.out.println(node.key);
        if (node.key.compareTo(key) == 0){
            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            else if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            Node min = min(node.right);
            node.right = remove(node.right,min.key);
            node.key = min.key;
            node.value = min.value;
        }
        else if (node.key.compareTo(key) > 0)
            node.left = remove(node.left,key);
        else
            node.right = remove(node.right,key);
        return node;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
}
