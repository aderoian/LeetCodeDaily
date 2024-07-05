public class Solution2181 {

	public static void main(String[] args) {
		System.out.println(mergeNodes(new ListNode(0, new ListNode(3, new ListNode(1, new ListNode(0, new ListNode(4, new ListNode(5, new ListNode(2, new ListNode(0))))))))));
	}

	public static ListNode mergeNodes(ListNode head) {
		while (head.next.val != 0) {
			head.val += head.next.val;
			head.next = head.next.next;
		}

		if (head.next.next != null)
			head.next = mergeNodes(head.next);
		else head.next = null;

		return head;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

		@Override
		public String toString() {
			return "ListNode{val=" + val + ", next=" + next + "}";
		}
	}
}
