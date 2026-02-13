import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		// 자료구조 크기, x(n) return
		int structureSize = Integer.parseInt(br.readLine());

		// 자료 구조 타입, 0 = 큐, 1 = 스택
		st = new StringTokenizer(br.readLine());
		int[] structureType = new int[structureSize];

		for (int i = 0; i < structureSize; i++) {
			structureType[i] = Integer.parseInt(st.nextToken());
		}

		// 기존 자료구조 원소
		st = new StringTokenizer(br.readLine());
		Deque<Integer> queue = new ArrayDeque<>();

		for (int i = 0; i < structureSize; i++) {
			int num = Integer.parseInt(st.nextToken());

			// Queue = swap(FIFO), stack = 유지(LIFO)
			if (structureType[i] == 0) {
				queue.offer(num);
			}
		}

		// 삽입 데이터 길이
		int insertSize = Integer.parseInt(br.readLine());

		// 삽입 데이터
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < insertSize; i++) {
			int insert = Integer.parseInt(st.nextToken());

			queue.offerFirst(insert);
			bw.write(queue.pollLast() + " ");
		}

		bw.flush();

		br.close();
		bw.close();
	}
}