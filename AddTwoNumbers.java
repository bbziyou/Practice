/** 
 * Definition for singly-linked list. 
 * public class ListNode { 
 *     int val; 
 *     ListNode next; 
 *     ListNode(int x) { 
 *         val = x; 
 *         next = null; 
 *     } 
 * } 
 */ 
public class AddTwoNumbers { 
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) { 
         
        if (l1 == null && l2 == null) { 
            return null; 
        } 
         
        ListNode head = null; 
        ListNode curser = head; 
         
        int carry = 0; 
         
        while (l1 != null && l2 != null) { 
            int sum = l1.val + l2.val + carry; 
             
            if (head == null) { 
                head = new ListNode(sum % 10); 
                curser = head; 
            } else { 
                curser.next = new ListNode(sum % 10); 
                curser = curser.next; 
            } 
             
            carry = sum / 10; 
             
            l1 = l1.next; 
            l2 = l2.next; 
        } 
         
        while (l1 != null) { 
            int sum = l1.val + carry; 
             
            if (head == null) { 
                head = new ListNode(sum % 10); 
                curser = head; 
            } else { 
                curser.next = new ListNode(sum % 10); 
                curser = curser.next; 
            } 
             
            carry = sum / 10; 
             
            l1 = l1.next; 
        } 
         
        while (l2 != null) { 
            int sum = l2.val + carry; 
             
            if (head == null) { 
                head = new ListNode(sum % 10); 
                curser = head; 
            } else { 
                curser.next = new ListNode(sum % 10); 
                curser = curser.next; 
            } 
             
            carry = sum / 10; 
             
            l2 = l2.next; 
        } 
         
        if (carry != 0) { 
            curser.next = new ListNode(carry); 
        } 
         
        return head; 
    } 
}