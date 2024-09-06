package Strivers.StacksAndQueues.Hard;

import java.util.HashMap;
import java.util.Map;

public class LeastRecentlyUsedCache {
    class LRUCache {
        // Node class to represent each element in the doubly linked list
        private class Node {
            int key, val; // each node will store a key and a value
            Node next, prev; // pointers to the next and previous nodes in the list
            Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        Map<Integer, Node> map; // HashMap to store key -> node reference for quick access
        int capacity; // maximum capacity of the LRU cache
        Node head, tail; // dummy head and tail nodes to form the boundaries of the doubly linked list

        // Constructor to initialize the LRUCache with a given capacity
        LRUCache(int capacity) {
            this.capacity = capacity; // set the capacity of the cache
            map = new HashMap<>(capacity); // initialize the HashMap with the given capacity
            head = new Node(0, 0); // dummy head node
            tail = new Node(0, 0); // dummy tail node
            head.next = tail; // initially, head is connected to tail
            tail.prev = head; // tail is connected back to head
        }

        // Insert a new node right after the head (most recently used position)
        private void insert(Node node) {
            Node nextNode = head.next; // get the node currently after the head
            head.next = node; // set the new node after the head
            node.prev = head; // point new node's prev to head
            node.next = nextNode; // point new node's next to the previous head's next
            nextNode.prev = node; // update the nextNode's prev to the new node
        }

        // Remove a node from its current position in the doubly linked list
        private void remove(Node node) {
            Node nextNode = node.next; // get the next node
            Node prevNode = node.prev; // get the previous node
            prevNode.next = nextNode; // bypass the node to remove it
            nextNode.prev = prevNode; // update next node's prev to the previous node
        }

        // Get the value of the key if it exists in the cache, otherwise return -1
        public int get(int key) {
            if (map.containsKey(key)) { // if the key exists in the cache
                Node node = map.get(key); // get the corresponding node
                remove(node); // move the node to the front by removing it first
                insert(node); // reinsert it at the front (most recently used position)
                return node.val; // return the value of the node
            } else {
                return -1; // if key doesn't exist, return -1
            }
        }

        // Add a new key-value pair to the cache, or update the value if key already exists
        public void put(int key, int value) {
            if (map.containsKey(key)) { // if the key is already present in the cache
                Node node = map.get(key); // retrieve the corresponding node
                node.val = value; // update the node's value
                remove(node); // move the node to the front by removing it
                insert(node); // reinsert it at the front
            } else { // if the key is not present
                if (map.size() == capacity) { // check if the cache is full
                    Node lru = tail.prev; // get the least recently used node (second last node, before tail)
                    remove(lru); // remove it from the doubly linked list
                    map.remove(lru.key); // remove it from the map as well
                }
                Node newNode = new Node(key, value); // create a new node for the key-value pair
                map.put(key, newNode); // add the new node to the map
                insert(newNode); // insert the new node at the front (most recently used position)
            }
        }
    }
}
