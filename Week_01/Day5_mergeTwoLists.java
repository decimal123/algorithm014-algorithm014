public class Day5_mergeTwoLists {
    // 21. 合并两个有序链表
    // https://leetcode-cn.com/problems/merge-two-sorted-lists/submissions/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode nl = node;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                nl.next = l1;
                l1 = l1.next;
            }else{
                nl.next = l2;
                l2 = l2.next;
            }
            nl = nl.next;
        }
        if(l1 != null){nl.next = l1;}else{nl.next = l2;}
        nl.next = l1 == null ? l2:l1;
        return node.next;
    }
}
