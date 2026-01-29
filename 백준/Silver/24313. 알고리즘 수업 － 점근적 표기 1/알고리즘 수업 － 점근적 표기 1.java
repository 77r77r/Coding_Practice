import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a1 = Integer.parseInt(st.nextToken());
		int a0 = Integer.parseInt(st.nextToken());

		int c = Integer.parseInt(br.readLine());
		int n0 = Integer.parseInt(br.readLine());

		// cn의 기울기가 f(n)보다 가파라야함

		if (c >= a1 && c * n0 >= a1 * n0 + a0) {
			bw.write("1");
		} else {
			bw.write("0");
		}

		br.close();
		bw.close();
	}
}