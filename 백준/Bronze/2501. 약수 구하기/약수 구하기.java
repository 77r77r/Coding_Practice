import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int num = Integer.parseInt(st.nextToken());
		int order = Integer.parseInt(st.nextToken());

		int count = 0;
		int divisor = 0;

		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				count++;
				if (order == count) {
					divisor = i;
					break;
				}
			}
		}

		bw.write(String.valueOf(divisor));

		br.close();
		bw.close();
	}
}