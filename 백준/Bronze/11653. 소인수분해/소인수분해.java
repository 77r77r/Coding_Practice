import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = Integer.parseInt(br.readLine());

		if (num != 1) {
			int temp = num;

			for (int i = 2; i * i <= temp; i++) {
				while (temp % i == 0) {
					bw.write(String.valueOf(i) + "\n");
					temp /= i;
				}
			}
			// for 다 돌아도 안 끝나면 어쩔껀데
			if (temp > 1) {
				bw.write(temp + "\n");
			}
		}

		br.close();
		bw.close();
	}
}