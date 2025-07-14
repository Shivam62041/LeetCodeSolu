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
 import java.util.Arrays;
class Solution {
    public ListNode sortList(ListNode head) {
        int count=1;
        ListNode temp=head;
        if(head==null) return null;
        else if(head.next==null) return head;
        // COUNTING NUMBER OF ELEMENTS
        while(temp.next!=null)
        {
            temp=temp.next;
            count++;
        }
        // CREATING ARRAY & STORING THE VALUES
        int arr[]=new int[count];
        temp=head;
        int i=0;
        while(temp.next!=null)
        {
            arr[i]=temp.val;
            i++;
            temp=temp.next;
        }
        arr[i]=temp.val;
        //SORTING THE ARRAY
        i=0;
        Arrays.sort(arr);
        // REPLACING THE VALUES INTO LINKED LIST
        temp=head;
        while(temp.next!=null)
        {
            temp.val=arr[i];
            i++;
            temp=temp.next;
        }
        temp.val=arr[i];

        return head;
    }
}