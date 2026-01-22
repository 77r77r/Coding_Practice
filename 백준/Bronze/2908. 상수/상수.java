import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		String[] s_num1 = st.nextToken().split("");
		String[] s_num2 = st.nextToken().split("");

		int num1 = snum_reverse(s_num1);
		int num2 = snum_reverse(s_num2);

		bw.write(Integer.toString(Math.max(num1, num2)));
		bw.close();
	}

	public static int snum_reverse(String[] num) {
		StringBuilder sb =  new StringBuilder();
		for (int i = 2; i >= 0; i--) {
			sb.append(num[i]);
		}
		
		return Integer.parseInt(sb.toString());
	}
}