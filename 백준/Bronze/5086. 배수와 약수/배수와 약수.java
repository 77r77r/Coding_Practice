import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String type = "neither";

		while (true) {
			st = new StringTokenizer(br.readLine());

			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			if (n1 == 0 && n2 == 0) {
				break;
			}

			if (n1 != 0 && n2 % n1 == 0) {
				type = "factor";
			} else if (n2 != 0 && n1 % n2 == 0) {
				type = "multiple";
			} else {
				type = "neither";
			}

			bw.write(type + "\n");
		}

		br.close();
		bw.close();
	}
}