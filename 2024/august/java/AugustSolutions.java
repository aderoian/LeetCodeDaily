public class AugustSolutions {

	/**
	 * Problem 1460
	 * Date: 08/02/2024
	 */
	public boolean canBeEqual(int[] target, int[] arr) {
		int[] freqMap = new int[1001];
		for (int i : target)
			freqMap[i]++;

		for (int i : arr) {
			freqMap[i]--;
			if (freqMap[i] < 0) return false;
		}

		return true;
	}
}
