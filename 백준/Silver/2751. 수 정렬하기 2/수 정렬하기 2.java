import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = Integer.parseInt(br.readLine());
		int[] arr = new int[size];

		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		sort(arr, 0, size - 1);

		for (int num : arr) {
			bw.write(num + "\n");
		}

		br.close();
		bw.close();
	}

	static void sort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}

		int mid = (left + right) / 2;
		sort(arr, left, mid);
		sort(arr, mid + 1, right);

		int[] temp = new int[right - left + 1];
		int i = left;
		int j = mid + 1;
		int k = 0;

		while (i <= mid && j <= right) {
			temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
		}

		while (i <= mid) {
			temp[k++] = arr[i++];
		}

		while (j <= right) {
			temp[k++] = arr[j++];
		}

		System.arraycopy(temp, 0, arr, left, temp.length);
	}
}