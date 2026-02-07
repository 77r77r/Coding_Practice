import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int size = Integer.parseInt(br.readLine());
		int[] arr = new int[size];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 정렬
		int[] sorted = Arrays.stream(arr).sorted().toArray();

		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;

		for (int i = 0; i < size; i++) {
			if (!map.containsKey(sorted[i])) {
				map.put(sorted[i], count++);
			}
		}

		for (int n : arr) {
			bw.write(map.get(n) + " ");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}