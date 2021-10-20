package restAssuredBasicsOnline;

import java.util.HashMap;
import java.util.Map;

public class sand {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("{\"Rohith\":}");

		int a[] = { 1,2,3};
		int u = 3, v = 2, h = 5, mins = 0, minv = 0;
		Map<Integer, Integer> mp = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			minv = 0;
			if (a[i] < h && !mp.containsKey(i)) {
				for (int j = i + 1; j < a.length; j++) {
					int z = a[i] + a[j];
					System.out.println("----------------------jjjj---------" + z);
					if (z < h) {
						minv = u;
						mp.put(i, a[i]);
						mp.put(j, a[j]);
						System.out.println("-------------------------------" + u + "----" + mp + "----" + minv);
						break;
					}
				}
				// mins += v;
				System.out.println("---------ddfdfdfdfdf----------" + minv);
				if (minv != 0) {
					mins += minv;
				} else {
					mins += v;
				}

			}
		}

		System.out.println("---------min--------" + mins);

	}

}
