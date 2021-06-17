package leetcode.medium;


//Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

public class CopyRandomList {

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Node originCursor = head;
        if (originCursor == null) {
            return null;
        }
        Node result = null;

        result = copyNodeAndNext(originCursor);
        Node headResult = result;
        result = result.next;
        originCursor = originCursor.next;

        while (originCursor.next != null) {
            result = copyNodeAndNext(originCursor);
            result = result.next;
            originCursor = originCursor.next;
        }

        originCursor = head;

        while (originCursor.next != null) {
            result = headResult;
            findRandom(originCursor, result);
            originCursor = originCursor.next;
        }
        return headResult;
    }

    public Node copyNodeAndNext(Node origin) {
        Node copied = new Node(origin.val);
        Node copiedNext = null;
        if (origin.next != null) {
            copiedNext = new Node(origin.next.val);
            copiedNext.next = origin.next.next;
        }
        copied.next = copiedNext;
        return copied;
    }

    public void findRandom(Node origin, Node copied) {
        if (origin.random == null) {
            return;
        }
        int targetVal = origin.random.val;
        Node toCopy = null;
        Node temp = copied;
        while (temp.next != null) {
            if (copied.val == targetVal) {
                toCopy = temp;
                break;
            }
            temp = temp.next;
        }
        temp = copied;
        int originVal = origin.val;
        while (temp.next != null) {
            if (temp.val == originVal) {
                temp.random = toCopy;
                break;
            }
            temp = temp.next;
        }
    }
}
