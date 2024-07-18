import java.util.ArrayList;
import java.util.List;

public class Solution1441 {

	public List<String> buildArray(int[] target, int n) {
		int stack = 1;
		List<String> operations = new ArrayList<>();
		for (int num : target) {
			while (stack < num) {
				stack++;
				operations.add("Push");
				operations.add("Pop");
			}

			operations.add("Push");
			stack++;
		}

		return operations;
	}
}
