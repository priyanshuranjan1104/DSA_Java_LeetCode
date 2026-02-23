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
    public boolean isPalindrome(ListNode head) {
      if(head == null || head.next == null){
        return true;
      }  

    ListNode slow = head;
    ListNode fast = head;
    while(fast!=null && fast.next != null ){
        slow = slow.next;
        fast = fast.next.next;
    }
    ListNode previous = null;
    while(slow!=null){
        ListNode nextNode = slow.next;
        slow.next = previous;
        previous = slow;
        slow = nextNode;
    }
    ListNode p = head;
    ListNode q = previous;
    while(q!=null){
        if(p.val!=q.val)
        return false;
        p=p.next;
        q=q.next;
    }
    return true;
    }
}