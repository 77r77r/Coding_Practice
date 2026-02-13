import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int capacity = Integer.parseInt(br.readLine());
		int[] q = new int[capacity];
		int front = 0;    // 현재 위치
		int rear = 0;    // 넣을 위치
		int size = 0;

		for (int i = 0; i < capacity; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();

			switch (command) {
				case "1":
					front = (front - 1 + capacity) % capacity;
					q[front] = Integer.parseInt(st.nextToken());
					size++;
					break;
				case "2":
					q[rear] = Integer.parseInt((st.nextToken()));
					rear = (rear + 1) % capacity;
					size++;
					break;
				case "3":
					if (size == 0) {
						bw.write("-1\n");
						break;
					}

					bw.write(q[front] + "\n");
					front = (front + 1) % capacity;
					size--;
					break;
				case "4":
					if (size == 0) {
						bw.write("-1\n");
						break;
					}
					rear = (rear - 1 + capacity) % capacity;
					bw.write(q[rear] + "\n");
					size--;
					break;
				case "5":
					bw.write(size + "\n");
					break;
				case "6":
					bw.write(size == 0 ? "1\n" : "0\n");
					break;
				case "7":
					if (size == 0) {
						bw.write("-1\n");
						break;
					}
					bw.write(q[front] + "\n");
					break;
				case "8":
					if (size == 0) {
						bw.write("-1\n");
						break;
					}
					bw.write(q[(rear - 1 + capacity) % capacity] + "\n");
					break;
			}
		}

		bw.flush();

		br.close();
		bw.close();
	}
}