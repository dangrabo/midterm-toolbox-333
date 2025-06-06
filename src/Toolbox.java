import java.util.*;

public class Toolbox {

  /**
   * Finds the length of a singly linked list given the head.
   *
   * @param head the head node of the singly linked list
   * @return the number of nodes in the list
   * @throws IllegalArgumentException if the head is null
   */
  public static int length(SingleNode head) {
    if (head == null) {
      throw new IllegalArgumentException("Head cannot be null.");
    }
    int count = 0;
    SingleNode current = head;
    while (current != null) {
      count++;
      current = current.next;
    }
    return count; 
  }

  /**
   * Finds the tail of a singly linked list given the head.
   *
   * @param head the head node of the singly linked list
   * @return the tail node of the list, or null if the list is empty
   * @throws IllegalArgumentException if the head is null
   */
  public static SingleNode findTail(SingleNode head) {
    if (head == null) {
      throw new IllegalArgumentException("Head cannot be null.");
    }
    SingleNode current = head;
    while (current.next != null) {
      current = current.next;
    }
    return current; 
  }

  /**
   * Finds the head of a doubly linked list given the tail.
   *
   * @param tail the tail node of the doubly linked list
   * @return the head node of the list, or null if the list is empty
   * @throws IllegalArgumentException if the tail is null
   */
  public static DoubleNode findHead(DoubleNode tail) {
    if (tail == null) {
      throw new IllegalArgumentException("Tail cannot be null.");
    }
    DoubleNode current = tail;
    while (current.prev != null) {
      current = current.prev;
    }
    return current; 
  }

  /**
   * Counts the occurrences of values in a linked list.
   *
   * @param head the head node of the linked list
   * @return a map where the keys are the values in the list, and the values are the counts of occurrences
   * @throws IllegalArgumentException if the head is null
   */
  public static Map<Integer, Integer> countOccurrences(SingleNode head) {
    if (head == null) {
      throw new IllegalArgumentException("Head cannot be null.");
    }
    Map<Integer, Integer> map = new HashMap<>();
    SingleNode current = head;
    while (current != null) {
      if (!map.containsKey(current.data)) {
        map.put(current.data, 1);
      } else {
        map.put(current.data, map.get(current.data) + 1);
      }
      current = current.next;
    }
    return map; 
  }

  /**
   * Removes a node from a doubly linked list.
   *
   * @param node the node to remove
   * @throws IllegalArgumentException if the node is null
   */
  public static void removeNode(DoubleNode node) {
    if (node == null) {
      throw new IllegalArgumentException("Node cannot be null.");
    }
    if (node.next == null && node.prev == null) {
      node = null;
    }
    else if (node.prev == null) {
      node.next.prev = null;
    }
    else if (node.next == null) {
      node.prev.next = null;
    }
    else {
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }
    
  }

  /**
   * Finds the nth element in a singly linked list.
   *
   * @param head the head node of the singly linked list
   * @param n the index of the element to find (0-based)
   * @return the nth node, or null if the index is out of bounds
   * @throws IllegalArgumentException if the head is null or n is negative
   */
  public static SingleNode findNthElement(SingleNode head, int n) {
    if (head == null || n < 0) {
      throw new IllegalArgumentException("Head cannot be null and n cannot be negative.");
    }
    SingleNode current = head;
    int i = 0;
    while (i < n && current != null) {
      current = current.next;
      i++;
    }
    if (current != null) {
      return current;
    }
    else {
      return null;
    }
    
  }

  /**
   * Inserts a new node into a singly linked list given a pointer to a node in the middle of the list.
   *
   * @param node the node after which the new node is to be inserted
   * @param newNode the new node to insert
   * @throws IllegalArgumentException if either node or newNode is null
   */
  public static void insertNode(SingleNode node, SingleNode newNode) {
    if (node == null || newNode == null) {
      throw new IllegalArgumentException("Node and newNode cannot be null.");
    }
    newNode.next = node.next;
    node.next = newNode;
  }

  /**
   * Removes all nodes that are strictly larger than their next neighbor in the original list, except for the head.
   * The head is never removed.
   * 
   * The removals are done in-place.
   * 
   * Example:
   * Input: 5 -> 7 -> 6 -> 20 -> 4 -> 4
   * Output: 5 -> 6 -> 4 -> 4
   * 
   * Explanation: 7 is greater than 6 and 20 is greater than 4, so these nodes are removed.
   *
   * @param head the head of the list
   * @throws IllegalArgumentException if the head is null
   */
  public static void removeGiants(SingleNode head) {
    if (head == null) {
      throw new IllegalArgumentException("Head cannot be null.");
    }
    if (head.next == null) {
      return;
    }
    SingleNode current = head.next;
    SingleNode prev = head;
    while (current.next != null) {
      if (current.data > current.next.data) {
        prev.next = current.next;
      } else {
        prev = current;
      }
      current = current.next;
    }
  }


    /**
     * Triples the value of every element in a queue in-place.
     * 
     * Only O(1) space should be used.
     * 
     * You can assume the queue will have first-in-first-out behavior.
     *
     * Example:
     * Input: [5, 3, 2, 7] 
     * Result: [15, 9, 6, 21]
     *
     * @param queue the queue to modify
     * @throws IllegalArgumentException if the queue is null
     */
    public static void tripleValues(Queue<Integer> queue) {
      if (queue == null) {
        throw new IllegalArgumentException("Queue cannot be null");
      }
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int current = queue.poll();
        current *= 3;
        queue.offer(current);
      }
    }


  /**
   * Rotates a queue to the left by the specified number of positions in-place.
   * 
   * The first k elements of the queue are moved to the end, preserving the order
   * of all elements.
   * 
   * Only O(1) space should be used.
   * 
   * You can assume the queue will have first-in-first-out behavior.
   *
   * Example:
   * Given a queue [1, 2, 3, 4, 5] and k = 2, the result will be [3, 4, 5, 1, 2].
   *
   * @param queue the queue to rotate
   * @param k the number of positions to rotate to the left
   * @throws IllegalArgumentException if the queue is null or k is negative
   */
  public static void rotateQueueLeft(Queue<Integer> queue, int k) {
    if (queue == null || k < 0) {
      throw new IllegalArgumentException("Queue cannot be null and k cannot be negative.");
    }
    for (int i = 0; i < k; i++) {
      int current = queue.poll();
      queue.offer(current);
    }
  }

  /**
   * Checks if a string has balanced parentheses using a stack.
   * 
   * A string is considered to have balanced parentheses if each opening parenthesis
   * '(' has a corresponding closing parenthesis ')', and the parentheses are correctly nested.
   *
   * Example:
   * - Input: "(()())" -> Returns true
   * - Input: "(()" -> Returns false
   * - Input: ")" -> Returns false
   *
   * @param input the string to check
   * @return true if the string has balanced parentheses, false otherwise
   * @throws IllegalArgumentException if the input string is null
   */
  public static boolean hasBalancedParentheses(String s) {
    if (s == null) {
      throw new IllegalArgumentException("Input string cannot be null.");
    }
    Stack<Character> stack = new Stack<>();
    if (s.length() == 0) {
        return true;
    }
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
            stack.push(s.charAt(i));
        }
        else if (stack.isEmpty()) {
            return false;
        }
        else if (s.charAt(i) == ')') {
            if (stack.pop() != '(') {
                return false;
            }
        }
        else if (s.charAt(i) == '}') {
            if (stack.pop() != '{') {
                return false;
            }
        }
        else if (s.charAt(i) == ']') {
            if (stack.pop() != '[') {
                return false;
            }
        }
    }
    if (stack.size() == 0) {
        return true;
    }
    return false;
  }

  /**
   * Returns the name of the person who has the highest score associated with them in a map.
   * 
   * The keys hold the names of the players and the values hold the scores. 
   * 
   * For example: 
   * {
   *  "Lewis": 20,
   *  "Yuki": 23,
   *  "Kimi": 16
   * }
   * 
   * Yuki has the highest score.
   * 
   * In the event of a tie, the person whose name comes first lexicographically (alphabetically) should
   * be returned.
   * 
   * @param scores
   * @return the person with the highest score, or the first person lexicographically if there is a tie
   * @throws IllegalArgumentException if the scores are null or empty
   */
  public static String topScorer(Map<String, Integer> scores) {
    if (scores == null || scores.isEmpty()) {
      throw new IllegalArgumentException("Scares cannot be null or empty");
    }
    String highName = "";
    int highScore = 0;
    for (String name : scores.keySet()) {
      if (scores.get(name) > highScore) {
        highName = name;
        highScore = scores.get(name);
      }
      else if (scores.get(name) == highScore) {
        if (highName.compareToIgnoreCase(name) > 0) {
          highName = name;
          highScore = scores.get(name);
        }
      }
    }
    return highName;
  }
}