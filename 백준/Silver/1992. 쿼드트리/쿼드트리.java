import java.io.*;
import java.util.*;

class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] video = new int[n][n];

		if (n == 1) {
			sb.append(br.readLine());
		} else {
			for (int i = 0; i < n; i++) {
				char[] temp = br.readLine().toCharArray();
				for (int j = 0; j < n; j++) {
					video[i][j] = temp[j] - '0';
				}
			}

			compression(n, video);
		}

		bw.write(sb.toString());

		bw.flush();
		br.close();
		bw.close();
	}

	static void compression(int n, int[][] arr) {
		if (checkSame(arr)) {
			sb.append(arr[0][0]);
		} else {
			int size = n / 2;

			int[][] quadrant1 = new int[size][size];
			int[][] quadrant2 = new int[size][size];
			int[][] quadrant3 = new int[size][size];
			int[][] quadrant4 = new int[size][size];

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					quadrant1[i][j] = arr[i][j];
					quadrant2[i][j] = arr[i][j + size];
					quadrant3[i][j] = arr[i + size][j];
					quadrant4[i][j] = arr[i + size][j + size];
				}
			}

			sb.append("(");
			compression(size, quadrant1);
			compression(size, quadrant2);
			compression(size, quadrant3);
			compression(size, quadrant4);
			sb.append(")");
		}
	}

	static boolean checkSame(int[][] arr) {
		int first = arr[0][0];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (first != arr[i][j]) {
					return false;
				}
			}
		}

		return true;
	}
}