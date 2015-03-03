package search.in.rotated.sorted.array.two;

public class SearchInRotatedSortedArrayTwo {
	public boolean search(int[] A, int target) {
		if (A.length < 1) {
			return false;
		}

		int s = 0;
		int e = A.length - 1;

		while (e >= s) {
			int mid = (s + e) / 2;
			if (A[mid] == target) {
				return true;
			} else {
				if (A[mid] > A[s]) {
					if (target < A[mid] && target >= A[s]) {
						e = mid - 1;
					} else {
						s = mid + 1;
					}
				} else if (A[mid] == A[s]) {
					s++;
				} else {
					if (target > A[mid] && target <= A[e]) {
						s = mid + 1;
					} else {
						e = mid - 1;
					}
				}
			}
		}
		return false;
	}
}
