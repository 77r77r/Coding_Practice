import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		long num1 = Integer.parseInt(st.nextToken());
		long num2 = Integer.parseInt(st.nextToken());
		long max = num1 > num2 ? num1 : num2;
		long min = num1 > num2 ? num2 : num1;
		long lcm = max;

		if (num1 == 0 || num2 == 0) {
			bw.write("0\n");
		} else if (num1 == num2) {
			bw.write(num1 + "\n");
		} else {
			while (true) {
				if (lcm % min == 0) {
					bw.write(lcm + "\n");
					break;
				}
				lcm += max;
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
}