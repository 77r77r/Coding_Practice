import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int[] stack = new int[100000];
		Arrays.fill(stack, 0);
		int point = -1;

		int repeat = Integer.parseInt(br.readLine());
		int total = 0;

		while (repeat-- > 0) {
			int num = Integer.parseInt(br.readLine());

			if (num != 0) {
				stack[++point] = num;
			} else {
				stack[point--] = 0;
			}
		}

		for (int n : stack) {
			total += n;
		}

		bw.write(String.valueOf(total));

		bw.flush();
		br.close();
		bw.close();
	}
}