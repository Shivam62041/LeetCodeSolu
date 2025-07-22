public class Solution {
    public ListNode detectCycle(ListNode head) {
        // Take a HashSet to store unique values and we are storing address of ListNodes which should be unique if there is no cycle.
        HashSet<ListNode> set = new HashSet<>();
        // Traverse elements of the list through the loop...
        // Insert current node inside the set and move forward.
        while (head != null && set.add(head)) {
            head = head.next;
        }
        // If node already present inside the set, It means we reach that node again then return that node.
        return head;
    }
}