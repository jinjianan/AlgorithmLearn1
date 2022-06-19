package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class BST<E extends Comparable<E>> {

    private class Node {
        private E e;
        private Node left, right;

        public Node(E e) {
            this.e = e;
            left = right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public void add(E e) {
        root = add(e, root);
    }

    private Node add(E e, Node node) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) > 0)
            node.right = add(e, node.right);
        else if (e.compareTo(node.e) < 0)
            node.left = add(e, node.left);
        return node;
    }

    /**
     * 非递归 添加元素
     *
     * @param e
     */
    public void addA(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
            return;
        }
        Node temp = root;
        while (true) {
            if (e.compareTo(temp.e) > 0) {
                if (temp.right == null) {
                    temp.right = new Node(e);
                    size++;
                    return;
                }
                temp = temp.right;
            } else if (e.compareTo(temp.e) < 0) {
                if (temp.left == null) {
                    temp.left = new Node(e);
                    size++;
                    return;
                }
                temp = temp.left;
            } else break;
        }

    }

    public boolean contains(E e) {
        return contains(e, root);
    }

    private boolean contains(E e, Node node) {
        if (node == null) return false;
        if (e.compareTo(node.e) == 0) return true;
        else if (e.compareTo(node.e) > 0) return contains(e, node.right);
        else return contains(e, node.left);
    }

    /**
     * 前序遍历
     *
     * @return
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrderNR() {
        if (root == null) return;
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            System.out.println(temp.e);
            if (temp.right != null)
                stack.push(temp.right);
            if (temp.left != null)
                stack.push(temp.left);
        }
    }

    public void levelOrder() {
        if (root == null) return;
        Deque<Node> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            System.out.print(cur.e + ",");
            if (cur.left != null) q.offer(cur.left);
            if (cur.right != null) q.offer(cur.right);
        }
    }

    public E min() {
        if (root == null) return null;
        Node cur = root;
        while (cur.left != null)
            cur = cur.left;
        return cur.e;
    }

    public E max() {
        if (root == null) return null;
        Node cur = root;
        while (cur.right != null)
            cur = cur.right;
        return cur.e;
    }

    public E removeMin() {
        if (size == 0) return null;
        E ret = min();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        if (size == 0) return null;
        E ret = max();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public E removeElement(E e) {
        if (contains(e)) {
            root = removeElement(e, root);
            return e;
        }
        return null;
    }

    private Node removeElement(E e, Node node) {
        if (node.e.compareTo(e) == 0) {
            if (node.left == null) {
                Node right = node.right;
                node.right = null;
                size--;
                return right;
            } else if (node.right == null) {
                Node left = node.left;
                node.left = null;
                size--;
                return left;
            } else // node left != null && right != null
            {
                Node cur = node.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                E min = cur.e;
                node.right = removeMin(node.right);
                node.e = min;
                return node;
            }
        } else if (node.e.compareTo(e) > 0)
            node.left = removeElement(e, node.left);
        else
            node.right = removeElement(e, node.right);

        return node;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
