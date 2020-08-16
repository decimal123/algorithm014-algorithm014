class ListNode {        //类名 ：Java类就是一种自定义的数据结构
    int val;            //数据 ：节点数据
    ListNode next;      //对象 ：引用下一个节点对象。在Java中没有指针的概念，Java中的引用和C语言的指针类似

    ListNode(int val) {  //构造方法 ：构造方法和类名相同
        this.val = val;   //把接收的参数赋值给当前类的val变量
    }
}
public class Day4_swapPairs {
    // 24. 两两交换链表中的节点
    // https://leetcode-cn.com/problems/swap-nodes-in-pairs/submissions/
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while(temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }
}
