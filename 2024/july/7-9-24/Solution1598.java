public class Solution1598 {

	public static void main(String[] args) {
		System.out.println(minOperations(new String[]{"d1/", "d2/", "../", "d21/", "./"}));
		System.out.println(minOperations(new String[]{"d1/", "d2/", "./", "d3/", "../", "d31/"}));
		System.out.println(minOperations(new String[]{"./", "wz4/", "../", "mj2/", "../", "../", "ik0/", "il7/"}));
	}

	public static int minOperations(String[] logs) {
		int depth = 0;
		for (String log : logs) {
			switch (log) {
				case "./":
					break;
				case "../":
					if (depth == 0) break;
					depth--;
					break;
				default:
					depth++;
			}
		}

		return depth;
	}
}
