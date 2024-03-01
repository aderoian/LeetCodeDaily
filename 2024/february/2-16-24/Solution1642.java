import java.util.PriorityQueue;

public class Solution1642 {

	public static void main(String[] args) {
		var solution = new Solution1642();
		System.out.println(solution.furthestBuilding(new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1));
		System.out.println(solution.furthestBuilding(new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2));
		System.out.println(solution.furthestBuilding(new int[]{14, 3, 19, 3}, 17, 0));
		System.out.println(solution.furthestBuilding(new int[]{1, 5, 1, 2, 3, 4, 10000}, 4, 1));
	}

	public int furthestBuilding(int[] heights, int bricks, int ladders) {
		PriorityQueue<Integer> p = new PriorityQueue<>((x, z) -> z - x);

		int i = 0, diff = 0;
		for (i = 0; i < heights.length - 1; i++) {
			diff = heights[i + 1] - heights[i];

			if (diff <= 0) {
				continue;
			}

			bricks -= diff;
			p.offer(diff);

			if (bricks < 0) {
				bricks += p.poll();
				ladders--;
			}

			if (ladders < 0) {
				break;
			}
		}

		return i;
	}
}
