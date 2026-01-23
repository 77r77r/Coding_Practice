import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());

		int[][] arr = new int[col][row];

		int cnt = 0;

		for (int x = 0; x < col * 2; x++) {
			st = new StringTokenizer(br.readLine());
			cnt = cnt % col;

			for (int j = 0; j < row; j++) {
				arr[cnt][j] += Integer.parseInt(st.nextToken());
			}

			cnt++;
		}

		for (int k = 0; k < col; k++) {
			for (int l = 0; l < row; l++) {
				bw.write(arr[k][l] + " ");
			}
			bw.write("\n");
		}

		br.close();
		bw.close();
	}
}