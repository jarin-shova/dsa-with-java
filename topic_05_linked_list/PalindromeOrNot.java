package topic_05_linked_list;
// Check if a Linked List is a palindrome

// Time complexity - O(n)
// Space complexity - O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode prevNode = head;
        ListNode currNode = head.next;

        while (currNode != null) {
            ListNode next = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = next;
        }
        head.next = null;
        head = prevNode;
        return head;
    }

    public boolean isPalindrome(ListNode head) {
        // 1 2 3 3 2 1
        ListNode mid = getMid(head);
        ListNode reversed = reverseList(mid.next);

        mid.next = null;

        ListNode curr1 = head;
        ListNode curr2 = reversed;
        while (curr1 != null && curr2 != null) {
            if (curr1.val != curr2.val) {
                return false;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return true;
    }
}
