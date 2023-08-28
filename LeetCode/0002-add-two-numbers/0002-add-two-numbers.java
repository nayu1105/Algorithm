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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 초기화
        ListNode answer = new ListNode();
        answer.next = new ListNode();
        ListNode next = answer.next;

        int temp = 0;

        while(l1 != null || l2 != null){     
            next.next = new ListNode();
            next = next.next;     

            if(l1==null){
                temp += l2.val;
                l2 = l2.next;
            }else if(l2==null){
                temp += l1.val;
                l1 = l1.next;
            }
            else{
                temp += l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }

            next.val = temp%10;
            temp /= 10;
           
        }

        if(temp != 0){
            next.next = new ListNode();
            next = next.next;
            next.val = temp;
        }

        return answer.next.next;
    }
}