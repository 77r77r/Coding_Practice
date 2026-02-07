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

		mergeSort(arr, 0, size - 1);

		for (int n : arr) {
			bw.write(n + "\n");
		}
        
        bw.flush();

		br.close();
		bw.close();
	}

	static void mergeSort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}

		int mid = (left + right) / 2;
		mergeSort(arr, left, mid);
		mergeSort(arr, mid + 1, right);

		int temp[] = new int[right - left + 1];
		int i = left, j = mid + 1, k = 0;

		while (i <= mid && j <= right) {
			//temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
		}

		while (i <= mid) {
			temp[k++] = arr[i++];
		}

		while (j <= right) {
			temp[k++] = arr[j++];
		}

		// System.arraycopy(temp, 0, arr, left, temp.length);
		for (int t = 0; t < temp.length; t++) {
			arr[left + t] = temp[t];
		}
	}
}