import java.util.Arrays;

public class Solution804 {

	private final String[] morseCodes = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
			"--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

	public static void main(String[] args) {
		var solution = new Solution804();
		System.out.println(solution.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
	}

	public int uniqueMorseRepresentations(String[] words) {
		var morseWords = new String[words.length];
		for (int i = 0; i < words.length; i++) {
			var morseWord = new StringBuilder();
			for (int j = 0; j < words[i].length(); j++) {
				morseWord.append(morseCodes[words[i].charAt(j) - 'a']);
			}
			morseWords[i] = morseWord.toString();
		}

		return (int) Arrays.stream(morseWords).distinct().count();
	}
}
