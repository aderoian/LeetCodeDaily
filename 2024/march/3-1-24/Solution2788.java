import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2788 {

	public static void main(String[] args) {
		var solution = new Solution2788();
		System.out.println(solution.splitWordsBySeparator(List.of("one.two.three", "four.five", "six"), '.'));
	}

	public List<String> splitWordsBySeparator(List<String> words, char separator) {
		var output = new ArrayList<String>();
		for (String word : words)
			output.addAll(Arrays.stream(word.split("\\" + separator)).filter(s -> !s.isEmpty()).toList());

		return output;
	}
}
