import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		// 행렬 A
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] a = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 행렬 B
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] b = new int[m][k];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < k; j++) {
				b[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 행렬 곱
		int[][] arr = new int[n][k];

		// 1 2
		// 3 4
		// 5 6

		// -1 -2 0
		// 0 0 3

		for (int x = 0; x < n; x++) {
			for (int y = 0; y < k; y++) {
				for (int z = 0; z < m; z++) {
					arr[x][y] += (a[x][z] * b[z][y]);
				}
				/**
				 * arr[0][0] = (a[0][0] * b[0][0]) + (a[0][1] * b[1][0]);
				 * arr[0][1] = (a[0][0] * b[0][1]) + (a[0][1] * b[1][1]);
				 * arr[0][2] = (a[0][0] * b[0][2]) + (a[0][1] * b[1][2]);
				 */
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				bw.write(arr[i][j] + " ");
			}
			bw.newLine();
		}

		bw.flush();
		br.close();
		bw.close();
	}
}