import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		var solution = new Solution();
		var result = solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
		for (var list : result) {
			System.out.println(list);
		}

		result = solution.groupAnagrams(new String[]{""});
		for (var list : result) {
			System.out.println(list);
		}

		result = solution.groupAnagrams(new String[]{"a"});
		for (var list : result) {
			System.out.println(list);
		}
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		var sortedWords = new HashMap<String, ArrayList<String>>();
		for (String str : strs) {
			var sortedWord = sortWord(str);
			if (!sortedWords.containsKey(sortedWord)) {
				sortedWords.put(sortedWord, new ArrayList<String>());
			}
			sortedWords.get(sortedWord).add(str);
		}

		return new ArrayList<>(sortedWords.values());
	}

	private String sortWord(String word) {
		var charArray = word.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}
}
