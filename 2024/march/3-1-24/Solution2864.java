public class Solution2864 {

	public String maximumOddBinaryNumber(String s) {
		var freqMap = new int[]{0, 0};
		for (char c : s.toCharArray()) {
			if (c == '0') freqMap[0]++;
			else freqMap[1]++;
		}

		if (freqMap[1] == 1) {
			return "0".repeat(freqMap[0]) + "1";
		} else {
			return "1".repeat(freqMap[1] - 1) + "0".repeat(freqMap[0]) + "1";
		}
	}
}
