class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (true) {
            ListNode end = prev;

            for (int i = 0; i < k; i++) {
                end = end.next;
                if (end == null) return dummy.next;
            }

            ListNode curr = prev.next;
            ListNode next = end.next;

            end.next = null;

            ListNode p = null;
            while (curr != null) {
                ListNode temp = curr.next;
                curr.next = p;
                p = curr;
                curr = temp;
            }

            prev.next = p;
            prev = head;
            head.next = next;
            head = next;
        }
    }
}