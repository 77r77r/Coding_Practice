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

	static void add(int num) {
		heap[size] = num;
		int i = size++;

		while (i > 0) {
			int root = (i - 1) / 2;

			if (Math.abs(heap[root]) < Math.abs(heap[i])) {
				break;
			}

			if (Math.abs(heap[root]) == Math.abs(heap[i])) {
				if (heap[root] < heap[i]) {
					break;
				}
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

		while (true) {
			int left = 2 * i + 1;
			int right = 2 * i + 2;
			int minimum = i;

			if (left < size &&
				Math.abs(heap[left]) < Math.abs(heap[minimum])) {
				minimum = left;
			}

			if (left < size &&
				Math.abs(heap[left]) == Math.abs(heap[minimum]) &&
				heap[left] < heap[minimum]) {
				minimum = left;
			}

			if (right < size &&
				Math.abs(heap[right]) < Math.abs(heap[minimum])) {
				minimum = right;
			}

			if (right < size &&
				Math.abs(heap[right]) == Math.abs(heap[minimum]) &&
				heap[right] < heap[minimum]) {
				minimum = right;
			}

			if (minimum == i) {
				break;
			}

			int temp = heap[minimum];
			heap[minimum] = heap[i];
			heap[i] = temp;

			i = minimum;
		}

		return max;
	}
}