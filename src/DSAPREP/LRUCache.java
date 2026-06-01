package DSAPREP;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
  class Node {
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private int capacity;
  private Map<Integer, Node> map;
  private Node head;
  private Node tail;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.map = new HashMap<>();
    this.head = new Node(0, 0);
    this.tail = new Node(0, 0);
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    if(!map.containsKey(key)) {
      return -1;
    }
    Node node = map.get(key);
    remove(node);
    insertAtHead(node);
    return node.value;
  }

  public void put(int key, int value) {
    if(map.containsKey(key)) {
      Node existingNode = map.get(key);
      remove(existingNode);
    }
    Node newNode = new Node(key, value);
    map.put(key, newNode);
    insertAtHead(newNode);
    if(map.size() > capacity) {
      Node lru = tail.prev;
      remove(lru);
      map.remove(lru.key);
    }
  }

  private void remove(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  private void insertAtHead(Node node) {
    Node nextNode = head.next;
    head.next = node;
    node.prev = head;
    node.next = nextNode;
    nextNode.prev = node;
  }

}