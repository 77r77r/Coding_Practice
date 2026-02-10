import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = Integer.parseInt(br.readLine());
		int[] stack = new int[size];
		int[] wait = new int[size];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < size; i++) {
			stack[i] = Integer.parseInt(st.nextToken());
		}

		int point = 0;
		int waitPoint = -1;

		int number = 1;

		boolean eat = true;

		while (true) {
			if (point <size && stack[point] == number) {
				point++;
				number++;
			} else if (waitPoint != -1 && wait[waitPoint] == number) {
				waitPoint--;
				number++;
			} else {
				wait[++waitPoint] = stack[point++];
			}

			if (number == size) {
				break;
			}

			if (point == size && wait[waitPoint] != number) {
				eat = false;
				break;
			}
		}

		if (eat) {
			bw.write("Nice");
		} else {
			bw.write("Sad");
		}

		bw.flush();
		br.close();
		bw.close();
	}
}