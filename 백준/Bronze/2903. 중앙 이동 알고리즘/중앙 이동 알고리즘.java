import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int point = 2;
		int cnt = 1;

		for (int i = 0; i < n; i++) {
			point += cnt;
			cnt *= 2;
		}

		bw.write(point * point +"");

		br.close();
		bw.close();
	}
}