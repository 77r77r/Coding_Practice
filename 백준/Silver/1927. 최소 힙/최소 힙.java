import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int n = Integer.parseInt(br.readLine());

		while (n-- > 0) {
			int num = Integer.parseInt(br.readLine());

			if (num == 0) {
				if (!pq.isEmpty()) {
					bw.write(pq.poll() +"\n");
				} else {
					bw.write("0\n");
				}
			} else {
				pq.add(num);
			}
		}

		bw.flush();
		br.close();
		bw.close();
	}
}