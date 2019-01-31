package JianzhiOffer66;


import java.util.ArrayList;
import java.util.Iterator;
public class No_3 {

    /**
     * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
     */


    /**
     * 方法一：
     * 思路：
     * 1、 遍历链表，每个元素都从头部放入数组中
     *
     * 缺点
     * 1、 每次都要移位，浪费时间
     */
    public static ArrayList<Integer>  printListFromTailToHead(ListNode listNode) {
        ListNode l = listNode;
        ArrayList<Integer> list = new ArrayList();
        while (l != null) {
            list.add(0,l.val);
            l=l.next;
        }
        Iterator<Integer> iterator = list.iterator();
        return list;
    }


    /**
     *方法二：
     * 思路：
     * 1、 利用递归，相当于数据先入后出
     *
     */
    static ArrayList<Integer> list = new ArrayList<>();

    public static ArrayList<Integer>  printListFromTailToHead0(ListNode listNode) {
        if (listNode.next != null) {
            printListFromTailToHead0(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        System.out.println(printListFromTailToHead(l1));
    }
}
