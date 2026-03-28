import java.io.*;
import java.util.*;

class Main {
	static int[] heap;
	static int size = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		heap = new int[n * n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				add(Integer.parseInt(st.nextToken()));
			}
		}

		int value = 0;

		for (int i = 0; i < n; i++) {
			value = poll();
		}

		bw.write(String.valueOf(value));

		bw.flush();
		br.close();
		bw.close();
	}

	static void add(int n) {
		heap[size] = n;
		int i = size++;

		while (true) {
			int parent = (i - 1) / 2;
			int maximum = i;

			if (heap[parent] < heap[i]) {
				maximum = parent;
			}

			if (maximum == i) {
				break;
			}

			int temp = heap[parent];
			heap[parent] = heap[i];
			heap[i] = temp;

			i = parent;
		}
	}

	static int poll() {
		if (size == 0) {
			return 0;
		}

		int max = heap[0];
		size--;
		heap[0] = heap[size];

		int idx = 0;

		while (true) {
			int left = (idx * 2) + 1;
			int right = (idx * 2) + 2;
			int maximum = idx;

			if (left < size && heap[left] > heap[maximum]) {
				maximum = left;
			}

			if (right < size && heap[right] > heap[maximum]) {
				maximum = right;
			}

			if (maximum == idx) {
				break;
			}

			int temp = heap[maximum];
			heap[maximum] = heap[idx];
			heap[idx] = temp;

			idx = maximum;
		}

		return max;
	}
}