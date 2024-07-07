public class Solution1518 {

	public static void main(String[] args) {
		System.out.println(numWaterBottles(9, 3));
	}

	public static int numWaterBottles(int numBottles, int numExchange) {
		int drank = numBottles;

		while (numBottles >= numExchange) {
			int exchanged = numBottles / numExchange;
			drank += exchanged;

			numBottles -= numExchange * exchanged;
			numBottles += exchanged;
		}

		return drank;
	}
}
