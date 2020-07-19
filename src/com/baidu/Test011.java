package com.baidu;

public class Test011 {
	public ListNode swapPairs(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		ListNode firstNode=head;
		ListNode secoNode=head.next;
		
		firstNode.next=secoNode.next;
		secoNode.next=firstNode;
		swapPairs(firstNode.next);
		return secoNode;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}