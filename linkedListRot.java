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
    public int lastVal;

    public ListNode rotateRight(ListNode head, int k) {
        
        if(head==null){
            return head;
        }
        lastVal = head.val;
        k = k%(getCount(head));
        
        for(int i = 0; i<k; i++){
            rotateHelper(head, head.val, this.lastVal);
            head.val = this.lastVal;
        }
        return head;
    }
    int getCount(ListNode head)  
    {  
        int count = 0; // Initialize count  
        ListNode current = head; // Initialize current  
        while (current != null)  
        {  
            count++;  
            current = current.next;  
        }  
    return count;  
    }  
   void rotateHelper(ListNode currNode,int preVal,int lastVal){
        if( currNode.next != null){
            rotateHelper(currNode.next, currNode.val, lastVal);
        }
        if( currNode.next == null){
            this.lastVal = currNode.val;
        }
        currNode.val = preVal;
    }
}
