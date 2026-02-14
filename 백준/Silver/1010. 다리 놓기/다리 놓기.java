import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int repeat = Integer.parseInt(br.readLine());

		while (repeat-- > 0) {
			st = new StringTokenizer(br.readLine());

			int west = Integer.parseInt(st.nextToken());
			int east = Integer.parseInt(st.nextToken());

			BigInteger valueE = new BigInteger("1");
			BigInteger valueW = new BigInteger("1");

			// 동쪽에서 서쪽 갯수 만큼 고르기
			if (west == east) {
				bw.write("1\n");
			} else {
				// 29! / (13! * (29 - 13)!)
				// k 와 n-k 중에 더 큰 쪽을 제외
				
				for (int i = (east - west + 1); i <= east; i++) {
					valueE = valueE.multiply(new BigInteger(String.valueOf(i)));
				}

				for (int i = 1; i <= west; i++) {
					valueW = valueW.multiply(new BigInteger(String.valueOf(i)));
				}

				bw.write(valueE.divide(valueW) + "\n");
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
}