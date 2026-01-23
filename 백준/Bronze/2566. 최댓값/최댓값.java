import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int col = 0;
		int row = 0;
		int[][] arr = new int[9][9];

		int max = -1;

		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 9; j++) {
				int num = Integer.parseInt(st.nextToken());

				if (num >= max) {
					max = num;
					col = i;
					row = j;
				}
			}
		}

		bw.write(max +"\n" + ++col + " " + ++row);

		br.close();
		bw.close();
	}
}