package subsetsum;

public abstract class ArrayInteger {

	static boolean isSubsetSum(int arr[], int n, int half) {

		if (half == 0) {
			return true;
		}
		if (n == 0 && half != 0) {
			return false;
		}

		if (arr[n - 1] > half) {
			return isSubsetSum(arr, n - 1, half);
		}

		return isSubsetSum(arr, n - 1, half) || isSubsetSum(arr, n - 1, half - arr[n - 1]);
	}

	static boolean getResult(int arr[]) {
		int n=arr.length;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}

		if (sum % 2 != 0) {
			return false;
		}

		return isSubsetSum(arr, n, sum / 2);
	}

	public static void main(String[] args) {
		int arr[] = {3,5,8,16};
		System.out.println(getResult(arr));
	}
}
