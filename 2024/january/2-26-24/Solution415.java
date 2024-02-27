public class Solution415 {

	public static void main(String[] args) {
		var solution = new Solution415();
		System.out.println(solution.addStrings("11", "123"));
		System.out.println(solution.addStrings("456", "77"));
		System.out.println(solution.addStrings("0", "0"));
	}

	public String addStrings(String num1, String num2) {
		StringBuilder output = new StringBuilder();
		int carry = 0;
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		while (i >= 0 || j >= 0) {
			int sum = carry;
			if (i >= 0) sum += num1.charAt(i--) - '0';
			if (j >= 0) sum += num2.charAt(j--) - '0';
			output.append(sum % 10);
			carry = sum / 10;
		}
		if (carry != 0) output.append(carry);
		return output.reverse().toString();
	}
}
