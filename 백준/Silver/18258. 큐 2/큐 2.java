import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int size = Integer.parseInt(br.readLine());
		Queue queue = new Queue(size);

		while (size-- > 0) {
			st = new StringTokenizer(br.readLine());

			String command = st.nextToken();

			switch (command) {
				case "push":
					queue.push(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					bw.write(queue.pop() + "\n");
					break;
				case "size":
					bw.write(queue.size() + "\n");
					break;
				case "empty":
					bw.write(queue.empty() + "\n");
					break;
				case "front":
					bw.write(queue.front() + "\n");
					break;
				case "back":
					bw.write(queue.back() + "\n");
					break;
				default:
					break;
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}

	static class Queue {

		int[] queue;
		int rear = -1;    // 삽입
		int front = -1;    // 출력

		Queue(int size) {
			queue = new int[size];
		}

		void push(int value) {
			queue[++rear] = value;
		}

		int pop() {
			if (rear == -1 || rear == front) {
				return -1;
			}

			return queue[++front];
		}

		int size() {
			if (rear == -1 ) {
				return 0;
			}
			return (rear - front);
		}

		int empty() {
			if (front == rear || rear == -1) {
				return 1;
			}

			return 0;
		}

		int front() {
			if (front == rear || rear == -1) {
				return -1;
			}

			return queue[front + 1];
		}

		int back() {
			if (front == rear || rear == -1) {
				return -1;
			}

			return queue[rear];
		}

	}
}