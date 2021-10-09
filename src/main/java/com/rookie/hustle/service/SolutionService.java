package com.rookie.hustle.service;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author houzhongbo
 * @Date 2021/8/17 11:19 下午
 * @Version 1.0
 **/
public class SolutionService {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { this.val = x; this.next = null; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //hash方法，将遍历过的节点存储到hashset中
    public ListNode getIntersectionNodeHash(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode tmp = headA;
        while (tmp != null) {
            set.add(tmp);
            tmp = tmp.next;
        }
        tmp = headB;
        while (tmp != null) {
            if (set.contains(tmp)) {
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }

    //返回链表A、B的公共节点，遍历完当前链表再将指针转移到另外一个链表的头节点上
    //指针节点相等的时候返回，有公共节点返回公共节点，否则返回null
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmpA = headA;
        ListNode tmpB = headB;

        while (tmpA != tmpB) {
            tmpA = tmpA != null ? tmpA.next : headB;
            tmpB = tmpB != null ? tmpB.next : headA;
        }

        return tmpA;
    }

    //单链表删除倒数第N个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //双指针，第一个指针i先走n步，当指针i到末尾时，指针j就是倒数第n个节点
        ListNode tmpA = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tmpB = dummy;
        for (int i = 0; i < n; i++) {
            tmpA = tmpA.next;
        }
        while (tmpA != null) {
            tmpA = tmpA.next;
            tmpB = tmpB.next;
        }
        tmpB.next = tmpB.next == null ? null : tmpB.next.next;
        return dummy.next;
    }

    //删除排序链表中重复的元素
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        ListNode last = dummy.next;
        while (last != null) {
            if (last.next != null && last.val == last.next.val) {
                while (last.next != null && last.val == last.next.val) {
                    last = last.next;
                }
                cur.next = last.next;
            } else {
                cur = cur.next;
            }
            last = last.next;
        }
        return dummy.next;
    }

    //判断链表是否有环
    public ListNode detectCycle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        ListNode fast = head.next;
        ListNode low = head;
        while (low != fast) {
            fast = fast == null ? null : (fast.next == null ? null : fast.next.next);
            low = low.next;
        }

        return fast == null ? null : fast.next;
    }

    @Test
    public void test() {
        ListNode node = new ListNode(8);
        node.next = new ListNode(4);
        node.next.next = new ListNode(5);

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = node;

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = node;

        //ListNode intersectionNode = getIntersectionNode(headA, headB);
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        //ListNode listNode = removeNthFromEnd(head, 2);

        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(0);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = listNode.next;
        ListNode cycle = detectCycle(listNode);
        System.out.println(cycle);
    }
}
