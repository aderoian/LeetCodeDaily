import java.util.Arrays;

public class Solution1701 {

	public static void main(String[] args) {
		System.out.println(averageWaitingTime(new int[][]{new int[]{1, 2}, new int[]{2, 5}, new int[]{4, 3}}));
	}

	public static double averageWaitingTime(int[][] customers) {
		double[] waitTimes = new double[customers.length];
		int currentTime = 0;
		int idleTime = 0;
		for (int i = 0; i < customers.length; i++) {
			int[] customer = customers[i];
			idleTime = Math.max(0, customer[0] - currentTime);
			currentTime += idleTime + customer[1];
			waitTimes[i] = (currentTime) - customer[0];
		}

		return Arrays.stream(waitTimes).sum() / waitTimes.length;
	}
}
