import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		PriorityQueue<Integer> backpack = new PriorityQueue<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		st = new StringTokenizer(br.readLine());

		int jewelCount = Integer.parseInt(st.nextToken());
		int backpackCount = Integer.parseInt(st.nextToken());

		int[][] jewelInfo = new int[jewelCount][2];

		for (int i = 0; i < jewelCount; i++) {
			st = new StringTokenizer(br.readLine());

			jewelInfo[i][0] = Integer.parseInt(st.nextToken());
			jewelInfo[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(jewelInfo, Comparator.comparingInt(a -> a[0]));

		for (int i = 0; i < backpackCount; i++) {
			backpack.add(Integer.parseInt(br.readLine()));
		}

		long value = 0;
		int k = 0;

		while (!backpack.isEmpty()) {
			int backWeight = backpack.poll();

			// 가방에 보석 넣기
			while (k < jewelCount && backWeight >= jewelInfo[k][0]) {
				pq.add(jewelInfo[k++][1]);
			}

			if (!pq.isEmpty()) {
				value += pq.poll();
			}
		}

		bw.write(String.valueOf(value));

		bw.flush();
		br.close();
		bw.close();
	}
}