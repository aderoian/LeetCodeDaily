import java.util.ArrayList;
import java.util.Arrays;

public class Solution2094 {

	public static void main(String[] args) {
		var solution = new Solution2094();
		System.out.println(Arrays.toString(solution.findEvenNumbers(new int[]{2, 1, 3, 0})));
		System.out.println(Arrays.toString(solution.findEvenNumbers(new int[]{2, 2, 8, 8, 2})));
	}

	public int[] findEvenNumbers(int[] digits) {
		ArrayList<Integer> output = new ArrayList<>();
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] == 0) continue;
			for (int j = 0; j < digits.length; j++) {
				if (i == j) continue;
				for (int k = 0; k < digits.length; k++) {
					if (j == k || i == k) continue;

					int number = Integer.parseInt("" + digits[i] + digits[j] + digits[k]);
					if (number % 2 == 0 && !output.contains(number)) output.add(number);
				}
			}
		}

		var outputArray = output.stream().mapToInt(i -> i).toArray();
		Arrays.sort(outputArray);
		return outputArray;
	}
}
