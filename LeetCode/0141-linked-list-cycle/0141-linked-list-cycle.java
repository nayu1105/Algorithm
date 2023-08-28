/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 import java.util.HashSet;

public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();
        if(head==null)return false;
        while(!visited.contains(head)){
            visited.add(head);
            head = head.next;
            if(head==null)return false;
        }
        return true;
    }
}