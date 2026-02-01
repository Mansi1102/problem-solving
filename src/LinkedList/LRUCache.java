package LinkedList;

import java.util.HashMap;

class Node{
    int key;
    int val;
    Node prev;
    Node next;
    Node(int key, int val){
        this.key=key;
        this.val=val;
    }
}

public class LRUCache {

    public static void main(String[] args){
        String[] operations = {"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"};
        int[][] values = {{2}, {1, 1}, {2, 2}, {1}, {3, 3}, {2}, {4, 4}, {1}, {3}, {4}};

        LRUCache cache = null;
        StringBuilder output = new StringBuilder();
        output.append("[");
        for (int i = 0; i < operations.length; i++) {
            String op = operations[i];
            if ("LRUCache".equals(op)) {
                cache = new LRUCache(values[i][0]);
                output.append("null");
            } else if ("put".equals(op)) {
                cache.put(values[i][0], values[i][1]);
                output.append("null");
            } else if ("get".equals(op)) {
                output.append(cache.get(values[i][0]));
            }
            if (i < operations.length - 1) {
                output.append(", ");
            }
        }
        output.append("]");
        System.out.println(output.toString());
    }

    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    int cap;
    HashMap<Integer,Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        cap=capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }

        if(map.size()==cap){
            remove(tail.prev);
        }
        insert(new Node(key,value));
    }

    private void insert(Node node){
        map.put(node.key,node);
        node.next=head.next;
        node.next.prev=node;
        head.next=node;
        node.prev=head;
    }

    private void remove(Node node){
        map.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

