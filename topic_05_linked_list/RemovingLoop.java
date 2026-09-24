package topic_05_linked_list;
/* Structure of Linked List Node
class Node {
    int data;
    Node next;
    Node(int val) {
        data = val;
        next = null;
    }
} */

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
  public static void removeLoop(Node head) {
    // code here
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {

        slow = head;

        // if cycle starts from head
        if (slow == fast) {
          while (fast.next != slow) {
            fast = fast.next;
          }

          fast.next = null;
          return;
        }

        while (slow.next != fast.next) {
          slow = slow.next;
          fast = fast.next;
        }

        fast.next = null;
        return;
      }
    }
  }
}