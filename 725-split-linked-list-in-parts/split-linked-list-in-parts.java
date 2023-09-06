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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp = head;
        //Step 1-->Calculate the size of LL
        int n = 0;
        while(temp != null){
            n++;
            temp = temp.next;
        }
        
        //Step 2 --> Put elements into the LL
        
        ListNode [] ans = new ListNode[k];
        int len = n / k;
        int distribute = n % k;
        int i = 0;
        temp = head;
        ListNode prev = null;
        while(temp != null && i < k){
            ans[i] = temp;
            
            for(int j = 0;j < len + (distribute > 0 ? 1: 0); j++){
                prev = temp;
                temp = temp.next;
            }
            prev.next = null;
            i++;
            distribute--;
        }
        return ans;
        
    }
}