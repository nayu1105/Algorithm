public class Solution {
    public boolean hasCycle(ListNode head) {       
        if(head==null)return false;

        ListNode tor = head;
        ListNode hare = head;

        while(hare != null && hare.next != null){
            tor = tor.next;
            hare = hare.next.next;

            if(tor == hare)
            return true;
        }
        return false;
    }
}
