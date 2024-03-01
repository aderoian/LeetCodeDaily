import java.util.LinkedList;

public class Solution20 {

	public static void main(String[] args) {
		var solution = new Solution20();
		System.out.println(solution.isValid("()"));
		System.out.println(solution.isValid("()[]{}"));
		System.out.println(solution.isValid("(]"));
		System.out.println(solution.isValid("([)]"));
	}

	public boolean isValid(String s) {
		var charOpenQueue = new LinkedList<Character>();
		var openFreq = new int[]{0, 0, 0};
		for (Character c : s.toCharArray()) {
			var first = charOpenQueue.peek();
			switch (c) {
				case '(':
					openFreq[0]++;
					charOpenQueue.addFirst(c);
					break;
				case '[':
					openFreq[1]++;
					charOpenQueue.addFirst(c);
					break;
				case '{':
					openFreq[2]++;
					charOpenQueue.addFirst(c);
					break;
				case ')':
					openFreq[0]--;
					if (!Character.valueOf('(').equals(first)) return false;
					else charOpenQueue.pollFirst();
					break;
				case ']':
					openFreq[1]--;
					if (!Character.valueOf('[').equals(first)) return false;
					else charOpenQueue.pollFirst();
					break;
				case '}':
					openFreq[2]--;
					if (!Character.valueOf('{').equals(first)) return false;
					else charOpenQueue.pollFirst();
					break;
			}

			if (openFreq[0] < 0 || openFreq[1] < 0 || openFreq[2] < 0) return false;
		}

		return charOpenQueue.isEmpty();
	}
}