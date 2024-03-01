import java.util.HashMap;
import java.util.Map;

public class Solution451 {

	public static void main(String[] args) {
		var solution = new Solution451();
		System.out.println(solution.frequencySort("tree"));
		System.out.println(solution.frequencySort("cccaaa"));
		System.out.println(solution.frequencySort("Aabb"));
	}

	public String frequencySort(String s) {
		Map<Character, Integer> charCount = new HashMap<>();
		for (char c : s.toCharArray()) {
			charCount.put(c, charCount.getOrDefault(c, 0) + 1);
		}

		StringBuilder sb = new StringBuilder();
		charCount.entrySet().stream()
				.sorted((e1, e2) -> e2.getValue() - e1.getValue())
				.forEach(e -> {
					sb.append(String.valueOf(e.getKey()).repeat(Math.max(0, e.getValue())));
				});

		return sb.toString();
	}
}
