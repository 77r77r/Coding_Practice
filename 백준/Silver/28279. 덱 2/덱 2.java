import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int capacity = Integer.parseInt(br.readLine());

		int[] deque = new int[capacity];
		int front = 0;    // 현재 원소 위치
		int rear = 0;    // 다음 원소가 들어갈 위치
		int size = 0;

		for (int i = 0; i < capacity; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());

			switch (command) {
				case 1: // addFirst
					front = (front - 1 + capacity) % capacity;
					deque[front] = Integer.parseInt(st.nextToken());
					size++;
					break;
				case 2: // addLast
					deque[rear] = Integer.parseInt(st.nextToken());
					rear = (rear + 1) % capacity;
					size++;
					break;
				case 3: // removeFirst
					if (size == 0) {
						bw.write("-1\n");
						break;
					}
					bw.write(deque[front] + "\n");
					front = (front + 1) % capacity;
					size--;
					break;
				case 4: // removeLast
					if (size == 0) {
						bw.write("-1\n");
						break;
					}
					rear = (rear - 1 + capacity) % capacity;
					bw.write(deque[rear] + "\n");
					size--;
					break;
				case 5: // size
					bw.write(size + "\n");
					break;
				case 6: // empty
					if (size == 0) {
						bw.write("1\n");
						break;
					}
					bw.write("0\n");
					break;
				case 7: // peekFirst
					if (size == 0) {
						bw.write("-1\n");
						break;
					}
					bw.write(deque[front] + "\n");
					break;
				case 8: // peekLast
					if (size == 0) {
						bw.write("-1\n");
						break;
					}
					bw.write(deque[(rear - 1 + capacity) % capacity] + "\n");
					break;
				default:
					break;
			}
			bw.flush();
		}

		br.close();
		bw.close();
	}
}