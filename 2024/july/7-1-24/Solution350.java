import java.util.Arrays;

public class Solution350 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
		System.out.println(Arrays.toString(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
	}

	public static int[] intersect(int[] nums1, int[] nums2) {
		int[] arr = new int[1001];  // To count frequencies of elements in nums1
		int[] result = new int[1001];  // To store the result

		// Count the frequencies of each number in nums1
		for (int num : nums1) {
			arr[num]++;
		}

		int ctr = 0;  // Counter for the result array
		// Traverse nums2 to find common elements
		for (int num : nums2) {
			if (arr[num] > 0) {
				result[ctr++] = num;
				arr[num]--;
			}
		}

		// Return only the filled portion of the result array
		return Arrays.copyOfRange(result, 0, ctr);
	}
}
