/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast=head;
        while(--k>0) fast=fast.next;
        ListNode X=fast;

        ListNode slow=head;
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        ListNode Y=slow;

        int a=X.val;
        X.val=Y.val;
        Y.val=a;
        return head;
    }
}