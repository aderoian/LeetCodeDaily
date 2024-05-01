class Solution {
	public String reversePrefix(String word, char ch) {
		int location = word.indexOf(ch);
		if (location == -1) return word;

		StringBuilder newReversed = new StringBuilder();
		for (int i = location; i >= 0; i--) {
			newReversed.append(word.charAt(i));
		}
		newReversed.append(word.substring(location + 1));
		return newReversed.toString();
	}
}