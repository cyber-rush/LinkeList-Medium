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
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null)return null;
        
        ListNode prev = null;
        ListNode curr = head;
        
        //Step 1 --> Reach till the left pointer 
        while(left > 1){
            prev = curr;
            curr = curr.next;
            left--;
            right--;
        }
        //one node before the starting node to reverse
        ListNode connection = prev;
        //The start node to reverse(making a note of it as we will need to join this to the next node to right)
        ListNode joinTail = curr;
        
        //Step 2 --> Reverse from left to right
        while(right > 0){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            right--;
        }
        
        //This condition checks whether the left pointer is not at 1
        if(connection != null){
            connection.next = prev;
        }
        else{
            head = prev;
        }
        
        joinTail.next = curr;
        
        return head;
    }
}