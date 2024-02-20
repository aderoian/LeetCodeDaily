import java.util.ArrayList;
import java.util.List;

public class Solution830 {

	public static void main(String[] args) {
		var solution = new Solution830();
		System.out.println(solution.largeGroupPositions("abbxxxxzzy"));
		System.out.println(solution.largeGroupPositions("abc"));
		System.out.println(solution.largeGroupPositions("abcdddeeeeaabbbcd"));
		System.out.println(solution.largeGroupPositions("aaa"));
		System.out.println(solution.largeGroupPositions(""));
	}

	public List<List<Integer>> largeGroupPositions(String s) {
		List<List<Integer>> result = new ArrayList<>();
		if (s.isEmpty()) return result;

		var chars = s.toCharArray();
		Character currChar = chars[0];
		int currLength = 0;
		for (int i = 0; i < chars.length; i++) {
			if (!currChar.equals(chars[i])) {
				if (currLength > 2)
					result.add(List.of(i - currLength, i - 1));

				currChar = chars[i];
				currLength = 1;
			} else if (i == chars.length - 1) {
				currLength++;
				if (currLength > 2)
					result.add(List.of(i + 1 - currLength, i));
			} else currLength++;


		}

		//result.sort(Comparator.comparingInt(a -> a.get(1) - a.get(0)));
		return result;
	}
}
