package topic_05_linked_list;

// Time complexity - O(n)
// Space complexity - O(1)  
// find out the middle of a linked list
public class GetMiddle {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // head node
    Node head;

    // add
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }

        lastNode.next = newNode;
    }

    // get middle
    public void getMiddle() {
        Node slow = head;
        Node fast = head;

        if (fast != null && fast.next.next != null) {
            return;
        }

        while (slow != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("middle node is " + slow.data);
    }

    public static void main(String[] args) {
        GetMiddle list = new GetMiddle();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        list.getMiddle();
    }
}
