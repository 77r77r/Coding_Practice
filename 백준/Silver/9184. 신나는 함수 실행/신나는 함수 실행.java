import java.io.*;
import java.util.*;

class Main {
	static int[][][] arr = new int[21][21][21];
	static boolean[][][] visited = new boolean[21][21][21];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		int a, b, c;
		arr[0][0][0] = 1;

		while (true) {
			st = new StringTokenizer(br.readLine());

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			if (a == -1 && b == -1 && c == -1) {
				break;
			}

			int result = w(a, b, c);

			bw.write("w(" + a + ", " + b + ", " + c + ") = " + result + "\n");
			bw.flush();
		}

		br.close();
		bw.close();
	}

	static int w(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}

		if (a > 20 || b > 20 || c > 20) {
			return w(20, 20, 20);
		}

		if (visited[a][b][c]) {
			return arr[a][b][c];
		}

		visited[a][b][c] = true;

		if (a < b && b < c) {
			arr[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		} else {
			arr[a][b][c] = w(a - 1, b, c)
				+ w(a - 1, b - 1, c)
				+ w(a - 1, b, c - 1)
				- w(a - 1, b - 1, c - 1);
		}

		return arr[a][b][c];
	}
}