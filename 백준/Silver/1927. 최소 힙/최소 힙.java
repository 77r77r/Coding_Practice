import java.io.*;
import java.util.*;

class Main {
	static int[] heap;
	static int size = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		heap = new int[n];

		while (n-- > 0) {
			int num = Integer.parseInt(br.readLine());

			if (num == 0) {
				bw.write(poll() + "\n");
			} else {
				add(num);
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}

	static void add(int value) {
		heap[size] = value;
		int i = size++;

		while (i > 0) {
			int root = (i - 1) / 2;

			if (heap[root] <= heap[i]) {
				break;
			}

			int temp = heap[root];
			heap[root] = heap[i];
			heap[i] = temp;

			i = root;
		}
	}

	static int poll() {
		if (size == 0) {
			return 0;
		}

		int max = heap[0];

		heap[0] = heap[size - 1];
		size--;

		int i = 0;

		// 정렬
		while (true) {
			int left = 2 * i + 1;
			int right = 2 * i + 2;
			int min = i;

			if (left < size && heap[left] < heap[min]) {
				min = left;
			}

			if (right < size && heap[right] < heap[min]) {
				min = right;
			}

			// 변화 없음
			if (min == i) {
				break;
			}

			int temp = heap[i];
			heap[i] = heap[min];
			heap[min] = temp;

			i = min;
		}

		return max;
	}
}